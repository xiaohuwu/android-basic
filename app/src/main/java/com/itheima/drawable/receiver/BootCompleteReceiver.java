package com.itheima.drawable.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Boot complete",Toast.LENGTH_LONG).show();
        Log.i("MybrocastReceiver","BootCompleteReceiver");
    }
}
