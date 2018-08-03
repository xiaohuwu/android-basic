package com.itheima.drawable;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
public class GetImgsActivity extends Activity {
   private EditText ed_path;
   private ImageView iv;
    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg) {
            //取出消息中的数据
            Bitmap bitmap = (Bitmap) msg.obj;
            iv.setImageBitmap(bitmap);
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_get_img);
         initViews();
    }
    private void initViews() {
        ed_path = (EditText) findViewById(R.id.ed_path);
        iv = (ImageView) findViewById(R.id.img);
        findViewById(R.id.get_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          String path =  ed_path.getText().toString().trim();
                          URL url  = new URL(path);
                          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                          //设置请求的方式
                          conn.setRequestMethod("GET");
                          // 获得 服务器 返回的 状态吗 , 根据 状态码 去判断 是否 成功
                          int code = conn.getResponseCode();
                          if(code == 200){
                              InputStream inputStream = conn.getInputStream();
                              Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                              Message message = new Message();
                              message.obj = bitmap;
                              mHandler.sendMessage(message);
                              inputStream.close();
                          }
                      } catch (MalformedURLException e) {
                          e.printStackTrace();
                      } catch (ProtocolException e) {
                          e.printStackTrace();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                  }
              }).start();
            }
        });
    }
}
