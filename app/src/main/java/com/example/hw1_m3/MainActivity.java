package com.example.hw1_m3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.btn_send);
        EditText email = findViewById(R.id.email);
        EditText theme = findViewById(R.id.theme);
        EditText massage = findViewById(R.id.massage);

        send.setOnClickListener(view -> {
            String e_mail = email.getText().toString();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{e_mail});
            intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, massage.getText().toString());
            intent.setType("text/plain");
            if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(Intent.createChooser(intent, "Send"));
            }
        });

    }
}