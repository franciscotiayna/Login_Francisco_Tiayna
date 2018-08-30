package com.example.tarrito.login_francisco_tiayna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText editTextUsuario;
    private EditText editTextPassword;
    private String usuario;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                usuario = editTextUsuario.getText().toString();
                password = editTextPassword.getText().toString();
                Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
                intent.putExtra("editTextUsuario",usuario);
                intent.putExtra("editTextPassword",password);
            }
        });


    }
}
