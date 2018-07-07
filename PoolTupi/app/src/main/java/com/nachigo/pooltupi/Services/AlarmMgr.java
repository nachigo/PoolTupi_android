package com.nachigo.pooltupi.Services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Gustavo on 01/03/2018.
 */

public class AlarmMgr {
    AlarmManager alarmMgr;
    public void Alarm(Context context) {
        SharedPreferences settings = context.getSharedPreferences("tupiniquim", 0);
        boolean notify = settings.getBoolean("notify", true);
        if(notify) {
            // Set the alarm here.
            PendingIntent alarmIntent;
            alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intentA = new Intent(context, BlockFoundService.class);
            alarmIntent = PendingIntent.getService(context, 0, intentA, PendingIntent.FLAG_UPDATE_CURRENT);

            int time = settings.getInt("NotificationTime", 1);
            // setRepeating() lets you specify a precise custom interval--in this case,
            alarmMgr.setRepeating(AlarmManager.RTC, System.currentTimeMillis(),
                    1000 * 60 * time, alarmIntent);

        }
    }
    public void CancelAlarm (Context context){
        if (alarmMgr!= null) {
            Intent intentA = new Intent(context, BlockFoundService.class);
            PendingIntent alarmIntent = PendingIntent.getService(context, 0, intentA, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmMgr.cancel(alarmIntent);
        }
    }
}
