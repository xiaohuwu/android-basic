package com.itheima.drawable.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import com.itheima.drawable.R;

public class ThirdActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initViews();
    }

    private void initViews() {
       findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
				intent.setAction("com.ktb.ForceClose");
				LocalBroadcastManager localBroadcastManager =  LocalBroadcastManager.getInstance(ThirdActivity.this);
				localBroadcastManager.sendBroadcast(intent);
           }
       });
    }

    @Override
    public void onClick(View view) {
     /*   switch (view.getId()){
            case R.id.third:
                Intent intent = new Intent(ThirdActivity.this,GetImgActivity.class);
                startActivity(intent);
                break;
        }*/
    }
}
