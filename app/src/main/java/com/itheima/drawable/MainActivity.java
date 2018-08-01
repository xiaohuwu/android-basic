package com.itheima.drawable;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView) findViewById(R.id.iv);
		iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.setAction("com.itheima.drawable.ACTION_START");
				intent.addCategory("com.itheima.drawable.MY_CATEGORY");
				startActivity(intent);
			}
		});
	}
	
	

}
