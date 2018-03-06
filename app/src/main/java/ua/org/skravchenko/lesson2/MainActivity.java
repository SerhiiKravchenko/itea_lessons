package ua.org.skravchenko.lesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  EditText etLoginName;
  EditText etPassword;
  Button bLogin;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bLogin = (Button)findViewById(R.id.bLogin);
    etPassword = (EditText)findViewById(R.id.etPassword);

    bLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if(TextUtils.isEmpty(etPassword.getText())){
          etPassword.setError("Enter password please!!!");
        }else if (etPassword.getText().length()<6){
          etPassword.setError("Enter please more than 6 digits!!!");
        }else{
          Intent intent = new Intent(getApplicationContext(),BookList.class);
          startActivity(intent);
        }
      }
    });

  }


}