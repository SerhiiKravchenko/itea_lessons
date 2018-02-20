package ua.org.skravchenko.lesson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final EditText etMail = findViewById(R.id.etEmail);
    final EditText etPasswordNumeric = findViewById(R.id.etPasswordNumeric);
    Button bLogin = findViewById(R.id.bLogin);
    final Button bGooglePlusLogin = findViewById(R.id.bGooglePlusLogin);
    final Toast toast = Toast.makeText(MainActivity.this, "",Toast.LENGTH_SHORT);
    final Button bFacebookLogin = findViewById(R.id.bFacebookLogin);
    TextView tvForgotPassword = findViewById(R.id.tvForgotPassword);
    bLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if (TextUtils.isEmpty(etMail.getText()) || !android.util.Patterns.EMAIL_ADDRESS.matcher(
            etMail.getText()).matches()) {
          etMail.setError("Enter correct E-mail please!");
        } else if (TextUtils.isEmpty(etPasswordNumeric.getText())) {
          etPasswordNumeric.setError("Enter password please!");
        } else if (etPasswordNumeric.getText().length() < 6) {
          etPasswordNumeric.setError("Your password must be more 6 less 20 digits");
        }
      }
    });
    bGooglePlusLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        toast.setText(bGooglePlusLogin.getText());
        toast.show();
      }
    });
    bFacebookLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        toast.setText(bFacebookLogin.getText());
        toast.show();
      }
    });
    tvForgotPassword.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        etMail.setText("");
        etPasswordNumeric.setText("");
      }
    });
  }
}
