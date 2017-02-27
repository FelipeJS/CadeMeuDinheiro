package com.felipemarco.cademeudinheiro.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipemarco.cademeudinheiro.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril" , "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Desembro"};
    }
}
