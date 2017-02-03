package com.adv.rappichallenge.repositories;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Build;
import android.util.Log;

import com.adv.rappichallenge.interfaces.IDataRepository;
import com.adv.rappichallenge.interfaces.OnSelect_Listener;
import com.adv.rappichallenge.models.Attributes_artist;
import com.adv.rappichallenge.models.Attributes_category;
import com.adv.rappichallenge.models.Attributes_contentType;
import com.adv.rappichallenge.models.Attributes_id;
import com.adv.rappichallenge.models.Attributes_image;
import com.adv.rappichallenge.models.Attributes_link;
import com.adv.rappichallenge.models.Attributes_price;
import com.adv.rappichallenge.models.Attributes_releaseDate;
import com.adv.rappichallenge.models.Author;
import com.adv.rappichallenge.models.Category;
import com.adv.rappichallenge.models.Entry;
import com.adv.rappichallenge.models.Feed;
import com.adv.rappichallenge.models.Id;
import com.adv.rappichallenge.models.Im_artist;
import com.adv.rappichallenge.models.Im_contentType;
import com.adv.rappichallenge.models.Im_image;
import com.adv.rappichallenge.models.Im_name;
import com.adv.rappichallenge.models.Im_price;
import com.adv.rappichallenge.models.Im_releaseDate;
import com.adv.rappichallenge.models.Link;
import com.adv.rappichallenge.models.Name;
import com.adv.rappichallenge.models.Rights;
import com.adv.rappichallenge.models.Root;
import com.adv.rappichallenge.models.Summary;
import com.adv.rappichallenge.models.Title;
import com.adv.rappichallenge.models.Uri;

import java.util.ArrayList;
import java.util.List;

import static com.adv.rappichallenge.helpers.Const.DB_NAME;
import static com.adv.rappichallenge.helpers.Const.DB_PATH;
import static com.adv.rappichallenge.helpers.Const.TAG;

/**
 * Created by Ruben Flores on 7/5/2016.
 */
public class SQL implements IDataRepository {
    private static SQL  _instance;
    private static SQLiteDatabase db;

    public SQL(Context context) {

        db = SQLiteDatabase.openDatabase(DB_PATH(context) + DB_NAME, new SQLiteDatabase.CursorFactory() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery
                    query) {
                return new SQLiteCursor(masterQuery, editTable, query);
            }
        }, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized static SQL getInstance(Context context)
    {
        if (_instance == null || db == null)
        {
            _instance = new SQL(context);
        }
        return _instance;
    }


    @Override
    public void getFeeds(OnSelect_Listener listener) {
        try{
            Root item = null;
            // Select All Query
            String selectQuery = "SELECT * FROM feed";

            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Feed feed = new Feed();
                    feed.setAuthor(getAuthor(Integer.parseInt(cursor.getString(0))));
                    feed.setEntries(getEntries(Long.parseLong(cursor.getString(0))));

                    item = new Root(feed);
                } while (cursor.moveToNext());
            }

