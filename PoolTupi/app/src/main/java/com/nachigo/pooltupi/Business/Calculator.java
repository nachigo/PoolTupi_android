package com.nachigo.pooltupi.Business;
import android.util.Log;

import com.nachigo.pooltupi.Activitys.Calculadora;
import com.nachigo.pooltupi.Activitys.Painel;
import com.nachigo.pooltupi.Services.HttpConnections;

import org.json.JSONObject;


public class Calculator {

    private long hashrate;

    public void MiningCalculatorAeon (long hash) {
        hashrate = hash;
        new HttpConnections().execute("https://whattomine.com/coins/192.json");
    }
    public void MiningCalculatorAeon (String resposta) {
        hashrate = Calculadora.hashrate;
        try {
            JSONObject objNet = new JSONObject(resposta);
            long diff = objNet.getLong("difficulty") / 240;
            double value = objNet.getDouble("block_reward");
            Calculadora.setCalculoAeon(((((360 * value * hashrate) / diff) * 0.94) * 7),(((360 * value * hashrate) / diff) * 0.94));

        } catch (Exception e) {
            //IDK
            Log.e("Calculo Aeon", e.toString());
        }
    }

    public void MiningCalculatorMonero (long hash) {
        hashrate = hash;
        new HttpConnections().execute("https://whattomine.com/coins/101.json");
    }
    public void MiningCalculatorMonero (String resposta) {
        hashrate = Calculadora.hashrate;
        try {
            JSONObject objNet = new JSONObject(resposta);
            long diff = objNet.getLong("difficulty")/240;
            double value = objNet.getDouble("block_reward");
            Calculadora.setCalculoXMR(((( 360 * value * hashrate)/ diff)*7), (( 360 * value * hashrate)/ diff));

        }catch (Exception e){
            //IDK
            Log.e("Calculo xmr", e.toString());
        }
    }

    public void MiningCalculatorEthereum (long hash) {
        hashrate = hash;
        new HttpConnections().execute("https://whattomine.com/coins/151.json");
    }

    public void MiningCalculatorEthereum (String resposta) {
        hashrate = Calculadora.hashrate;
        try {
            JSONObject objNet = new JSONObject(resposta);
            long diff = objNet.getLong("difficulty")/240;
            double value = objNet.getDouble("block_reward");
            Calculadora.setCalculoETH(((( 360 * value * hashrate)/ diff)*7), (( 360 * value * hashrate)/ diff));

        }catch (Exception e){
            //IDK
            Log.e("Calculo ETH", e.toString());
        }
    }

    public void CalculoPainel(long hash){
        hashrate = hash;
        new HttpConnections().execute("CalculoPainel", "https://whattomine.com/coins/192.json");
    }

    public void setCalculoPainel(String resposta){
        hashrate = Painel.hashrateDia;
        try {
            JSONObject objNet = new JSONObject(resposta);
            long diff = objNet.getLong("difficulty") / 240;
            double value = objNet.getDouble("block_reward");
            Painel.setCalculoAeon((((360 * value * hashrate) / diff) * 0.94) * 7);
        } catch (Exception e) {
            //IDK
            Log.e("Calculo Aeon", e.toString());
        }
    }
}
