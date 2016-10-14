package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import info.androidhive.materialdesign.R;

/**
 * Created by alenc on 12/10/2016.
 */

public class Cadastro extends AppCompatActivity implements View.OnClickListener{


    private EditText ft_nome, ft_email, ft_senha2 , ft_cfSenha2;
    private Button pross;




    public Cadastro() {
        // Required empty public constructor
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);



        ft_nome = (EditText)findViewById(R.id.ft_nome);
        ft_email = (EditText)findViewById(R.id.ft_email);
        ft_senha2= (EditText)findViewById(R.id.ft_senha2);
        ft_cfSenha2= (EditText)findViewById(R.id.ft_cfSenha2);


        pross = (Button) findViewById(R.id.pross);

        pross.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(Cadastro.this, MainActivity.class);
                startActivity(it);
            }

        });




    }


    @Override
    public void onClick(View v) {


    }

}
