package com.nachigo.pooltupi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by Gustavo on 01/03/2018.
 */

public class SampleBootReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        AlarmMgr alarmMgr = new AlarmMgr();
        alarmMgr.Alarm(context);
    }
}
