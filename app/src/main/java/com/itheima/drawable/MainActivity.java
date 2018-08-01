package com.itheima.drawable;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;
public class MainActivity extends Activity {

	ImageView iv;
	public static final String TAG="MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView) findViewById(R.id.iv);
		View viewById = findViewById(R.id.button_1);
		viewById.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this,DialogActivity.class);
				startActivity(intent);
			}
		});

		iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.setAction("com.itheima.drawable.ACTION_START");
				intent.addCategory("com.itheima.drawable.MY_CATEGORY");
				startActivityForResult(intent,200);
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
