package com.adv.rappichallenge.Activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.adv.rappichallenge.R;
import com.adv.rappichallenge.models.Entry;

import static com.adv.rappichallenge.helpers.Const.formatDate;


/**
 * Created by Ruben Flores on 2/2/2017.
 */

public class DetailsActivity extends BaseActivity{

    private TextView textAppName, textPrice, textCategory, textReleaseDate, textSummary, textRights;
    private Toolbar toolbar;

    private Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getIntent().getExtras().setClassLoader(Entry.class.getClassLoader());
        entry = getIntent().getExtras().getParcelable("Entry");

        initUI();
        bindData();
    }

    private void initUI(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textAppName = (TextView) findViewById(R.id.textAppName);
        textPrice = (TextView) findViewById(R.id.textPrice);
        textCategory = (TextView) findViewById(R.id.textCategory);
        textReleaseDate = (TextView) findViewById(R.id.textReleaseDate);
        textSummary = (TextView) findViewById(R.id.textSummary);
        textRights = (TextView) findViewById(R.id.textRights);

    }

    private void bindData(){
        if(entry != null) {
            textAppName.setText(entry.getIm_name().getLabel());
            if(Double.parseDouble(entry.getIm_price().getAttributes_price().getAmount()) > 0){
                textPrice.setText(entry.getIm_price().getAttributes_price().getCurrency()+" "+entry.getIm_price().getAttributes_price().getAmount());
            }else{
                textPrice.setText(getString(R.string.global_free));
            }
            textCategory.setText(entry.getCategory().getAttributes_category().getLabel());
            textReleaseDate.setText(formatDate(entry.getIm_releaseDate().getLabel()));
            textSummary.setText(entry.getSummary().getLabel());
            textRights.setText(String.format(getString(R.string.activity_details_rights), entry.getRights().getLabel()));
        }
    }
}
