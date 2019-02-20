package com.perusudroid.fcmpopup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etTxt;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preInit();
        setContentView(R.layout.activity_main);
        bindViews();
        getInputs(getIntent().getExtras());
        setAssets();
    }

    private void setAssets() {
        btnGo.setOnClickListener(this);
    }

    private void bindViews() {
        etTxt = findViewById(R.id.etTxt);
        btnGo = findViewById(R.id.btnGo);
    }

    private void getInputs(Bundle extras) {
        if(extras != null){
            if(extras.getString("txt") != null){
                ((EditText)findViewById(R.id.etTxt)).setText(extras.getString("txt"));
            }
        }

    }

    private void preInit() {
        getWindow().getDecorView().setSystemUiVisibility(1280);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        setTheme(R.style.AppTheme_Light);
    }

    @Override
    public void onClick(View v) {
        if(!etTxt.getText().toString().trim().isEmpty()){
            Intent intent = new Intent();
            intent.putExtra("txt", etTxt.getText().toString().trim());
            intent.setAction(Receiver.ACTION_UPDATE_STATUS);
            sendBroadcast(intent);
            finish();
        }else{
            Toast.makeText(this, "Enter something to send", Toast.LENGTH_SHORT).show();
        }
    }
}
