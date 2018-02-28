package com.nachigo.pooltupi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Painel extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    String Wallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        EditText EdtWallet = findViewById(R.id.EdtWallet);
        Button BtWallet = findViewById(R.id.AddWallet);

        SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
        SharedPreferences.Editor editor = settings.edit();

        if (settings.getString("Wallet", null)!= null){
            Wallet = settings.getString("Wallet", null);
            EdtWallet.setText(Wallet);
            Inicia(Wallet);
        }


        BtWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText EdtWallet = findViewById(R.id.EdtWallet);
                Wallet = EdtWallet.getText().toString();

                TextView HashMiner = findViewById(R.id.TxtHashMiner);
                TextView TotalHash = findViewById(R.id.TxtTotalHashes);
                TextView TotalDevido = findViewById(R.id.TxtDevido);
                TextView TotalPago = findViewById(R.id.TxtPago);
                TextView Worker1Nome = findViewById(R.id.Worker1Name);
                TextView Worker1Hs = findViewById(R.id.Worker1Hs);
                TextView Worker1TH = findViewById(R.id.Worker1TH);
                TextView Worker1Ls = findViewById(R.id.Worker1LH);
                TextView Worker2Nome = findViewById(R.id.worker2Nome);
                TextView Worker2Hs = findViewById(R.id.worker2Hs);
                TextView Worker2TH = findViewById(R.id.worker2TH);
                TextView Worker2Ls = findViewById(R.id.worker2LH);
                TextView Worker3Nome = findViewById(R.id.worker3Nome);
                TextView Worker3Hs = findViewById(R.id.worker3Hs);
                TextView Worker3TH = findViewById(R.id.worker3TH);
                TextView Worker3Ls = findViewById(R.id.worker3LH);

                HashMiner.setText("");
                TotalDevido.setText("");
                TotalHash.setText("");
                TotalPago.setText("");
                Worker1Hs.setText("");
                Worker1Ls.setText("");
                Worker1Nome.setText("");
                Worker1TH.setText("");
                Worker2Hs.setText("");
                Worker2Ls.setText("");
                Worker2Nome.setText("");
                Worker2TH.setText("");
                Worker3Hs.setText("");
                Worker3Ls.setText("");
                Worker3Nome.setText("");
                Worker3TH.setText("");

                Inicia(Wallet);
            }
        });

    }

    private void Inicia(String Wallet){
        TextView HashMiner = findViewById(R.id.TxtHashMiner);
        TextView TotalHash = findViewById(R.id.TxtTotalHashes);
        TextView TotalDevido = findViewById(R.id.TxtDevido);
        TextView TotalPago = findViewById(R.id.TxtPago);
        TextView Price = findViewById(R.id.TxtAeonBrl);
        TextView Worker1Nome = findViewById(R.id.Worker1Name);
        TextView Worker1Hs = findViewById(R.id.Worker1Hs);
        TextView Worker1TH = findViewById(R.id.Worker1TH);
        TextView Worker1Ls = findViewById(R.id.Worker1LH);
        TextView Worker2Nome = findViewById(R.id.worker2Nome);
        TextView Worker2Hs = findViewById(R.id.worker2Hs);
        TextView Worker2TH = findViewById(R.id.worker2TH);
        TextView Worker2Ls = findViewById(R.id.worker2LH);
        TextView Worker3Nome = findViewById(R.id.worker3Nome);
        TextView Worker3Hs = findViewById(R.id.worker3Hs);
        TextView Worker3TH = findViewById(R.id.worker3TH);
        TextView Worker3Ls = findViewById(R.id.worker3LH);


        SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Wallet", Wallet);
        editor.commit();

        try {
            String respostaWorker = new HttpConnections().execute("https://pooltupi.com/api/miner/" + Wallet + "/identifiers").get();
            JSONArray objWorker = new JSONArray(respostaWorker);
            for (int i = 0; i < objWorker.length(); i++) {
                String nomeDele = objWorker.getString(i);
                String respostaWorkerAtual = new HttpConnections().execute("https://pooltupi.com/api/miner/" + Wallet + "/stats/" + nomeDele).get();
                JSONObject objWorkerI = new JSONObject(respostaWorkerAtual);
                String hashrate = objWorkerI.getString("hash");
                String totalHash = objWorkerI.getString("totalHash");
                String LastHashR = "";
                long lastHash = objWorkerI.getLong("lts");

                try {
                    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    long currentTS = System.currentTimeMillis()/1000;
                    //Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
                    if (currentTS-lastHash>=60 & currentTS-lastHash<=60000){
                        currentTS = (currentTS-lastHash)/60;
                        LastHashR = currentTS + " min atrás";
                    } else {
                        if (currentTS-lastHash>=360){
                        currentTS = ((currentTS-lastHash)/360);
                        LastHashR = currentTS + " hr atrás";
                        } else {
                            LastHashR = " few seconds ago";
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }

                if (i==0) {
                    Worker1Hs.setText(hashrate);
                    Worker1Nome.setText(nomeDele);
                    Worker1TH.setText(totalHash);
                    Worker1Ls.setText(LastHashR);
                }
                if (i==1) {
                    Worker2Hs.setText(hashrate);
                    Worker2Nome.setText(nomeDele);
                    Worker2TH.setText(totalHash);
                    Worker2Ls.setText(LastHashR);
                }
                if (i==2) {
                    Worker3Hs.setText(hashrate);
                    Worker3Nome.setText(nomeDele);
                    Worker3TH.setText(totalHash);
                    Worker3Ls.setText(LastHashR);
                }


            }
        } catch (Exception e){
            e.printStackTrace();
        }
        new Inicializador().setDashboard(HashMiner, TotalHash, TotalDevido, TotalPago, Price, Wallet, getApplicationContext());
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
            Wallet = settings.getString("Wallet", null);
            Inicia(Wallet);
        }

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
            Intent intent = new Intent(this, com.nachigo.pooltupi.Settings.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
