package com.adv.rappichallenge.Activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.adv.rappichallenge.Adapters.Entry_list;
import com.adv.rappichallenge.R;
import com.adv.rappichallenge.Reader.ReaderService;
import com.adv.rappichallenge.Services.SyncData;
import com.adv.rappichallenge.interfaces.OnSelect_Listener;
import com.adv.rappichallenge.models.Feed;
import com.adv.rappichallenge.models.Root;
import com.adv.rappichallenge.repositories.SQL;

import static com.adv.rappichallenge.helpers.Const.LOCAL_CONNETION;
import static com.adv.rappichallenge.helpers.Const.SERVICE_CONNETION;


public class MainActivity extends BaseActivity {
    private TextView textConnectionState;
    private LinearLayout linearOffline;
    private ListView list;
    private GridView grid;

    private Entry_list adapter;

    private int connetion_type = LOCAL_CONNETION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       registerReceiver(mReceiver, new IntentFilter("event"));

       initUI();

    }

    private void initUI(){
        textConnectionState = (TextView) findViewById(R.id.textConnectionState);
        linearOffline = (LinearLayout) findViewById(R.id.linearOffline);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(OnItemClick);

        grid = (GridView) findViewById(R.id.grid);
        grid.setOnItemClickListener(OnItemClick);

    }

    private void bound_list(){
        reader.getFeeds(new OnSelect_Listener() {
            @Override
            public void onStart() {
                progress.show();
            }

            @Override
            public void onComplete(Object object) {
                progress.dismiss();
                Feed feed = ((Root) object).getFeed();

                if(!getResources().getBoolean(R.bool.isTablet)){
                    adapter = new Entry_list(MainActivity.this, feed.getEntries(), R.layout.item_feed_land);
                    list.setAdapter(adapter);
                    list.setVisibility(View.VISIBLE);
                    grid.setVisibility(View.GONE);
                }else{
                    adapter = new Entry_list(MainActivity.this, feed.getEntries(), R.layout.item_feed_port);
                    grid.setAdapter(adapter);
                    list.setVisibility(View.GONE);
                    grid.setVisibility(View.VISIBLE);
                }

                //Si los datos fueron devueltos por el servicio web actualiza la replica local..
                if(connetion_type == SERVICE_CONNETION) {
                    updateLocalData runner = new updateLocalData();
                    runner.execute(feed);
                }


                UIHandleConnection();
            }

            @Override
            public void onError() {
                //En caso de que haya ocurrido un error en el servicio web cambia el tipo de conexión a local
                if(connetion_type == SERVICE_CONNETION){
                    connetion_type = LOCAL_CONNETION;
                    reader.set_iDataRepository(SQL.getInstance(MainActivity.this));
                    bound_list();
                }else {
                    progress.dismiss();
                    showToast("Error");
                }
            }
        });
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            reader = ReaderService.getSingleton();
            connetion_type = intent.getIntExtra("connetion_type", LOCAL_CONNETION);
            UIHandleConnection();
            bound_list();
        }
    };

    private AdapterView.OnItemClickListener OnItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("Entry", adapter.getItem(i));
            startActivity(intent);
        }
    };

    private void UIHandleConnection(){
        if(connetion_type == LOCAL_CONNETION){
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.down_from_top);

            linearOffline.startAnimation(anim);
            linearOffline.setVisibility(View.VISIBLE);
            textConnectionState.setText(getString(R.string.global_offline));

        }else{
            linearOffline.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(new Intent(this, SyncData.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(new Intent(this, SyncData.class));
    }

    private class updateLocalData extends AsyncTask<Feed, String, String> {
        private NotificationManager notificationManager;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            createNotification();
        }

        @Override
        protected String doInBackground(Feed... params) {
            SQL.getInstance(MainActivity.this).fillDb(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            notificationManager.cancel(0);
        }

        private void createNotification(){
            Notification notification = new Notification.Builder(MainActivity.this)
                    .setContentTitle(getString(R.string.notification_title))
                    .setContentText(getString(R.string.notification_body)).setSmallIcon(R.drawable.ic_cached)
                    .build();

            notification.flags |= Notification.FLAG_AUTO_CANCEL;

            notificationManager.notify(0, notification);

        }
    }
}
