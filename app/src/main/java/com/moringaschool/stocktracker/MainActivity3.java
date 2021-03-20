package com.moringaschool.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String[] symbols = {"BTC", "Ethereum", "Binance Coin", "Cardano", "Tether", "Polkadot", "XRP", "Uniswap", "Litecoin", "Chainlink", "Bitcoin Cash", "USD Coin", "Stellar", "THETA", "Dogecoin", "VeChain", "Crypto.org Coin", "Filecoin", "Aave", "Cosmos", "Avalanche"};
        String[] names = {"Bitcoin", "ETH", "BNB", "ADA", "USDT", "DOT", "XRP", "UNI", "LTC", "LINK", "BCH", "USDC", "XLM", "THETA", "DOGE", "VET", "CRO", "FIL", "AAVE", "ATOM", "AVAX"};
        String[] stockPrice = {"$59,314.50", "$1,847.50", "$270.75", "$1.24", "$1.00", "$39.39", "$0.519659", "$32.53", "$203.78", "$30.48", "$546.84", "$1.00", "$0.426406", "$8.27", "$0.059547", "$0.091262", "$0.226915", "$83.17", "$389.65", "$22.30", "$35.82"};
        String[] trend = {"+2.38%", "+0.83%", "+1.46%", "+4.22%", "+0.08%", "+2.16%", "+10.27%", "+1.571%", "+2.94%", "%+0.89%", "+4.08%", "+0.096%", "+0.079%", "+-6.34%", "+0.044%", "+0.66%", "+0.091%", "+0.071%", "+1.88%", "+0.085%", "+0.80%"};
    }
}