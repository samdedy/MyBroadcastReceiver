package com.juara.mybroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmsReceiverActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSmsFrom;
    private TextView tvSmsMessage;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_receiver);

        setTitle(getString(R.string.incoming_message));

        tvSmsFrom = findViewById(R.id.tv_from);
        tvSmsMessage = findViewById(R.id.tv_message);
        btnClose = findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);

        String senderNo = getIntent().getStringExtra("sms_no");
        String senderMessage = getIntent().getStringExtra("sms_message");

        tvSmsFrom.setText(String.format("from : %s", senderNo));
        tvSmsMessage.setText(senderMessage);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_close){
            finish();
        }
    }
}