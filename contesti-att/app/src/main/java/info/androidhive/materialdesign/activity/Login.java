package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import info.androidhive.materialdesign.R;

/**
 * Created by TIAGO on 07/10/2016.
 */

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText ft_nome;
    private EditText ft_email;
    private EditText ft_senha;
    private EditText ft_cfSenha;

    private Button avancar;
    private Button cad;


    public Login() {
        // Required empty public constructor
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        ft_nome = (EditText)findViewById(R.id.ft_nome);
        ft_email = (EditText)findViewById(R.id.ft_email);
        ft_senha= (EditText)findViewById(R.id.ft_senha);
        ft_cfSenha= (EditText)findViewById(R.id.ft_cfSenha);

        avancar = (Button) findViewById(R.id.avancar);
        cad = (Button) findViewById(R.id.cad);



        avancar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(Login.this, MainActivity.class);
                startActivity(it);
            }

        });


        cad.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent on = new Intent(Login.this, Cadastro.class);
                startActivity(on);
            }

        });





    }


    @Override
    public void onClick(View v) {



    }



}

