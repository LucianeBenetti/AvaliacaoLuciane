package com.example.avaliacaoluciane.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.avaliacaoluciane.Control.DadoControl;
import com.example.avaliacaoluciane.Control.MainControl;
import com.example.avaliacaoluciane.R;

public class DadoActivity extends AppCompatActivity {
    private DadoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dado);
        control = new DadoControl(this);
    }

    public void enviar (View v){
        control.enviarAction();
    }
    public void cancelar (View v){

        control.cancelarAction();

    }
}
