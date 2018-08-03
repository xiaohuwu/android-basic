package com.itheima.drawable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.third).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.third:
                Intent intent = new Intent(ThirdActivity.this,GetImgActivity.class);
                startActivity(intent);
                break;
        }
    }
}
