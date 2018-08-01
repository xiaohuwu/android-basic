package com.itheima.drawable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondeActivity extends Activity implements View.OnClickListener {

    public static final String TAG="SecondeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i(TAG,this.toString());
        initView();
        initData();
    }

    private void initData() {
    }

    private void initView() {
      TextView world = (TextView) findViewById(R.id.world);
      world.setOnClickListener(this);
      findViewById(R.id.start).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SecondeActivity","this is seconde activity");
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.world:
                 intent = new Intent();
                intent.putExtra("result","second data");
                setResult(201,intent);
                this.finish();
                break;
            case R.id.start:
                intent = new Intent(SecondeActivity.this,SecondeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