            listener.onComplete(item);

        }catch (Exception e){
            Log.e(TAG, "getFeeds: ", e);
            listener.onError();
        }
    }

    private Author getAuthor(long idFeed){
        Author item = null;
        String selectQuery = "SELECT name, uri FROM author";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            item = new Author();
            item.setName(new Name(cursor.getString(0)));
            item.setUri(new Uri(cursor.getString(1)));
        }

        return item;
    }

    private List<Entry> getEntries(long idFeed){
        List<Entry> items = new ArrayList<>();
        Entry item;
        String selectQuery = "SELECT * FROM entry WHERE idFeed = "+idFeed;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do{

                item = new Entry();
                item.setIm_name(new Im_name(cursor.getString(2)));
                item.setSummary(new Summary(cursor.getString(3)));
                item.setIm_price(new Im_price("", new Attributes_price(cursor.getString(4),cursor.getString(5))));
                item.setIm_contentType(new Im_contentType(new Attributes_contentType(cursor.getString(6), cursor.getString(7))));
                item.setRights(new Rights(cursor.getString(8)));
                item.setTitle(new Title(cursor.getString(9)));
                item.setLink(new Link(new Attributes_link(cursor.getString(10), cursor.getString(11), cursor.getString(12))));
                item.setId(new Id(cursor.getString(13),new Attributes_id(cursor.getString(14),cursor.getString(15))));
                item.setIm_artist(new Im_artist(cursor.getString(16), new Attributes_artist(cursor.getString(17))));
                item.setCategory(new Category(new Attributes_category(cursor.getString(18), cursor.getString(19), cursor.getString(20), cursor.getString(21))));
                item.setIm_releaseDate(new Im_releaseDate(cursor.getString(22), new Attributes_releaseDate(cursor.getString(22))));

                item.setIm_image(getImages(Long.parseLong(cursor.getString(0))));

                items.add(item);
            }while (cursor.moveToNext());
        }

        return items;
    }

    private List<Im_image> getImages(long idEntry){
        List<Im_image> items = new ArrayList<>();
        Im_image item;
        String selectQuery = "SELECT * FROM image WHERE idEntry = "+ idEntry;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do{

                item = new Im_image(cursor.getString(2), new Attributes_image(cursor.getString(3)));

                items.add(item);

            }while (cursor.moveToNext());
        }

        return items;
    }

    public void fillDb(Feed feed){

        ContentValues cv;

        cv = new ContentValues();
        cv.put("name", feed.getAuthor().getName().getLabel());
        cv.put("uri", feed.getAuthor().getUri().getLabel());

        db.delete("author","1=1",null);

        long idAuthor = db.insertOrThrow("author", null, cv);

        cv = new ContentValues();
        cv.put("idAuthor", idAuthor);

        db.delete("feed","1=1",null);
        long idFeed = db.insertOrThrow("feed", null, cv);

        db.delete("entry","1=1",null);


        for (Entry entry : feed.getEntries()){
            cv = new ContentValues();
            cv.put("idFeed", idFeed);
            cv.put("name", entry.getIm_name().getLabel());
            cv.put("summary", entry.getSummary().getLabel());
            cv.put("amount", entry.getIm_price().getAttributes_price().getAmount());
            cv.put("currency", entry.getIm_price().getAttributes_price().getCurrency());
            cv.put("contentType_term", entry.getIm_contentType().getAttributes_contentType().getTerm());
            cv.put("contentType_label", entry.getIm_contentType().getAttributes_contentType().getLabel());
            cv.put("rights", entry.getRights().getLabel());
            cv.put("title", entry.getTitle().getLabel());
            cv.put("link_rel",  entry.getLink().getAttributes_link().getRel());
            cv.put("link_type", entry.getLink().getAttributes_link().getType());
            cv.put("link_href", entry.getLink().getAttributes_link().getHref());
            cv.put("id_label", entry.getId().getLabel());
            cv.put("id_label", entry.getId().getLabel());
            cv.put("id_id", entry.getId().getAttributes_id().getIm_id());
            cv.put("id_bundleId", entry.getId().getAttributes_id().getIm_bundleId());
            cv.put("artist_label", entry.getIm_artist().getLabel());
            cv.put("artist_href", entry.getIm_artist().getAttributes_artist().getHref());
            cv.put("category_id", entry.getCategory().getAttributes_category().getIm_id());
            cv.put("category_term", entry.getCategory().getAttributes_category().getTerm());
            cv.put("category_scheme", entry.getCategory().getAttributes_category().getScheme());
            cv.put("category_label", entry.getCategory().getAttributes_category().getLabel());
            cv.put("releaseDate_label", entry.getIm_releaseDate().getLabel());

            long idEntry = db.insertOrThrow("entry", null, cv);
            for(Im_image image : entry.getIm_image()){
                cv = new ContentValues();
                cv.put("idEntry", idEntry);
                cv.put("label",image.getLabel());
                cv.put("height", image.getAttributes_image().getHeight());

                db.insertOrThrow("image", null, cv);
            }
        }

    }
}
