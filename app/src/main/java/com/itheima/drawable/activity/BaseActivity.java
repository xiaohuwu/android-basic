package com.itheima.drawable.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends Activity {

    protected List<Activity> list =  new ArrayList<Activity>();

    protected void   addActivity(Activity activity){
        list.add(activity);
    }
    protected void   removeActivity(Activity activity){
        list.remove(activity);
    }
    MyReceiver myReceiver = null;
    @Override
    protected void onResume() {
        super.onResume();
        list.add(this);
        IntentFilter intent =new  IntentFilter();
        intent.addAction("com.ktb.ForceClose");
         myReceiver  =new MyReceiver();
        LocalBroadcastManager localBroadcastManager =  LocalBroadcastManager.getInstance(BaseActivity.this);
        localBroadcastManager.registerReceiver(myReceiver,intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(myReceiver!=null){
            LocalBroadcastManager localBroadcastManager =  LocalBroadcastManager.getInstance(BaseActivity.this);
            localBroadcastManager.unregisterReceiver(myReceiver);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        list.remove(this);
    }

    class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, final Intent intent) {
            Log.i("BaseActivity","BaseActivity");
            /*Builder 里面的Context 参数不能是  onReceive 里面的 context */
            AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
            builder.setTitle("Warning");
            builder.setMessage("You are  forced to be offline");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  list.clear();
                  Intent intent1 = new Intent(BaseActivity.this,MainActivity.class);
                  startActivity(intent1);
                }
            });
            builder.show();
        }
    }
}
