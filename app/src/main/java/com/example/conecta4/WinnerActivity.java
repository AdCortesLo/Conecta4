package com.example.conecta4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        TextView tv = findViewById(R.id.textView);
        Intent i = getIntent();
        String ganador = i.getStringExtra("ganador");
        tv.setText(Html.fromHtml((ganador.equals("R") ? "<font color='#ff0000'> RED WINS </font>" : "<font color='#e6e600'> YELLOW WINS </font>")));
    }

    public void onClickButtonVolver(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
