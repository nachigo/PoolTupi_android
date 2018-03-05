package com.nachigo.pooltupi;

import android.app.Activity;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Gustavo on 25/02/2018.
 */

public class BlockFoundService  extends IntentService{


    public BlockFoundService(String name) {
        super(name);
    }

    public BlockFoundService(){
        super("BlockFoundService");
    }




    @Override
    protected void onHandleIntent(Intent workIntent) {
            try {
                SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
                SharedPreferences.Editor editor = settings.edit();
                int lastBlock = settings.getInt("lastBlock", 0);
                HttpURLConnection urlConnection = null;
                BufferedReader reader;
                String resposta = null;
                try {
                    URL url = new URL("https://pooltupi.com/api/pool/stats/pplns");
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.connect();

                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                    reader = new BufferedReader(new InputStreamReader(in));
                    String line ;
                    StringBuffer buffer = new StringBuffer();
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }
                    resposta = buffer.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
                JSONObject objPool = new JSONObject(resposta);
                int blockFound = objPool.getJSONObject("pool_statistics").getInt("totalBlocksFound");
                if (lastBlock>0) {
                    if (blockFound>lastBlock) {
                        editor.putInt("lastBlock", blockFound);
                        editor.commit();
                        notificando();
                    } else {
                        //não encontrou, faça um grande nada
                    }
                } else {
                    editor.putInt("lastBlock", blockFound);
                    editor.commit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void notificando(){
        SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
        SharedPreferences.Editor editor = settings.edit();
        int mId = settings.getInt("noticationID", 0);
        Intent resultIntent = new Intent(this, MainActivity.class);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.aeon)
                        .setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT))
                        .setContentTitle("PoolTupi")
                        .setContentText("Novo bloco encontrado!!!")
                        .setPriority(1)
                        .setVibrate(new long[]{ 100, 250, 100, 500})
                        .setAutoCancel(true);
// Creates an explicit intent for an Activity in your app


// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(Activity.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mId, mBuilder.build());
        editor.putInt("noticationID", mId+1 );
        editor.commit();

    }
}
