package com.nachigo.pooltupi.Activitys;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.nachigo.pooltupi.Business.Calculator;
import com.nachigo.pooltupi.Services.HttpConnections;
import com.nachigo.pooltupi.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Painel extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static String Wallet;
    Handler handler = new Handler();
    Runnable refresh;
    Boolean AindaAqui = true;
    public static long hashrateDia = 0;
    private static double priceAeon = 0;
    private static double mediaWeek = 0;
    private static TextView HashMiner;
    private static TextView TotalHash;
    private static TextView TotalDevido;
    private static TextView TotalPago;
    private static TextView Price;
    private static TextView HashrateD;
    private static TextView Media;
    private static TextView Worker10Nome;
    private static TextView Worker10Hs ;
    private static TextView Worker10TH ;
    private static TextView Worker10Ls ;
    private static TextView Worker11Nome;
    private static TextView Worker11Hs ;
    private static TextView Worker11TH ;
    private static TextView Worker11Ls ;
    private static TextView Worker12Nome;
    private static TextView Worker12Hs ;
    private static TextView Worker12TH ;
    private static TextView Worker12Ls ;
    private static TextView Worker13Nome;
    private static TextView Worker13Hs ;
    private static TextView Worker13TH ;
    private static TextView Worker13Ls ;
    private static TextView Worker14Nome;
    private static TextView Worker14Hs ;
    private static TextView Worker14TH ;
    private static TextView Worker14Ls ;
    private static TextView Worker15Nome;
    private static TextView Worker15Hs ;
    private static TextView Worker15TH ;
    private static TextView Worker15Ls ;
    private static TextView Worker16Nome;
    private static TextView Worker16Hs ;
    private static TextView Worker16TH ;
    private static TextView Worker16Ls ;
    private static TextView Worker17Nome;
    private static TextView Worker17Hs ;
    private static TextView Worker17TH ;
    private static TextView Worker17Ls ;
    private static TextView Worker18Nome;
    private static TextView Worker18Hs ;
    private static TextView Worker18TH ;
    private static TextView Worker18Ls ;
    private static TextView Worker19Nome;
    private static TextView Worker19Hs ;
    private static TextView Worker19TH ;
    private static TextView Worker19Ls ;
    private static TextView Worker20Nome;
    private static TextView Worker20Hs ;
    private static TextView Worker20TH ;
    private static TextView Worker20Ls ;
    private static TextView Worker1Nome;
    private static TextView Worker1Hs ;
    private static TextView Worker1TH ;
    private static TextView Worker1Ls ;
    private static TextView Worker2Nome;
    private static TextView Worker2Hs ;
    private static TextView Worker2TH ;
    private static TextView Worker2Ls ;
    private static TextView Worker3Nome;
    private static TextView Worker3Hs ;
    private static TextView Worker3TH ;
    private static TextView Worker3Ls ;
    private static TextView Worker4Nome;
    private static TextView Worker4Hs ;
    private static TextView Worker4TH ;
    private static TextView Worker4Ls ;
    private static TextView Worker5Nome;
    private static TextView Worker5Hs ;
    private static TextView Worker5TH ;
    private static TextView Worker5Ls ;
    private static TextView Worker6Nome;
    private static TextView Worker6Hs ;
    private static TextView Worker6TH ;
    private static TextView Worker6Ls ;
    private static TextView Worker7Nome;
    private static TextView Worker7Hs ;
    private static TextView Worker7TH ;
    private static TextView Worker7Ls ;
    private static TextView Worker8Nome;
    private static TextView Worker8Hs ;
    private static TextView Worker8TH ;
    private static TextView Worker8Ls ;
    private static TextView Worker9Nome;
    private static TextView Worker9Hs ;
    private static TextView Worker9TH ;
    private static TextView Worker9Ls ;
    private static TableRow Worker11;
    private static TableRow Worker12;
    private static TableRow Worker13;
    private static TableRow Worker14;
    private static TableRow Worker15;
    private static TableRow Worker16;
    private static TableRow Worker17;
    private static TableRow Worker18;
    private static TableRow Worker19;
    private static TableRow Worker20;

    private static ArrayList<String> workers;

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

        HashMiner  = findViewById(R.id.TxtHashMiner);
        TotalHash  = findViewById(R.id.TxtTotalHashes);
        TotalDevido = findViewById(R.id.TxtDevido);
        TotalPago  = findViewById(R.id.TxtPago);
        Price      = findViewById(R.id.TxtAeonBrl);

        HashrateD = findViewById(R.id.TxtHashD);
        Media    = findViewById(R.id.TxtProfit);

        Worker1Nome = findViewById(R.id.Worker1Name);
        Worker1Hs = findViewById(R.id.Worker1Hs);
        Worker1TH = findViewById(R.id.Worker1TH);
        Worker1Ls = findViewById(R.id.Worker1LH);
        Worker2Nome = findViewById(R.id.worker2Nome);
        Worker2Hs = findViewById(R.id.worker2Hs);
        Worker2TH = findViewById(R.id.worker2TH);
        Worker2Ls = findViewById(R.id.worker2LH);
        Worker3Nome = findViewById(R.id.worker3Nome);
        Worker3Hs = findViewById(R.id.worker3Hs);
        Worker3TH = findViewById(R.id.worker3TH);
        Worker3Ls = findViewById(R.id.worker3LH);
        Worker4Nome = findViewById(R.id.worker4Nome);
        Worker4Hs = findViewById(R.id.worker4Hs);
        Worker4TH = findViewById(R.id.worker4TH);
        Worker4Ls = findViewById(R.id.worker4LH);

        Worker5Nome = findViewById(R.id.worker5Nome);
        Worker5Hs = findViewById(R.id.worker5Hs);
        Worker5TH = findViewById(R.id.worker5TH);
        Worker5Ls = findViewById(R.id.worker5LH);

        Worker6Nome = findViewById(R.id.worker6Nome);
        Worker6Hs = findViewById(R.id.worker6Hs);
        Worker6TH = findViewById(R.id.worker6TH);
        Worker6Ls = findViewById(R.id.worker6LH);

        Worker7Nome = findViewById(R.id.worker7Nome);
        Worker7Hs = findViewById(R.id.worker7Hs);
        Worker7TH = findViewById(R.id.worker7TH);
        Worker7Ls = findViewById(R.id.worker7LH);

        Worker8Nome = findViewById(R.id.worker8Nome);
        Worker8Hs = findViewById(R.id.worker8Hs);
        Worker8TH = findViewById(R.id.worker8TH);
        Worker8Ls = findViewById(R.id.worker8LH);

        Worker9Nome = findViewById(R.id.worker9Nome);
        Worker9Hs = findViewById(R.id.worker9Hs);
        Worker9TH = findViewById(R.id.worker9TH);
        Worker9Ls = findViewById(R.id.worker9LH);

        Worker10Nome = findViewById(R.id.worker10Nome);
        Worker10Hs = findViewById(R.id.worker10Hs);
        Worker10TH = findViewById(R.id.worker10TH);
        Worker10Ls = findViewById(R.id.worker10LH);

        Worker11Nome = findViewById(R.id.Worker11Name);
        Worker11Hs = findViewById(R.id.Worker11Hs);
        Worker11TH = findViewById(R.id.Worker11TH);
        Worker11Ls = findViewById(R.id.Worker11LH);
        Worker12Nome = findViewById(R.id.worker12Nome);
        Worker12Hs = findViewById(R.id.worker12Hs);
        Worker12TH = findViewById(R.id.worker12TH);
        Worker12Ls = findViewById(R.id.worker12LH);
        Worker13Nome = findViewById(R.id.worker13Nome);
        Worker13Hs = findViewById(R.id.worker13Hs);
        Worker13TH = findViewById(R.id.worker13TH);
        Worker13Ls = findViewById(R.id.worker13LH);
        Worker14Nome = findViewById(R.id.worker14Nome);
        Worker14Hs = findViewById(R.id.worker14Hs);
        Worker14TH = findViewById(R.id.worker14TH);
        Worker14Ls = findViewById(R.id.worker14LH);

        Worker15Nome = findViewById(R.id.worker15Nome);
        Worker15Hs = findViewById(R.id.worker15Hs);
        Worker15TH = findViewById(R.id.worker15TH);
        Worker15Ls = findViewById(R.id.worker15LH);

        Worker16Nome = findViewById(R.id.worker16Nome);
        Worker16Hs = findViewById(R.id.worker16Hs);
        Worker16TH = findViewById(R.id.worker16TH);
        Worker16Ls = findViewById(R.id.worker16LH);

        Worker17Nome = findViewById(R.id.worker17Nome);
        Worker17Hs = findViewById(R.id.worker17Hs);
        Worker17TH = findViewById(R.id.worker17TH);
        Worker17Ls = findViewById(R.id.worker17LH);

        Worker18Nome = findViewById(R.id.worker18Nome);
        Worker18Hs = findViewById(R.id.worker18Hs);
        Worker18TH = findViewById(R.id.worker18TH);
        Worker18Ls = findViewById(R.id.worker18LH);

        Worker19Nome = findViewById(R.id.worker19Nome);
        Worker19Hs = findViewById(R.id.worker19Hs);
        Worker19TH = findViewById(R.id.worker19TH);
        Worker19Ls = findViewById(R.id.worker19LH);

        Worker20Nome = findViewById(R.id.worker20Nome);
        Worker20Hs = findViewById(R.id.worker20Hs);
        Worker20TH = findViewById(R.id.worker20TH);
        Worker20Ls = findViewById(R.id.worker20LH);

        Worker11 = findViewById(R.id.Worker11);
        Worker12 = findViewById(R.id.Worker12);
        Worker13 = findViewById(R.id.Worker13);
        Worker14 = findViewById(R.id.Worker14);
        Worker15 = findViewById(R.id.Worker15);
        Worker16 = findViewById(R.id.Worker16);
        Worker17 = findViewById(R.id.Worker17);
        Worker18 = findViewById(R.id.Worker18);
        Worker19 = findViewById(R.id.Worker19);
        Worker20 = findViewById(R.id.Worker20);

        workers = new ArrayList<String>();

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
        refresh = new Runnable() {
            public void run() {
                Inicia(Wallet);
                Log.e("Refresh painel miner", "refresh");
                handler.postDelayed(refresh, 20000);
            }
        };
        handler.post(refresh);
    }

    @Override
    protected void onResume(){
        super.onResume();

        EditText EdtWallet = findViewById(R.id.EdtWallet);
        EdtWallet.clearFocus();
        LinearLayout x = findViewById(R.id.idk);
        x.requestFocus();
    }

    private void Inicia(String Wallet){
        SharedPreferences settings = getSharedPreferences("tupiniquim", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Wallet", Wallet);
        editor.commit();

        new HttpConnections().execute("https://pooltupi.com/api/miner/" + Wallet + "/stats");
        new HttpConnections().execute("PainlDiario", "https://pooltupi.com/api/miner/" + Wallet + "/chart/hashrate");
        new HttpConnections().execute( "AeonCapPainel", "https://api.coinmarketcap.com/v2/ticker/1026/?convert=BRL");
        new HttpConnections().execute("Miners","https://pooltupi.com/api/miner/" + Wallet + "/identifiers");

    }



    public static void setPainel(String resposta){
        try {
            JSONObject obj = new JSONObject(resposta);
            long hashrate = obj.getLong("hash");
            long pago = obj.getLong("amtPaid");
            long devido = obj.getLong("amtDue");
            String totalHash = obj.getString("totalHashes");
            String hs;
            if (hashrate > 999) {
                double var;
                var = hashrate * 0.001;
                DecimalFormat decimalFormat = new DecimalFormat("0.###");
                hs = var + " KH/s";
            } else {
                hs = hashrate + " H/s";
            }

            DecimalFormat df = new DecimalFormat("0.##");
            String priceString = "R$ " + df.format(priceAeon);

            double devidoDec = devido * 0.000000000001;
            double pagoDec = pago * 0.000000000001;
            DecimalFormat dfPag = new DecimalFormat("0.##########");
            String pagoString = dfPag.format(pagoDec) + " AEON";
            String devidoString = dfPag.format(devidoDec) + " AEON";



            Price.setText(priceString);
            HashMiner.setText(hs);
            TotalHash.setText("Total hashes: " + totalHash);
            TotalDevido.setText(devidoString);
            TotalPago.setText(pagoString);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void setCalculoAeon(double media){

        mediaWeek = media;

        DecimalFormat df = new DecimalFormat("0.##");

        if(priceAeon > 0) {
            double mediaRS = priceAeon * mediaWeek;
            String mediaStrg = "≅ " + df.format(mediaWeek) + " AEON / ≅ R$" + df.format(mediaRS) + " / semana";
            Media.setText(mediaStrg);
        }
    }

    public static void setPainelDiario (String resposta){

        try {
            JSONArray objHS = new JSONArray(resposta);
            long currentTS = System.currentTimeMillis()/1000;
            currentTS -= 86400;
            int cont = 0;
            long ts = objHS.getJSONObject(0).getLong("ts")/1000;
            while (ts > currentTS && cont<objHS.length()-1) {
                hashrateDia += objHS.getJSONObject(cont).getLong("hs");
                cont++;
                ts = objHS.getJSONObject(cont).getLong("ts")/1000;
            }

            if(cont == 0){
                hashrateDia = 0;
            } else {
                hashrateDia = hashrateDia / cont;
            }

            DecimalFormat df = new DecimalFormat("0.##");
            new Calculator().CalculoPainel(hashrateDia);
            String texto;

            if (hashrateDia > 999) {
                double var = hashrateDia * 0.001;
                DecimalFormat decimalFormat = new DecimalFormat("0.###");
                texto = (decimalFormat.format(var) + " KH/s");
            } else {
                texto = (hashrateDia + " H/s");
            }
            HashrateD.setText(texto);

            // Se já tiver a mediaSemana e o preço do aeon inicia a media em reais
            if(priceAeon > 0 ) {
                double mediaRS = priceAeon * mediaWeek;
                String mediaSTR = "≅ " + df.format(mediaWeek) + " AEON / ≅ R$" + df.format(mediaRS) + " / semana";
                Media.setText(mediaSTR);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void setAeonCap(String resposta){

        DecimalFormat df = new DecimalFormat("0.##");
        try {
            JSONObject objCoinMarket = new JSONObject(resposta);
            priceAeon = objCoinMarket.getJSONObject("data").getJSONObject("quotes").getJSONObject("BRL").getDouble("price");
            if(mediaWeek > 0 ) {
                double mediaRS = priceAeon * mediaWeek;
                String mediaSTR = "≅ " + df.format(mediaWeek) + " AEON / ≅ R$" + df.format(mediaRS) + " / semana";
                Media.setText(mediaSTR);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void setListMiners(String resposta){
        try {
            JSONArray objWorker = new JSONArray(resposta);
            for (int i = 0; i < objWorker.length(); i++) {
                workers.add(objWorker.getString(i));
                new HttpConnections().execute("Maquina "+i, "https://pooltupi.com/api/miner/" + Wallet + "/stats/" + workers.get(i));
            }
        }catch (Exception e){
        }
    }

    public static void setMinerMachine(String resposta, String MinerMachine){

        try {
             JSONObject objWorkerI = new JSONObject(resposta);
             String hashrate = objWorkerI.getString("hash");
             String totalHash = objWorkerI.getString("totalHash");
             String LastHashR = "";
             long lastHash = objWorkerI.getLong("lts");

             //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             long currentTS = System.currentTimeMillis() / 1000;
             //Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
             long tempo = currentTS - lastHash;
             if (tempo >= 60 & tempo <= 3600) {
                 tempo = tempo / 60;
                 LastHashR = tempo + " min atrás";
             } else {
                 if (tempo >= 3600) {
                     tempo = tempo / 3600;
                     LastHashR = tempo + " hr atrás";
                 } else {
                     LastHashR = " few seconds ago";
                 }
             }

             switch (MinerMachine) {
                 case "Maquina 0":
                     Worker1Hs.setText(hashrate);
                     Worker1Nome.setText(workers.get(0));
                     Worker1TH.setText(totalHash);
                     Worker1Ls.setText(LastHashR);
                 break;
                 case "Maquina 1":
                     Worker2Hs.setText(hashrate);
                     Worker2Nome.setText( workers.get(1));
                     Worker2TH.setText(totalHash);
                     Worker2Ls.setText(LastHashR);
                     break;
                 case "Maquina 2":
                     Worker3Hs.setText(hashrate);
                     Worker3Nome.setText( workers.get(2));
                     Worker3TH.setText(totalHash);
                     Worker3Ls.setText(LastHashR);
                     break;
                 case "Maquina 3":
                     Worker4Hs.setText(hashrate);
                     Worker4Nome.setText( workers.get(3));
                     Worker4TH.setText(totalHash);
                     Worker4Ls.setText(LastHashR);
                     break;
                 case "Maquina 4":
                     Worker5Hs.setText(hashrate);
                     Worker5Nome.setText( workers.get(4));
                     Worker5TH.setText(totalHash);
                     Worker5Ls.setText(LastHashR);
                     break;
                 case "Maquina 5":
                     Worker6Hs.setText(hashrate);
                     Worker6Nome.setText( workers.get(5));
                     Worker6TH.setText(totalHash);
                     Worker6Ls.setText(LastHashR);
                     break;
                 case "Maquina 6":
                     Worker7Hs.setText(hashrate);
                     Worker7Nome.setText( workers.get(6));
                     Worker7TH.setText(totalHash);
                     Worker7Ls.setText(LastHashR);
                     break;
                 case "Maquina 7":
                     Worker8Hs.setText(hashrate);
                     Worker8Nome.setText( workers.get(7));
                     Worker8TH.setText(totalHash);
                     Worker8Ls.setText(LastHashR);
                     break;
                 case "Maquina 8":
                     Worker9Hs.setText(hashrate);
                     Worker9Nome.setText( workers.get(8));
                     Worker9TH.setText(totalHash);
                     Worker9Ls.setText(LastHashR);
                     break;
                 case "Maquina 9":
                     Worker10Hs.setText(hashrate);
                     Worker10Nome.setText( workers.get(9));
                     Worker10TH.setText(totalHash);
                     Worker10Ls.setText(LastHashR);
                     break;
                 case "Maquina 10":
                     Worker11Hs.setText(hashrate);
                     Worker11Nome.setText( workers.get(10));
                     Worker11TH.setText(totalHash);
                     Worker11Ls.setText(LastHashR);
                     Worker11.setVisibility(View.VISIBLE);
                     break;
                 case "Maquina 11":
                     Worker12Hs.setText(hashrate);
                     Worker12Nome.setText( workers.get(11));
                     Worker12TH.setText(totalHash);
                     Worker12Ls.setText(LastHashR);
                     Worker12.setVisibility(View.VISIBLE);
                     break;
                 case "Maquina 12":
                     Worker13Hs.setText(hashrate);
                     Worker13Nome.setText( workers.get(12));
                     Worker13TH.setText(totalHash);
                     Worker13Ls.setText(LastHashR);
                     Worker13.setVisibility(View.VISIBLE);
                     break;
                 case "Maquina 13":
                     Worker14Hs.setText(hashrate);
                     Worker14Nome.setText( workers.get(13));
                     Worker14TH.setText(totalHash);
                     Worker14Ls.setText(LastHashR);
                     Worker14.setVisibility(View.VISIBLE);
                     break;
                 case "Maquina 14":
                     Worker15Hs.setText(hashrate);
                     Worker15Nome.setText( workers.get(14));
                     Worker15TH.setText(totalHash);
                     Worker15Ls.setText(LastHashR);
                     Worker15.setVisibility(View.VISIBLE);
                     break;
                 case "Maquina 15":
                     Worker16Hs.setText(hashrate);
                     Worker16Nome.setText( workers.get(15));
                     Worker16TH.setText(totalHash);
                     Worker16Ls.setText(LastHashR);
                     Worker16.setVisibility(View.VISIBLE);
                     break;
                 case "Maquina 16":
                     Worker17Hs.setText(hashrate);
                     Worker17Nome.setText( workers.get(16));
                     Worker17TH.setText(totalHash);
                     Worker17Ls.setText(LastHashR);
                     Worker17.setVisibility(View.VISIBLE);
                     break;
                 case "Maquina 17":
                     Worker18Hs.setText(hashrate);
                     Worker18Nome.setText( workers.get(17));
                     Worker18TH.setText(totalHash);
                     Worker18Ls.setText(LastHashR);
                     Worker18.setVisibility(View.VISIBLE);
                     break;
                 case "Maquina 18":
                     Worker19Hs.setText(hashrate);
                     Worker19Nome.setText( workers.get(18));
                     Worker19TH.setText(totalHash);
                     Worker19Ls.setText(LastHashR);
                     Worker19.setVisibility(View.VISIBLE);
                     break;
                 case "Maquina 19":
                     Worker20Hs.setText(hashrate);
                     Worker20Nome.setText( workers.get(19));
                     Worker20TH.setText(totalHash);
                     Worker20Ls.setText(LastHashR);
                     Worker20.setVisibility(View.VISIBLE);
                     break;
             }

         }catch (Exception e) {
             e.printStackTrace();
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
            AindaAqui = false;
            Intent intent = new Intent(this, FAQ_activity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_painel) {
            AindaAqui = false;

            Intent intent = new Intent(this, Painel.class);
            startActivity(intent);
            finish();
        } else if(id == R.id.nav_calculadora) {
            AindaAqui = false;
            Intent intent = new Intent(this, Calculadora.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_whatsapp) {
            AindaAqui = false;
            String url = "https://chat.whatsapp.com/FDryMCtFYUS5C0AjrB2A0K";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if (id == R.id.nav_telegram) {
            AindaAqui = false;
            String url = "https://t.me/pooltupi/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if(id == R.id.nav_Sobre) {
            AindaAqui = false;
            Intent intent = new Intent(this, Sobre.class);
            startActivity(intent);
            finish();
        } else if(id == R.id.nav_Config) {
            AindaAqui = false;
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
