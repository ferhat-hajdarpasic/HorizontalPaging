package com.example.android.horizontalpaging;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.List;

public class WiFiBroadcastReceiver extends BroadcastReceiver {
    private Activity activity;
    public WiFiBroadcastReceiver(Activity activity) {
        this.activity = activity;
        WifiManager mWifiManager = (WifiManager) activity.getSystemService(Context.WIFI_SERVICE);
        activity.registerReceiver(this, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mWifiManager.startScan();
    }
    @Override
    public void onReceive(Context c, Intent intent) {
        if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
            WifiManager mWifiManager = (WifiManager) activity.getSystemService(Context.WIFI_SERVICE);
            List<ScanResult> mScanResults = mWifiManager.getScanResults();
            Log.i("", "Number Of Wifi connections :" + mScanResults.size());
            for(int i = 0; i < mScanResults.size(); i++){
                final ScanResult scanResult = mScanResults.get(i);
                Log.i("BSSID", scanResult.BSSID + ". ");
                Log.i("SSID", scanResult.SSID);
                Log.i("capabilities", scanResult.capabilities);
            }
        }
    }
}
