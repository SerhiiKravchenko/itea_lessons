package ua.org.skravchenko.lesson2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class Main2Activity extends AppCompatActivity {

  private SeekBar sbRColor;
  private SeekBar sbGColor;
  private SeekBar sbBColor;
  private EditText etRColor;
  private EditText etGColor;
  private EditText etBColor;
  private int rColor = 255;
  private int gColor = 255;
  private int bColor = 255;
  private View vColorScreen;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    vColorScreen = findViewById(R.id.vColorScreen);
    Button bPrevActivity = findViewById(R.id.bPrevActivity);

    sbRColor = findViewById(R.id.sbRColor);
    sbGColor = findViewById(R.id.sbGColor);
    sbBColor = findViewById(R.id.sbBColor);

    etRColor = findViewById(R.id.etRColor);
    etGColor = findViewById(R.id.etGColor);
    etBColor = findViewById(R.id.etBColor);

    sbRColor.setProgress(rColor);
    sbGColor.setProgress(gColor);
    sbBColor.setProgress(bColor);

    sbRColor.setOnSeekBarChangeListener(seekBarChangeListener);
    sbGColor.setOnSeekBarChangeListener(seekBarChangeListener);
    sbBColor.setOnSeekBarChangeListener(seekBarChangeListener);

    etRColor.setOnKeyListener(changeEditTexView);
    etGColor.setOnKeyListener(changeEditTexView);
    etBColor.setOnKeyListener(changeEditTexView);

    bPrevActivity.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.R_COLOR_STRING, sbRColor.getProgress());
        intent.putExtra(MainActivity.G_COLOR_STRING, sbGColor.getProgress());
        intent.putExtra(MainActivity.B_COLOR_STRING, sbBColor.getProgress());
        setResult(Activity.RESULT_OK, intent);
        finish();
      }
    });

    Intent intent = getIntent();
    Bundle bundle = intent.getExtras();
    int rColorFromIntent = bundle.getInt(MainActivity.R_COLOR_STRING, 255);
    int gColorFromIntent = bundle.getInt(MainActivity.G_COLOR_STRING, 255);
    int bColorFromIntent = bundle.getInt(MainActivity.B_COLOR_STRING, 255);

    sbRColor.setProgress(rColorFromIntent);
    sbGColor.setProgress(gColorFromIntent);
    sbBColor.setProgress(bColorFromIntent);
  }

  private View.OnKeyListener changeEditTexView = new View.OnKeyListener() {
    @Override public boolean onKey(View view, int i, KeyEvent keyEvent) {
      if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && (i == KeyEvent.KEYCODE_ENTER)) {
        updateEditTextColor();
        return true;
      }
      return false;
    }
  };

  private SeekBar.OnSeekBarChangeListener seekBarChangeListener =
      new SeekBar.OnSeekBarChangeListener() {
        @Override public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
          updateColor();
        }

        @Override public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override public void onStopTrackingTouch(SeekBar seekBar) {

        }
      };

  private void updateColor() {
    rColor = sbRColor.getProgress();
    gColor = sbGColor.getProgress();
    bColor = sbBColor.getProgress();

    etRColor.setText(String.format("%d", rColor));
    etGColor.setText(String.format("%d", gColor));
    etBColor.setText(String.format("%d", bColor));

    vColorScreen.setBackgroundColor(Color.rgb(rColor, gColor, bColor));
  }

  private void updateEditTextColor() {
    rColor = Integer.parseInt(etRColor.getText().toString());
    gColor = Integer.parseInt(etGColor.getText().toString());
    bColor = Integer.parseInt(etBColor.getText().toString());

    sbRColor.setProgress(rColor);
    sbGColor.setProgress(gColor);
    sbBColor.setProgress(bColor);

    vColorScreen.setBackgroundColor(Color.rgb(rColor, gColor, bColor));
  }
}
