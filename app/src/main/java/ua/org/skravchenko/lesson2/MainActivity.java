package ua.org.skravchenko.lesson2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
  public static final int SECOND_ACTIVITY_REQUEST_CODE = 1;
  private int rColor = 255;
  private int gColor = 255;
  private int bColor = 255;
  private EditText etRColor;
  private EditText etGColor;
  private EditText etBColor;
  private View vColorScreen;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button bNextActivity = findViewById(R.id.bNextActivity);

    bNextActivity.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);

      }
    });

    vColorScreen = findViewById(R.id.vColorScreen);
    etRColor = findViewById(R.id.etRColor);
    etGColor = findViewById(R.id.etGColor);
    etBColor = findViewById(R.id.etBColor);

    vColorScreen.setBackgroundColor(Color.rgb(rColor, gColor, bColor));

    etRColor.setOnKeyListener(new View.OnKeyListener() {
      @Override
      public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
            (i == KeyEvent.KEYCODE_ENTER)) {
          rColor = Integer.parseInt(etRColor.getText().toString());
          if (rColor > 255) {
            etRColor.setText("255");
            rColor = 255;
            vColorScreen.setBackgroundColor(Color.rgb(rColor, gColor, bColor));
          } else vColorScreen.setBackgroundColor(Color.rgb(rColor, gColor, bColor));

          return true;
        }

        return false;
      }
    });

    etGColor.setOnKeyListener(new View.OnKeyListener() {
      @Override
      public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
            (i == KeyEvent.KEYCODE_ENTER)) {
          gColor = Integer.parseInt(etGColor.getText().toString());
          if (gColor > 255) {
            etGColor.setText("255");
            gColor = 255;
            vColorScreen.setBackgroundColor(Color.rgb(rColor, gColor, bColor));
          } else vColorScreen.setBackgroundColor(Color.rgb(rColor, gColor, bColor));

          return true;
        }

        return false;
      }
    });
    etBColor.setOnKeyListener(new View.OnKeyListener() {
      @Override
      public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
            (i == KeyEvent.KEYCODE_ENTER)) {
          bColor = Integer.parseInt(etBColor.getText().toString());
          if (bColor > 255) {
            etBColor.setText("255");
            bColor = 255;
            vColorScreen.setBackgroundColor(Color.rgb(rColor, gColor, bColor));
          } else vColorScreen.setBackgroundColor(Color.rgb(rColor, gColor, bColor));

          return true;
        }

        return false;
      }
    });


  }
}