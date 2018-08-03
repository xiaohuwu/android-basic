package com.itheima.drawable.activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.itheima.drawable.R;

public class MainActivity extends BaseActivity {
	public static final String TAG="MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View viewById = findViewById(R.id.button_1);
		View get_mig = findViewById(R.id.button_2);
		View button_3 = findViewById(R.id.button_3);

		button_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
				startActivity(intent);
			}
		});
		get_mig.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this,GetImgsActivity.class);
				startActivity(intent);
			}
		});
        /*文件存储*/
		viewById.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this,SaveFileActivity.class);
				startActivity(intent);
			}
		});

         /* 发送自定义广播 */
		findViewById(R.id.button_8).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.setAction("com.ktb.MybrocastReceiver");
				LocalBroadcastManager localBroadcastManager =  LocalBroadcastManager.getInstance(MainActivity.this);
				localBroadcastManager.sendBroadcast(intent);
			}
		});

		findViewById(R.id.button_9).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
				startActivity(intent);

			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG,"onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG,"onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG,"onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG,"onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG,"onDestroy");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG,"onRestart");
	}

	/*得到调用页面返回的数据*/

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==200 && resultCode==201){
			String result = data.getStringExtra("result");
			Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
		}
	}


}
