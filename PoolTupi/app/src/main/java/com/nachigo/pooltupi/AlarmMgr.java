package com.nachigo.pooltupi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Gustavo on 01/03/2018.
 */

public class AlarmMgr {
    AlarmManager alarmMgr;
    public void Alarm(Context context) {
            // Set the alarm here.
            PendingIntent alarmIntent;

            alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intentA = new Intent(context, BlockFoundService.class);
            alarmIntent = PendingIntent.getBroadcast(context, 0, intentA, 0);

// Set the alarm to start at 8:30 a.m.

// setRepeating() lets you specify a precise custom interval--in this case,
// 20 minutes.
            alarmMgr.setRepeating(AlarmManager.RTC, System.currentTimeMillis(),
                    1000 * 60 , alarmIntent);
    }
    public void CancelAlarm (Context context){
        if (alarmMgr!= null) {
            Intent intentA = new Intent(context, BlockFoundService.class);
            PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intentA, 0);
            alarmMgr.cancel(alarmIntent);
        }
    }
}
