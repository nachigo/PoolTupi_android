package com.nachigo.pooltupi.Activitys;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nachigo.pooltupi.Business.Calculator;
import com.nachigo.pooltupi.R;
import com.nachigo.pooltupi.Services.HttpConnections;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculadora extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public int hashrateID;
    public static long hashrate;

    private static double aeon = 0;
    private static double xmr = 0;
    private static double eth = 0;
    private static double mediaWeekETH = 0;
    private static double mediaDiaETH = 0;
    private static double mediaWeekXMR = 0;
    private static double mediaDiaXMR = 0;
    private static double mediaWeekAeon = 0;
    private static double mediaDiaAeon = 0;
    private static TextView txt24hrsAeon;
    private static TextView txt7dAeon;
    private static TextView txt24hrsXmr;
    private static TextView txt7dXmr;
    private static TextView txt24hrsETH;
    private static TextView txt7dETH;
    private static EditText edtHashrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Spinner spinner = findViewById(R.id.SpinHR);
        Button btnOK = findViewById(R.id.BtnCalculadora);

        ArrayList<String> hashrateL = new ArrayList<String>();
        hashrateL.add("H/s");
        hashrateL.add("KH/s");
        hashrateL.add("MH/s");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hashrateL);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner spinner1 = findViewById(R.id.SpinHR);
                if (i==0){
                    hashrateID = 1;
                    spinner1.setSelection(0);
                }
                if (i==1){
                    hashrateID = 1000;
                    spinner1.setSelection(1);
                }
                if (i==2){
                    hashrateID = 1000000;
                    spinner1.setSelection(2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Do nothing
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new HttpConnections().execute("https://api.coinmarketcap.com/v2/ticker/1026/?convert=BRL");
                new HttpConnections().execute("https://api.coinmarketcap.com/v2/ticker/328/?convert=BRL");
                new HttpConnections().execute("https://api.coinmarketcap.com/v2/ticker/1027/?convert=BRL");

                txt24hrsAeon = findViewById(R.id.txt24hrsAeon);
                txt7dAeon    = findViewById(R.id.txt7dAeon);
                txt24hrsXmr  = findViewById(R.id.txt24hrsXMR);
                txt7dXmr     = findViewById(R.id.txt7dXMR);
                txt24hrsETH  = findViewById(R.id.txt24hrsETH);
                txt7dETH     = findViewById(R.id.txt7dETH);
                edtHashrate  = findViewById(R.id.EdtHashrateCal);

                mediaWeekETH = 0;
                mediaDiaETH = 0;
                mediaWeekXMR = 0;
                mediaDiaXMR = 0;
                mediaWeekAeon = 0;
                mediaDiaAeon = 0;

                Calculator cal = new Calculator();
                long x = Math.round(Double.parseDouble(edtHashrate.getText().toString()) * hashrateID);
                hashrate = x;
                cal.MiningCalculatorAeon(x);
                cal.MiningCalculatorMonero(x);
                cal.MiningCalculatorEthereum(x);
            }
        });
    }

    public static void setCalculoAeon(double mediaWeek, double mediaDia){
        mediaDiaAeon= mediaDia;
        mediaWeekAeon = mediaWeek;
        if(aeon > 0) {
            DecimalFormat dfProfit = new DecimalFormat("0.##");
            DecimalFormat dfCoins = new DecimalFormat("0.####");
            double mediaRSWeek_aeon = aeon * mediaWeekAeon;
            double mediaRSDia_aeon = aeon * mediaDiaAeon;
            txt24hrsAeon.setText("≅ " + dfCoins.format(mediaDiaAeon) + " AEON / ≅ R$" + dfProfit.format(mediaRSDia_aeon));
            txt7dAeon.setText("≅ " + dfCoins.format(mediaWeekAeon) + " AEON / ≅ R$" + dfProfit.format(mediaRSWeek_aeon));
        }
    }

    public static void setCalculoXMR(double mediaWeek, double mediaDia){
        mediaDiaXMR = mediaDia;
        mediaWeekXMR = mediaWeek;
        if(xmr > 0) {
            DecimalFormat dfProfit = new DecimalFormat("0.##");
            DecimalFormat dfCoins = new DecimalFormat("0.####");
            double mediaRSWeek_xmr = xmr * mediaWeekXMR;
            double mediaRSDia_xmr = xmr * mediaDiaXMR;
            txt24hrsXmr.setText("≅ " + dfCoins.format(mediaDiaXMR) + " XMR / ≅ R$" + dfProfit.format(mediaRSDia_xmr));
            txt7dXmr.setText("≅ " + dfCoins.format(mediaWeekXMR) + " XMR / ≅ R$" + dfProfit.format(mediaRSWeek_xmr));
        }
    }

    public static void setCalculoETH(double mediaWeek, double mediaDia){
        mediaDiaETH = mediaDia;
        mediaWeekETH = mediaWeek;
        if(eth > 0) {
            DecimalFormat dfProfit = new DecimalFormat("0.##");
            DecimalFormat dfCoins = new DecimalFormat("0.####");
            double mediaRSWeek_eth = eth * mediaWeekETH;
            double mediaRSDia_eth = eth * mediaDiaETH;
            txt24hrsETH.setText("≅ " + dfCoins.format(mediaDiaETH) + " ETH / ≅ R$" + dfProfit.format(mediaRSDia_eth));
            txt7dETH.setText("≅ " + dfCoins.format(mediaWeekETH) + " ETH / ≅ R$" + dfProfit.format(mediaRSWeek_eth));
        }
    }

    public static void setAeonCap(String resposta){
        try {
            JSONObject objCoinMarket = new JSONObject(resposta);
            aeon = objCoinMarket.getJSONObject("data").getJSONObject("quotes").getJSONObject("BRL").getDouble("price");

            if(mediaWeekAeon>0 && mediaDiaAeon > 0){
                DecimalFormat dfProfit = new DecimalFormat("0.##");
                DecimalFormat dfCoins = new DecimalFormat("0.####");
                double mediaRSWeek_aeon = aeon * mediaWeekAeon;
                double mediaRSDia_aeon = aeon * mediaDiaAeon;
                txt24hrsAeon.setText("≅ " + dfCoins.format(mediaDiaAeon) + " AEON / ≅ R$" + dfProfit.format(mediaRSDia_aeon));
                txt7dAeon.setText("≅ " + dfCoins.format(mediaWeekAeon) + " AEON / ≅ R$" + dfProfit.format(mediaRSWeek_aeon));
            }

        }catch (Exception e){
            Log.e("erro setAeonCap", e.toString());
        }
    }

    public static void setXMRCap(String resposta){
        try {
            JSONObject objCoinMarket = new JSONObject(resposta);
            xmr = objCoinMarket.getJSONObject("data").getJSONObject("quotes").getJSONObject("BRL").getDouble("price");

            if(mediaWeekXMR>0 && mediaDiaXMR > 0){
                DecimalFormat dfProfit = new DecimalFormat("0.##");
                DecimalFormat dfCoins = new DecimalFormat("0.####");
                double mediaRSWeek_xmr = xmr * mediaWeekXMR;
                double mediaRSDia_xmr = xmr * mediaDiaXMR;
                txt24hrsXmr.setText("≅ " + dfCoins.format(mediaDiaXMR) + " AEON / ≅ R$" + dfProfit.format(mediaRSDia_xmr));
                txt7dXmr.setText("≅ " + dfCoins.format(mediaWeekXMR) + " AEON / ≅ R$" + dfProfit.format(mediaRSWeek_xmr));
            }

        }catch (Exception e){
            Log.e("erro setXMRCap", e.toString());
        }
    }

    public static void setETHCap(String resposta){
        DecimalFormat df = new DecimalFormat("0.##");
        try {
            JSONObject objCoinMarket = new JSONObject(resposta);
            eth = objCoinMarket.getJSONObject("data").getJSONObject("quotes").getJSONObject("BRL").getDouble("price");

            if(mediaWeekETH>0 && mediaDiaETH > 0){
                DecimalFormat dfProfit = new DecimalFormat("0.##");
                DecimalFormat dfCoins = new DecimalFormat("0.####");
                double mediaRSWeek_eth = eth * mediaWeekETH;
                double mediaRSDia_eth = eth * mediaDiaETH;
                txt24hrsETH.setText("≅ " + dfCoins.format(mediaDiaETH) + " ETH / ≅ R$" + dfProfit.format(mediaRSDia_eth));
                txt7dETH.setText("≅ " + dfCoins.format(mediaWeekETH) + " ETH / ≅ R$" + dfProfit.format(mediaRSWeek_eth));
            }

        }catch (Exception e){
            Log.e("erro setETHCap", e.toString());
        }
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
        } else if(id == R.id.nav_calculadora) {
            Intent intent = new Intent(this, Calculadora.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_whatsapp) {
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
