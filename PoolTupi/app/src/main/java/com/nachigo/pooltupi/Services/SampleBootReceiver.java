package com.nachigo.pooltupi.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.nachigo.pooltupi.Services.AlarmMgr;

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
