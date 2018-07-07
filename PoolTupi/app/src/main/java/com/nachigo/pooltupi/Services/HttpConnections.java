package com.nachigo.pooltupi.Services;

import android.os.AsyncTask;
import android.util.Log;

import com.nachigo.pooltupi.Activitys.Calculadora;
import com.nachigo.pooltupi.Activitys.MainActivity;
import com.nachigo.pooltupi.Activitys.Painel;
import com.nachigo.pooltupi.Business.Calculator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Gustavo on 22/02/2018.
 */

public class HttpConnections extends AsyncTask <String, Void , Void> {

    public String urlString;
    public String obj;

    @Override
    protected Void doInBackground(String... strings) {
        urlString = strings[strings.length - 1];
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            obj = buffer.toString();

            if (strings.length > 1) {
                urlString = strings[strings.length - 2];
            }
        } catch (Exception e) {
            Log.e("HttpConection", e.toString() + " " + strings);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void x) {
        String poolD = String.format("https://pooltupi.com/api/miner/"+Painel.Wallet+"/chart/hashrate/");
        if (urlString.contains("/stats")){
            try {
                // MinerStats
                Painel.setPainel(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(urlString.contains("Maquina")){
            Painel.setMinerMachine(obj, urlString);
        }
        if (urlString.contains("CalculoPainel")) {
            new Calculator().setCalculoPainel(obj);
        }
        if(urlString.contains("AeonCapPainel")){
            Painel.setAeonCap(obj);
        }
        switch (urlString) {
            case "https://pooltupi.com/api/network/stats":
                MainActivity.setNet(obj);
                break;
            case "https://pooltupi.com/api/pool/stats/pplns":
                try {
                    MainActivity.setPool(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "https://api.coinmarketcap.com/v2/ticker/1026/?convert=BRL":
                try {
                    Calculadora.setAeonCap(obj);
                    //CoinMarketCapAeon
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "https://api.coinmarketcap.com/v2/ticker/328/?convert=BRL":
                try {
                    //CoinMarketCapMonero
                    Calculadora.setXMRCap(obj);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "https://api.coinmarketcap.com/v2/ticker/1027/?convert=BRL":
                try {
                    //CoinMarketCapEth
                    Calculadora.setETHCap(obj);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "PainlDiario":
                Painel.setPainelDiario(obj);
                break;
            case "AeonCapPainel":
                Painel.setAeonCap(obj);
                break;
            case "https://whattomine.com/coins/192.json":
                new Calculator().MiningCalculatorAeon(obj);
                break;
            case "https://whattomine.com/coins/151.json":
                new Calculator().MiningCalculatorEthereum(obj);
                break;
            case "https://whattomine.com/coins/101.json":
                new Calculator().MiningCalculatorMonero(obj);
                break;
            case "Miners":
                Painel.setListMiners(obj);
                break;
        }

    }
}

