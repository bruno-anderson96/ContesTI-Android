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

public class Cadastro extends AppCompatActivity {


    EditText editNome, editEmail2, editSenha2;
    Button btnCancelar,btnRegistrar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);



        editNome = (EditText)findViewById(R.id.editNome);
        editEmail2 = (EditText)findViewById(R.id.editEmail2);
        editSenha2= (EditText)findViewById(R.id.editSenha2);


        btnCancelar= (Button) findViewById(R.id.btnCancelar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnCancelar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent it = new Intent(Cadastro.this, MainActivity.class);
                startActivity(it);
            }
        });

    }

}
