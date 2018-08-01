package com.itheima.drawable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondeActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initData();
    }

    private void initData() {
    }

    private void initView() {
      TextView world = (TextView) findViewById(R.id.world);
      world.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SecondeActivity","this is seconde activity");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.world:
                this.finish();
                break;
        }
    }
}
