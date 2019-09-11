package com.example.avaliacaoluciane.Control;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avaliacaoluciane.Model.Config;
import com.example.avaliacaoluciane.Model.ConfigBO;
import com.example.avaliacaoluciane.Model.Dado;
import com.example.avaliacaoluciane.Model.DadoBO;
import com.example.avaliacaoluciane.R;
import com.example.avaliacaoluciane.Util.Constantes;
import com.example.avaliacaoluciane.View.DadoActivity;

public class MainControl {

    private Activity activity;
    private EditText editMinimo;
    private EditText editMaximo;
    private TextView tvResultado;
    private LinearLayout layoutRes;
    private Dado dado;
    private Config config;

    public MainControl(Activity activity) {
        this.activity = activity;
        dado = new Dado();
        config = new Config();
        initComponents();
    }
    public void initComponents() {
        editMinimo = activity.findViewById(R.id.editTextMinimo);
        editMaximo = activity.findViewById(R.id.editTextMaximo);
        tvResultado = activity.findViewById(R.id.tvResultado);
        layoutRes = activity.findViewById(R.id.layoutResultado);
    }

    public boolean valida(Config c){
        ConfigBO configBO = new ConfigBO();
        if(!configBO.valida(c)){
            Toast.makeText(activity, R.string.valida_config, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
        }

    public void enviarAction(){
        Config c = getDadosForm();
        if(valida(c)){
            Intent it = new Intent(activity, DadoActivity.class);
            it.putExtra(Constantes.Parametros.CONFIG, c);
            it.putExtra(Constantes.Parametros.DADO, dado);
            activity.startActivityForResult(it, Constantes.Request.DADO);
        }
    }

    private Config getDadosForm() {
        Config config = new Config();
        config.setMinimo(editMinimo.getText().toString());
        config.setMaximo(editMaximo.getText().toString());

        return config;

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == activity.RESULT_OK) {
            if (requestCode == Constantes.Request.DADO) {
                dado = (Dado) data.getSerializableExtra(Constantes.Parametros.DADO);

               // tvResultado.setText(dado.toString());
                TextView tvNewRes = new TextView(activity);
                tvNewRes.setText(dado.toString());
                layoutRes.addView(tvNewRes);

            } else if (resultCode == activity.RESULT_CANCELED) {
                Toast.makeText(activity, R.string.acao_cancelada, Toast.LENGTH_SHORT).show();
            }

        }
    }
        public void fecharAction () {
            activity.setResult(activity.RESULT_CANCELED);
            activity.finish();
        }

}
