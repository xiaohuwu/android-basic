package com.itheima.drawable.activity;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.itheima.drawable.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import static com.itheima.drawable.Utils.PermisionUtils.verifyStoragePermissions;

/**
 * 文件存储相关知识点
 */
public class SaveFileActivity extends Activity {

    EditText account;
    EditText password;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_save_file);
         init_views();
       /* SharedPreferences ktb = getSharedPreferences("ktb", MODE_PRIVATE);
        String account_name =  ktb.getString("account_name","");
        String password_name =  ktb.getString("password_name","");
        account.setText(account_name);
        password.setText(password_name);*/
         loadAccount();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this,"sd 卡可用",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"sd 不卡可用",Toast.LENGTH_SHORT).show();
        }
    }

    private void loadAccount() {
        verifyStoragePermissions(this);
        File file = new File("/sdcard/NewTextFile.txt");
        try {
            FileInputStream fis = new FileInputStream(file);//openFileInput("data");
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(fis));
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = inputStream.readLine())!=null){
                stringBuffer.append(line);
            }
            String text =  stringBuffer.toString();
            if(!TextUtils.isEmpty(text)){
                checkBox.setChecked(true);
                String[] split = text.split("#");
                account.setText(split[0]);
                password.setText(split[1]);
                inputStream.close();
                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init_views() {
         account = (EditText) findViewById(R.id.et_name);
         password = (EditText) findViewById(R.id.et_pass);
        checkBox = (CheckBox) findViewById(R.id.cb);
    }

    public void click(View view) {
        String  account_name =  account.getText().toString().trim();
        String  password_name = password.getText().toString().trim();
        if(checkBox.isChecked()){

           /* SharedPreferences ktb = getSharedPreferences("ktb", MODE_PRIVATE);
            SharedPreferences.Editor edit = ktb.edit();
            edit.putString("account_name",account_name);
            edit.putString("password_name",password_name);
            edit.commit();*/
            saveAccount(account_name,password_name);
        }else {
            clearAccout();
        }
    }

    private void clearAccout() {

        try {
            FileOutputStream out = openFileOutput("data", MODE_PRIVATE);
            out.write("".getBytes());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAccount(String account_name, String password_name) {
        verifyStoragePermissions(this);
        File file = new File("/sdcard/NewTextFile.txt");
        try {
            FileOutputStream data = openFileOutput("data", MODE_PRIVATE);
            //OutputStream out = new FileOutputStream(file);
            data.write((account_name+"#"+password_name).getBytes());
            data.flush();
            data.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
