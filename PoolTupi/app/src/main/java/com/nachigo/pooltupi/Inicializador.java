package com.nachigo.pooltupi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.DecimalFormat;

/**
 * Created by Gustavo on 23/02/2018.
 */

public class Inicializador {
    public void setPainel(TextView HashPool, TextView Effort, TextView Block, TextView Miners) {
        try {
            String respostaPool = new HttpConnections().execute("https://pooltupi.com/api/pool/stats/pplns").get();
            JSONObject objPool = new JSONObject(respostaPool);
            String respostaNet = new HttpConnections().execute("https://pooltupi.com/api/network/stats").get();
            JSONObject objNet = new JSONObject(respostaNet);
            long rHashes = objPool.getJSONObject("pool_statistics").getLong("roundHashes");
            long diff = objNet.getLong("difficulty");
            double esforço = (100 * rHashes/diff);
            int hashGeral = objPool.getJSONObject("pool_statistics").getInt("hashRate");
            String blocos = objPool.getJSONObject("pool_statistics").getString("totalBlocksFound");
            String qtdMiners = objPool.getJSONObject("pool_statistics").getString("miners");
            String hs;
            if (hashGeral>999 && hashGeral<=999999){
                hashGeral /= 1000;
                hs = hashGeral + " KH/s";
            } else {
                if (hashGeral > 999999) {
                    hashGeral /= 1000000;
                    hs = hashGeral + " MH/s";
                } else {
                    hs = hashGeral + " H/s";
                }
            }
            Effort.setText(esforço + " %");
            Block.setText(blocos);
            Miners.setText(qtdMiners);
            HashPool.setText(hs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDashboard (TextView HashMiner, TextView TotalHash, TextView TotalDevido, TextView TotalPago, TextView priceAeonBrl, String Wallet, Context mContext) {
        try {
            String respostaMiner = new HttpConnections().execute("https://pooltupi.com/api/miner/"+Wallet+"/stats").get();
            JSONObject obj = new JSONObject(respostaMiner);
            int hashrate = obj.getInt("hash");
            long pago = obj.getLong("amtPaid");
            long devido = obj.getLong("amtDue");
            String totalHash = obj.getString("totalHashes");
            int lastHash = obj.getInt("lastHash");
            String hs;
            if (hashrate>999){
                hashrate /= 1000;
                hs = hashrate + " KH/s";
            } else {
                hs = hashrate + " H/s";
            }

            String respostaCoinMarket = new HttpConnections().execute("https://api.coinmarketcap.com/v1/ticker/aeon/?convert=BRL").get();
            JSONArray objCoinMarket = new JSONArray(respostaCoinMarket);
            double price = objCoinMarket.getJSONObject(0).getDouble("price_brl");
            DecimalFormat df = new DecimalFormat("0.##");
            String priceString = "R$ " + df.format(price);


            double devidoDec = devido*0.000000000001;
            double pagoDec = pago*0.000000000001;
            DecimalFormat dfPag = new DecimalFormat("0.##########");
            String pagoString = dfPag.format(pagoDec) + " AEON";
            String devidoString = dfPag.format(devidoDec) + " AEON";
            priceAeonBrl.setText(priceString);
            HashMiner.setText(hs);
            TotalHash.setText(totalHash);
            TotalDevido.setText(devidoString);
            TotalPago.setText(pagoString);
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(mContext, R.string.WrongWallet, Toast.LENGTH_LONG).show();
        }
    }


}
