package com.itheima.drawable.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MybrocastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "MybrocastReceiver", Toast.LENGTH_SHORT).show();
        Log.i("MybrocastReceiver","MybrocastReceiver");
    }
}
