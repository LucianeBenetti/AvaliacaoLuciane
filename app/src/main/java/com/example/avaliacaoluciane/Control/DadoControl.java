package com.example.avaliacaoluciane.Control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.avaliacaoluciane.Model.Config;
import com.example.avaliacaoluciane.Model.ConfigBO;
import com.example.avaliacaoluciane.Model.Dado;
import com.example.avaliacaoluciane.Model.DadoBO;
import com.example.avaliacaoluciane.R;
import com.example.avaliacaoluciane.Util.Constantes;
import com.example.avaliacaoluciane.View.DadoActivity;
import com.example.avaliacaoluciane.View.MainActivity;

public class DadoControl {

    private Activity activity;
    private EditText editTextNome;
    private NumberPicker npIdade;
    private Config config;

    public DadoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        carregarDadosForm();
    }

    private void carregarDadosForm() {

        Dado dado = (Dado) activity.getIntent().getSerializableExtra(Constantes.Parametros.DADO);
        editTextNome.setText(dado.getNome());
    }

    public void initComponents() {
        editTextNome = activity.findViewById(R.id.editTextNome);
        npIdade = activity.findViewById(R.id.npDadosCliente);
        configurarNumberPicker();
    }

    private void configurarNumberPicker() {
        ConfigBO configBO = new ConfigBO();

        Config config = (Config) activity.getIntent().getSerializableExtra(Constantes.Parametros.CONFIG);

        npIdade.setMinValue(config.getMinimo());
        npIdade.setMaxValue(config.getMaximo());
        npIdade.setValue(configBO.media(config));
    }

    public boolean valida(DadoBO dadoBO) {
        if (!dadoBO.validaIdade()) {
            Toast.makeText(activity, R.string.idade_invalida, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!dadoBO.validaNome()) {
            editTextNome.setError("Preencha corretamente o nome");
            return false;
        }
        return true;
    }

    private Dado getDadosFormDisciplina() {
        Dado dado = new Dado();
        dado.setNome(editTextNome.getText().toString());
        dado.setIdade(npIdade.getValue());
        return dado;
    }


    public void enviarAction() {

        Dado dado = getDadosFormDisciplina();
        DadoBO dadoBO = new DadoBO(dado);

        if (valida(dadoBO)) {
            Intent it = new Intent(activity, MainActivity.class);
            it.putExtra(Constantes.Parametros.DADO, dado);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

    public void cancelarAction() {
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }
}
