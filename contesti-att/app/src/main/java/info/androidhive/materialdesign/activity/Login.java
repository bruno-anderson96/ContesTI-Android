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

import java.io.IOException;

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

    private String url ="";
    private String parametros ="";
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
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                String nome = ft_nome.getText().toString();
                String email = ft_email.getText().toString();
                String senha = ft_senha.getText().toString();
                String cfsenha = ft_cfSenha.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Nenhuma conexão estabelecida",Toast.LENGTH_LONG).show();
                } else {
                    url = "http://192.168.1.5:9090/login/logar.php";
                    parametros = "nome=" + nome + "&email=" + email + "&senha=" + senha + "&cfsenha=" + cfsenha;
                    new SolicitaDados().execute(url);
                }
                } else {
                    Toast.makeText(getApplicationContext(),"Nenhuma conexão estabelecida",Toast.LENGTH_LONG).show();
                }
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

    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return conexaoBD.postDados(urls[0],parametros);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado) {
            if(resultado.contains("login_ok")){
                Intent abrir = new Intent(Login.this,)
            }

        }
    }



}

