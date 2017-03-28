package com.erik5991.bioscoopapp;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

    private String userName, password;
    private TextView nameText, passwordText;
    private Button loginKnop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        userName = "Rick";
        password = "geheim";

        loginKnop = (Button) findViewById(R.id.loginKnop);
        nameText = (TextView) findViewById(R.id.loginNameText);
        passwordText = (TextView) findViewById(R.id.passTextField);

    }

        public void loginFunctie(View view){
            Log.i("TEST", "KNOPTEST");
        String nameCheck = nameText.getText().toString();
        String passCheck = passwordText.getText().toString();

            try {
                if (nameCheck.equals(userName) && passCheck.equals(password)) {
                    Toast.makeText(Login.this, "Login Correct!", Toast.LENGTH_SHORT).show();

                }
                else if (!nameCheck.equals(userName) || !passCheck.equals(password))
                {
                    Toast.makeText(Login.this, "Onjuiste inloggegevens!", Toast.LENGTH_SHORT).show();
                }

            }
            catch (final Exception e){
                throw new RuntimeException("Fout ");
            }
    }

}
