package com.nachigo.pooltupi;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
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
        super("Feijão");
    }




    @Override
    protected void onHandleIntent(Intent workIntent) {
        for (int i = 0; i>-1; i++) {
            try {
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                String resposta = null;
                try {
                    URL url = new URL("https://pooltupi.com/api/pool/stats/pplns");
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.connect();

                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                    reader = new BufferedReader(new InputStreamReader(in));
                    String line = "";
                    StringBuffer buffer = new StringBuffer();
                    while ((line = reader.readLine()) != null){
                        buffer.append(line);
                    }
                    resposta = buffer.toString();
                }catch (Exception e){
                    e.printStackTrace();
                    resposta = "erro aqui" + e.toString();
                }finally {
                    if (urlConnection != null){
                        urlConnection.disconnect();
                    }
                }
                JSONObject objPool = new JSONObject(resposta);
                long LB = objPool.getJSONObject("pool_statistics").getLong("lastBlockFoundTime");
                long currentTS = System.currentTimeMillis() / 1000;
                if (currentTS - LB <= 60) {
                    notificando();
                } else {
                    //Do nothing
                    notificando();
                }
                new Thread().sleep(59000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void notificando(){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.aeon)
                        .setContentTitle("PoolTupi")
                        .setContentText("Novo bloco encontrado!!!");
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, MainActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
       // NotificationManager mNotificationManager =
       //         (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        //mNotificationManager.notify(mId, mBuilder.build());
    }

}
