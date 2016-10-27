package info.androidhive.materialdesign.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.androidhive.materialdesign.R;

/**
 * Created by alenc on 12/10/2016.
 */

public class Cadastro extends AppCompatActivity {


    EditText editNome, editEmail2, editSenha2;
    Button btnCancelar,btnRegistrar;

    String url="";
    String parametros="";

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
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                    String email = editEmail2.getText().toString();
                    String senha = editSenha2.getText().toString();

                    if (email.isEmpty() || senha.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Nenhum campo pode estar vazio",Toast.LENGTH_LONG).show();

                    } else {
                        url = "http://192.168.1.5:80/login/logar.php";
                        parametros = "?email=" + email + "&senha=" + senha;

                        new SolicitaDados().execute(url);
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Nenhuma conexão foi detectada",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return conexaoBD.postDados(urls[0],parametros);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado) {
            editEmail2.setText(resultado);

        }
    }

}
