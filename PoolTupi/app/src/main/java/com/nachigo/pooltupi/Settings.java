package com.nachigo.pooltupi;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final Switch Block = findViewById(R.id.SBlock);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
        SharedPreferences.Editor editor = settings.edit();
        Boolean notify = settings.getBoolean("notify", true);
        if (notify){
            Block.setChecked(true);
            LinearLayout NotifyTime = findViewById(R.id.NotifyTime);
            NotifyTime.setVisibility(View.VISIBLE);
        } else {
            Block.setChecked(false);
        }

        List<String> tempo = new ArrayList<String>();
        tempo.add("1 min");
        tempo.add("2 min");
        tempo.add("5 min");
        tempo.add("10 min");

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tempo);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);
        int posSpinner = settings.getInt("NotifyTime", 1);
        if (posSpinner == 1) {
            spinner.setSelection(0);
        }
        if (posSpinner == 2) {
            spinner.setSelection(1);
        }
        if (posSpinner == 5) {
            spinner.setSelection(2);
        }
        if (posSpinner == 10) {
            spinner.setSelection(3);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner spinner1 = findViewById(R.id.spinner);
                if (i==0){
                    SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("NotificationTime", 1);
                    spinner1.setSelection(0);

                }
                if (i==1){
                    SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("NotificationTime", 2);
                    spinner1.setSelection(1);
                }
                if (i==2){
                    SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("NotificationTime", 5);
                    spinner1.setSelection(2);
                }
                if (i==3){
                    SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("NotificationTime", 10);
                    spinner1.setSelection(3);
                }
                AlarmMgr alarmMgr = new AlarmMgr();
                alarmMgr.CancelAlarm(getApplicationContext());
                alarmMgr.Alarm(getApplicationContext());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Do nothing
            }
        });

        Block.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Block.isChecked()){
                    SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("notify", true);
                    editor.commit();

                    AlarmMgr alarmMgr = new AlarmMgr();
                    alarmMgr.Alarm(getApplicationContext());
                    try {
                        ComponentName receiver = new ComponentName(getApplicationContext(), SampleBootReceiver.class);
                        PackageManager pm = getApplicationContext().getPackageManager();

                        pm.setComponentEnabledSetting(receiver,
                                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                                PackageManager.DONT_KILL_APP);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    LinearLayout NotifyTime = findViewById(R.id.NotifyTime);
                    NotifyTime.setVisibility(View.VISIBLE);
                } else {
                    SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("notify", false);
                    editor.commit();

                    ComponentName receiver = new ComponentName(getApplicationContext(), SampleBootReceiver.class);
                    PackageManager pm = getApplicationContext().getPackageManager();

                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                            PackageManager.DONT_KILL_APP);
                    AlarmMgr alarmMgr = new AlarmMgr();
                    alarmMgr.CancelAlarm(getApplicationContext());
                    try {
                        Intent mServiceIntent = new Intent(getApplicationContext(), BlockFoundService.class);
                        stopService(mServiceIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    LinearLayout NotifyTime = findViewById(R.id.NotifyTime);
                    NotifyTime.setVisibility(View.GONE);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.barra_lateral, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicial) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_duvidas) {
            Intent intent = new Intent(this, FAQ_activity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_painel) {
            Intent intent = new Intent(this, Painel.class);
            startActivity(intent);
            finish();
        }  else if (id == R.id.nav_whatsapp) {
            String url = "https://chat.whatsapp.com/FDryMCtFYUS5C0AjrB2A0K";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if (id == R.id.nav_telegram) {
            String url = "https://t.me/pooltupi/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if(id == R.id.nav_Sobre) {
            Intent intent = new Intent(this, Sobre.class);
            startActivity(intent);
            finish();
        } else if(id == R.id.nav_Config) {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
