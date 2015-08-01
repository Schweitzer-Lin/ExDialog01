package com.ehappy.exdialog01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    //建立全域變數
    private EditText edtATM;
    private Button btnN1, btnN2, btnN3;
    private Button btnN4, btnN5, btnN6;
    private Button btnN7, btnN8, btnN9, btnN0;
    private Button btnBack, btnOK, btnEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取得介面元件
        edtATM=(EditText)findViewById(R.id.edtATM);
        btnN1=(Button)findViewById(R.id.btnN1);
        btnN2=(Button)findViewById(R.id.btnN2);
        btnN3=(Button)findViewById(R.id.btnN3);
        btnN4=(Button)findViewById(R.id.btnN4);
        btnN5=(Button)findViewById(R.id.btnN5);
        btnN6=(Button)findViewById(R.id.btnN6);
        btnN7=(Button)findViewById(R.id.btnN7);
        btnN8=(Button)findViewById(R.id.btnN8);
        btnN9=(Button)findViewById(R.id.btnN9);
        btnN0=(Button)findViewById(R.id.btnN0);
        btnBack=(Button)findViewById(R.id.btnBack);
        btnOK=(Button)findViewById(R.id.btnOK);
        btnEnd=(Button)findViewById(R.id.btnEnd);
        //設定共用事件
        btnN1.setOnClickListener(listener);
        btnN2.setOnClickListener(listener);
        btnN3.setOnClickListener(listener);
        btnN4.setOnClickListener(listener);
        btnN5.setOnClickListener(listener);
        btnN6.setOnClickListener(listener);
        btnN7.setOnClickListener(listener);
        btnN8.setOnClickListener(listener);
        btnN9.setOnClickListener(listener);
        btnN0.setOnClickListener(listener);
        btnBack.setOnClickListener(listener);
        btnOK.setOnClickListener(listener);
        btnEnd.setOnClickListener(listener);
    }

    private Button.OnClickListener listener=new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnN1:  //按 1 鈕
                    displayATM("1");
                    break;
                case R.id.btnN2:  //按 2 鈕
                    displayATM("2");
                    break;
                case R.id.btnN3:  //按 3 鈕
                    displayATM("3");
                    break;
                case R.id.btnN4:  //按 4 鈕
                    displayATM("4");
                    break;
                case R.id.btnN5:  //按 5 鈕
                    displayATM("5");
                    break;
                case R.id.btnN6:  //按 6 鈕
                    displayATM("6");
                    break;
                case R.id.btnN7:  //按 7 鈕
                    displayATM("7");
                    break;
                case R.id.btnN8:  //按 8 鈕
                    displayATM("8");
                    break;
                case R.id.btnN9:  //按 9 鈕
                    displayATM("9");
                    break;
                case R.id.btnN0:  //按 0 鈕
                    displayATM("0");
                    break;
                case R.id.btnBack:  //按 清除 鈕
                    String str=edtATM.getText().toString();
                    if(str.length()>0) {
                        str=str.substring(0, str.length()-1);
                        edtATM.setText(str);
                    }
                    break;
                case R.id.btnOK:  //按 確定 鈕
                    str=edtATM.getText().toString();
                    if(str.equals("123456")) {
                        Toast toast=Toast.makeText(MainActivity.this, "密碼正確！歡迎使用提款功能。", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    } else {
                        Toast toast=Toast.makeText(MainActivity.this, "密碼錯誤，請重新輸入。", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        edtATM.setText("");
                    }
                    break;
                case R.id.btnEnd:   //按 結束 鈕
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("確認視窗")
                            .setIcon(R.drawable.ic_launcher)
                            .setMessage("Are you sure close this application")
                            .setPositiveButton("OK", new
                                DialogInterface.OnClickListener () {
                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        finish();
                                    }
                                })
                            .setNegativeButton("Cancel", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int i) {

                                    }
                            })
                            .show();
                    break;
            }
        }
    };

    private void displayATM(String s) {
        String str=edtATM.getText().toString();
        edtATM.setText(str + s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
