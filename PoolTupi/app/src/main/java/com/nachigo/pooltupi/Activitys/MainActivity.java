package com.nachigo.pooltupi.Activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
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
import android.widget.TextView;

import com.nachigo.pooltupi.R;
import com.nachigo.pooltupi.Services.HttpConnections;

import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static long rHashes;
    Handler handler = new Handler();
    Runnable refresh;
    public static long diff = 0;
    private static TextView Effort;
    private static TextView HashPool;
    private static TextView Block;
    private static TextView Miners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra_lateral);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Effort = findViewById(R.id.TxtEffort);
        HashPool = findViewById(R.id.TxtHashratePool);
        Block    = findViewById(R.id.TxtBlock);
        Miners   = findViewById(R.id.TxtMiners);
        Effort   = findViewById(R.id.TxtEffort);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Inicia();
        refresh = new Runnable() {
            public void run() {
                Inicia();
                Log.e("Refresh painel pool", "estou dando refresh");
                handler.postDelayed(refresh, 20000);
            }
        };
        handler.post(refresh);
    }


    private void Inicia(){
        new HttpConnections().execute("https://pooltupi.com/api/network/stats");
        new HttpConnections().execute("https://pooltupi.com/api/pool/stats/pplns");
    }


    public static void setPool(String resposta){
        try {
            JSONObject obj = new JSONObject(resposta);
            rHashes = obj.getJSONObject("pool_statistics").getLong("roundHashes");
            long hashGeral = obj.getJSONObject("pool_statistics").getLong("hashRate");
            int blocos = obj.getJSONObject("pool_statistics").getInt("totalBlocksFound");
            int qtdMiners = obj.getJSONObject("pool_statistics").getInt("miners");
            String hs;
            if (hashGeral > 999 && hashGeral <= 999999) {
                hashGeral /= 1000;
                DecimalFormat decimalFormat = new DecimalFormat("0.##");
                hs = decimalFormat.format(hashGeral) + " KH/s";
            } else {
                if (hashGeral > 999999) {
                    hashGeral /= 1000000;
                    DecimalFormat decimalFormat = new DecimalFormat("0.##");
                    hs = decimalFormat.format(hashGeral) + " MH/s";
                } else {
                    hs = hashGeral + " H/s";
                }
            }
            /**
             *  Põe na tela
             */

            Block.setText(String.valueOf(blocos));
            Miners.setText(String.valueOf(qtdMiners));
            HashPool.setText(hs);
        } catch (Exception e){
            Log.e("erro setPool", e.toString() + " " + resposta);
        }


        /**
         *   Se já tiver os hashes e a difficuldade inicia o esforço
         */
        if(rHashes> 0 && diff >0) {
            double esforço = ((rHashes*100) /diff);
            Effort.setText(esforço + " %");
        }
    }

    public static void setNet(String string){
        try {
            JSONObject obj = new JSONObject(string);
            diff = obj.getLong("difficulty");
        }catch (Exception e){
            Log.e("erro setNet", e.toString());
        }

        /**
         *   Se já tiver os hashes e a difficuldade inicia o esforço
         */
        if(rHashes> 0 && diff >0) {
            double esforço = (rHashes / diff)*100;
            Effort.setText(esforço + " %");
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
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
}
