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
import android.widget.TableRow;
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
        TextView Worker4Nome = findViewById(R.id.worker4Nome);
        TextView Worker4Hs = findViewById(R.id.worker4Hs);
        TextView Worker4TH = findViewById(R.id.worker4TH);
        TextView Worker4Ls = findViewById(R.id.worker4LH);

        TextView Worker5Nome = findViewById(R.id.worker5Nome);
        TextView Worker5Hs = findViewById(R.id.worker5Hs);
        TextView Worker5TH = findViewById(R.id.worker5TH);
        TextView Worker5Ls = findViewById(R.id.worker5LH);

        TextView Worker6Nome = findViewById(R.id.worker6Nome);
        TextView Worker6Hs = findViewById(R.id.worker6Hs);
        TextView Worker6TH = findViewById(R.id.worker6TH);
        TextView Worker6Ls = findViewById(R.id.worker6LH);

        TextView Worker7Nome = findViewById(R.id.worker7Nome);
        TextView Worker7Hs = findViewById(R.id.worker7Hs);
        TextView Worker7TH = findViewById(R.id.worker7TH);
        TextView Worker7Ls = findViewById(R.id.worker7LH);

        TextView Worker8Nome = findViewById(R.id.worker8Nome);
        TextView Worker8Hs = findViewById(R.id.worker8Hs);
        TextView Worker8TH = findViewById(R.id.worker8TH);
        TextView Worker8Ls = findViewById(R.id.worker8LH);

        TextView Worker9Nome = findViewById(R.id.worker9Nome);
        TextView Worker9Hs = findViewById(R.id.worker9Hs);
        TextView Worker9TH = findViewById(R.id.worker9TH);
        TextView Worker9Ls = findViewById(R.id.worker9LH);

        TextView Worker10Nome = findViewById(R.id.worker10Nome);
        TextView Worker10Hs = findViewById(R.id.worker10Hs);
        TextView Worker10TH = findViewById(R.id.worker10TH);
        TextView Worker10Ls = findViewById(R.id.worker10LH);

        TextView Worker11Nome = findViewById(R.id.Worker11Name);
        TextView Worker11Hs = findViewById(R.id.Worker11Hs);
        TextView Worker11TH = findViewById(R.id.Worker11TH);
        TextView Worker11Ls = findViewById(R.id.Worker11LH);
        TextView Worker12Nome = findViewById(R.id.worker12Nome);
        TextView Worker12Hs = findViewById(R.id.worker12Hs);
        TextView Worker12TH = findViewById(R.id.worker12TH);
        TextView Worker12Ls = findViewById(R.id.worker12LH);
        TextView Worker13Nome = findViewById(R.id.worker13Nome);
        TextView Worker13Hs = findViewById(R.id.worker13Hs);
        TextView Worker13TH = findViewById(R.id.worker13TH);
        TextView Worker13Ls = findViewById(R.id.worker13LH);
        TextView Worker14Nome = findViewById(R.id.worker14Nome);
        TextView Worker14Hs = findViewById(R.id.worker14Hs);
        TextView Worker14TH = findViewById(R.id.worker14TH);
        TextView Worker14Ls = findViewById(R.id.worker14LH);

        TextView Worker15Nome = findViewById(R.id.worker15Nome);
        TextView Worker15Hs = findViewById(R.id.worker15Hs);
        TextView Worker15TH = findViewById(R.id.worker15TH);
        TextView Worker15Ls = findViewById(R.id.worker15LH);

        TextView Worker16Nome = findViewById(R.id.worker16Nome);
        TextView Worker16Hs = findViewById(R.id.worker16Hs);
        TextView Worker16TH = findViewById(R.id.worker16TH);
        TextView Worker16Ls = findViewById(R.id.worker16LH);

        TextView Worker17Nome = findViewById(R.id.worker17Nome);
        TextView Worker17Hs = findViewById(R.id.worker17Hs);
        TextView Worker17TH = findViewById(R.id.worker17TH);
        TextView Worker17Ls = findViewById(R.id.worker17LH);

        TextView Worker18Nome = findViewById(R.id.worker18Nome);
        TextView Worker18Hs = findViewById(R.id.worker18Hs);
        TextView Worker18TH = findViewById(R.id.worker18TH);
        TextView Worker18Ls = findViewById(R.id.worker18LH);

        TextView Worker19Nome = findViewById(R.id.worker19Nome);
        TextView Worker19Hs = findViewById(R.id.worker19Hs);
        TextView Worker19TH = findViewById(R.id.worker19TH);
        TextView Worker19Ls = findViewById(R.id.worker19LH);

        TextView Worker20Nome = findViewById(R.id.worker20Nome);
        TextView Worker20Hs = findViewById(R.id.worker20Hs);
        TextView Worker20TH = findViewById(R.id.worker20TH);
        TextView Worker20Ls = findViewById(R.id.worker20LH);


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
                if (i==3) {
                    Worker4Hs.setText(hashrate);
                    Worker4Nome.setText(nomeDele);
                    Worker4TH.setText(totalHash);
                    Worker4Ls.setText(LastHashR);
                }
                if (i==4) {
                    Worker5Hs.setText(hashrate);
                    Worker5Nome.setText(nomeDele);
                    Worker5TH.setText(totalHash);
                    Worker5Ls.setText(LastHashR);
                }
                if (i==5) {
                    Worker6Hs.setText(hashrate);
                    Worker6Nome.setText(nomeDele);
                    Worker6TH.setText(totalHash);
                    Worker6Ls.setText(LastHashR);
                }
                if (i==6) {
                    Worker7Hs.setText(hashrate);
                    Worker7Nome.setText(nomeDele);
                    Worker7TH.setText(totalHash);
                    Worker7Ls.setText(LastHashR);
                }
                if (i==7) {
                    Worker8Hs.setText(hashrate);
                    Worker8Nome.setText(nomeDele);
                    Worker8TH.setText(totalHash);
                    Worker8Ls.setText(LastHashR);
                }
                if (i==8) {
                    Worker9Hs.setText(hashrate);
                    Worker9Nome.setText(nomeDele);
                    Worker9TH.setText(totalHash);
                    Worker9Ls.setText(LastHashR);
                }
                if (i==9) {
                    Worker10Hs.setText(hashrate);
                    Worker10Nome.setText(nomeDele);
                    Worker10TH.setText(totalHash);
                    Worker10Ls.setText(LastHashR);
                }
                if (i==10) {
                    Worker11Hs.setText(hashrate);
                    Worker11Nome.setText(nomeDele);
                    Worker11TH.setText(totalHash);
                    Worker11Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker11);
                    Worker.setVisibility(View.VISIBLE);
                }
                if (i==11) {
                    Worker12Hs.setText(hashrate);
                    Worker12Nome.setText(nomeDele);
                    Worker12TH.setText(totalHash);
                    Worker12Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker12);
                    Worker.setVisibility(View.VISIBLE);
                }
                if (i==12) {
                    Worker13Hs.setText(hashrate);
                    Worker13Nome.setText(nomeDele);
                    Worker13TH.setText(totalHash);
                    Worker13Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker13);
                    Worker.setVisibility(View.VISIBLE);
                }
                if (i==13) {
                    Worker14Hs.setText(hashrate);
                    Worker14Nome.setText(nomeDele);
                    Worker14TH.setText(totalHash);
                    Worker14Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker14);
                    Worker.setVisibility(View.VISIBLE);
                }
                if (i==14) {
                    Worker15Hs.setText(hashrate);
                    Worker15Nome.setText(nomeDele);
                    Worker15TH.setText(totalHash);
                    Worker15Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker15);
                    Worker.setVisibility(View.VISIBLE);
                }
                if (i==15) {
                    Worker16Hs.setText(hashrate);
                    Worker16Nome.setText(nomeDele);
                    Worker16TH.setText(totalHash);
                    Worker16Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker16);
                    Worker.setVisibility(View.VISIBLE);
                }
                if (i==16) {
                    Worker17Hs.setText(hashrate);
                    Worker17Nome.setText(nomeDele);
                    Worker17TH.setText(totalHash);
                    Worker17Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker17);
                    Worker.setVisibility(View.VISIBLE);
                }
                if (i==17) {
                    Worker18Hs.setText(hashrate);
                    Worker18Nome.setText(nomeDele);
                    Worker18TH.setText(totalHash);
                    Worker18Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker18);
                    Worker.setVisibility(View.VISIBLE);
                }
                if (i==18) {
                    Worker19Hs.setText(hashrate);
                    Worker19Nome.setText(nomeDele);
                    Worker19TH.setText(totalHash);
                    Worker19Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker19);
                    Worker.setVisibility(View.VISIBLE);
                }
                if (i==19) {
                    Worker20Hs.setText(hashrate);
                    Worker20Nome.setText(nomeDele);
                    Worker20TH.setText(totalHash);
                    Worker20Ls.setText(LastHashR);
                    TableRow Worker = findViewById(R.id.Worker20);
                    Worker.setVisibility(View.VISIBLE);
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
