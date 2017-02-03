package com.adv.rappichallenge.helpers;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ruben Flores on 2/1/2017.
 */

public class Const {
    public static String APP_NAME = "rappichallenge";
    public static String PACKAGE_NAME = "com.adv.rappichallenge";
    public static String DB_NAME = "db.db";
    public static String TAG = "LOG_TAG";

    public static int SERVICE_CONNETION = 1;
    public static int LOCAL_CONNETION = 2;


    public static String DB_PATH(Context context){
        String DB_PATH;
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        return DB_PATH;
    }

    public static String formatDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date convertedDate;
        try {
            convertedDate = dateFormat.parse(date);
            SimpleDateFormat sdfmonth = new SimpleDateFormat("MM/yyyy");
            return sdfmonth.format(convertedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
