package ua.org.skravchenko.lesson2;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    LinearLayout llRoot = new LinearLayout(this);
    llRoot.setOrientation(LinearLayout.VERTICAL);
    llRoot.setWeightSum(12);
    llRoot.setGravity(80);
    llRoot.setPadding(30, 0,30,0);
    llRoot.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      llRoot.setBackground(ContextCompat.getDrawable(this,R.drawable.blue_christmas_background));
    }


    // TextView Hello Again
    TextView tvGreeting = new TextView(this);
    tvGreeting.setId(R.id.tvGreating);
    tvGreeting.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 0,2));
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      tvGreeting.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
    tvGreeting.setText("Hello again");
    tvGreeting.setTextColor(Color.WHITE);
    tvGreeting.setTextSize(30);
    llRoot.addView(tvGreeting);

    //LinearLayout SignIn
    LinearLayout llSignIn = new LinearLayout(this);
    llSignIn.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 0,3));
    llSignIn.setOrientation(LinearLayout.VERTICAL);
    llRoot.addView(llSignIn);

    TextView tvSignIn = new TextView(this);
    tvSignIn.setId(R.id.tvSignInUsing);
    tvSignIn.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    tvSignIn.setText("Sign in using");
    tvSignIn.setTextColor(Color.WHITE);
    tvSignIn.setTextSize(15);
    llSignIn.addView(tvSignIn);

    LinearLayout llSocialButton = new LinearLayout(this);
    LinearLayout.LayoutParams llLpSocialButton = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
    llSocialButton.setOrientation(LinearLayout.HORIZONTAL);
    llSocialButton.setWeightSum(2);
    llLpSocialButton.setMargins(0,10,0,0);
    llSocialButton.setLayoutParams(llLpSocialButton);
    llSocialButton.setBaselineAligned(false);
    llSignIn.addView(llSocialButton);

    Button bGooglePlus = new Button(this);
    bGooglePlus.setId(R.id.bGooglePlusLogin);
    bGooglePlus.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT,1));
    bGooglePlus.setBackgroundColor(Color.parseColor("#dd4b39"));
    bGooglePlus.setCompoundDrawablesWithIntrinsicBounds(R.drawable.google_plus_ico,0,0,0);
    bGooglePlus.setPadding(5,5,5,5);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      bGooglePlus.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
    bGooglePlus.setText("Google");
    bGooglePlus.setAllCaps(false);
    bGooglePlus.setTextColor(Color.WHITE);
    bGooglePlus.setTextSize(15);
    llSocialButton.addView(bGooglePlus);

    Button bFacebook = new Button(this);
    bFacebook.setId(R.id.bFacebookLogin);
    LinearLayout.LayoutParams llLpFacebookButton = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT,1);
    llLpFacebookButton.setMargins(20,0,0,0);
    bFacebook.setLayoutParams(llLpFacebookButton);
    bFacebook.setBackgroundColor(Color.parseColor("#3b5998"));
    bFacebook.setCompoundDrawablesWithIntrinsicBounds(R.drawable.facebook_ico,0,0,0);
    bFacebook.setPadding(5,5,5,5);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      bFacebook.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
    bFacebook.setText("Facebook");
    bFacebook.setAllCaps(false);
    bFacebook.setTextColor(Color.WHITE);
    bFacebook.setTextSize(15);
    llSocialButton.addView(bFacebook);

    //LinearLayout OR Block
    LinearLayout llOrBlock = new LinearLayout(this);
    LinearLayout.LayoutParams llLpOrBlock = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,0,1);
    llLpOrBlock.setMargins(0,20,0,0);
    llOrBlock.setLayoutParams(llLpOrBlock);
    llOrBlock.setOrientation(LinearLayout.HORIZONTAL);
    llOrBlock.setWeightSum(9);

    View vOrBlock1 = new View(this);
    LayoutParams lpOrBlockView1 = new LayoutParams(0, 5,4);
    lpOrBlockView1.gravity = Gravity.CENTER;
    vOrBlock1.setLayoutParams(lpOrBlockView1);
    vOrBlock1.setBackgroundColor(Color.parseColor("#808080"));
    llOrBlock.addView(vOrBlock1);

    TextView tvOrBlock = new TextView(this);
    LayoutParams tvlPOrBlock = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
    tvlPOrBlock.gravity = Gravity.CENTER;
    tvOrBlock.setLayoutParams(tvlPOrBlock);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      tvOrBlock.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
    tvOrBlock.setText("OR");
    tvOrBlock.setAllCaps(true);
    tvOrBlock.setTextColor(Color.WHITE);
    llOrBlock.addView(tvOrBlock);

    View vOrBlock2 = new View(this);
    LayoutParams lpOrBlockView2 = new LayoutParams(0, 5,4);
    lpOrBlockView2.gravity = Gravity.CENTER;
    vOrBlock2.setLayoutParams(lpOrBlockView2);
    vOrBlock2.setBackgroundColor(Color.parseColor("#808080"));
    llOrBlock.addView(vOrBlock2);
    llRoot.addView(llOrBlock);

    /////////////////////////////////////////

    EditText etEmailLine = new EditText(this);
    etEmailLine.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    etEmailLine.setId(R.id.etEmail);
    etEmailLine.setHint("E-mail");
    etEmailLine.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
    llRoot.addView(etEmailLine);

    EditText etPasswordLine = new EditText(this);
    int maxLength = 20;
    InputFilter[] fArray = new InputFilter[1];
    fArray[0] = new InputFilter.LengthFilter(maxLength);
    etPasswordLine.setFilters(fArray);
    etPasswordLine.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    etPasswordLine.setId(R.id.etPasswordNumeric);
    etPasswordLine.setHint("Password");
    etPasswordLine.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
    llRoot.addView(etPasswordLine);

    /////////////////////////////////////////


    Button bLoginButon = new Button(this);
    bLoginButon.setId(R.id.bLogin);
    LayoutParams bLpLoginButton = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    bLpLoginButton.setMargins(0,30,0,0);
    bLoginButon.setLayoutParams(bLpLoginButton);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      bLoginButon.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
    bLoginButon.setText("Log in");
    bLoginButon.setAllCaps(false);
    bLoginButon.setBackgroundColor(Color.parseColor("#ff669900"));
    bLoginButon.setTextColor(Color.WHITE);
    llRoot.addView(bLoginButon);

    /////////////////////////////////////////

    TextView tvForgotYP = new TextView(this);
    tvForgotYP.setId(R.id.tvForgotPassword);
    tvForgotYP.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      tvForgotYP.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
    tvForgotYP.setText("Forgot your password?");
    tvForgotYP.setPadding(0,20,0,0);
    llRoot.addView(tvForgotYP);

    //LinearLayout Bottom Block

    LinearLayout llBottomBlock = new LinearLayout(this);
    llBottomBlock.setOrientation(LinearLayout.HORIZONTAL);
    llBottomBlock.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT,4));
    llBottomBlock.setWeightSum(6);
    llRoot.addView(llBottomBlock);

    Button bSignUpButton = new Button(this);
    bSignUpButton.setId(R.id.bSignUp);
    LayoutParams lpBSignUpButton = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
    lpBSignUpButton.gravity= Gravity.BOTTOM;
    bSignUpButton.setLayoutParams(lpBSignUpButton);
    bSignUpButton.setText("Sign up");
    bSignUpButton.setAllCaps(false);
    bSignUpButton.setBackgroundColor(Color.TRANSPARENT);
    bSignUpButton.setTextColor(Color.BLACK);
    llBottomBlock.addView(bSignUpButton);

    View vBottomBlock = new View(this);
    vBottomBlock.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 0,4));
    llBottomBlock.addView(vBottomBlock);

    Button bTermsButton = new Button(this);
    bTermsButton.setId(R.id.bTerms);
    LayoutParams lpBTermsButton = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
    lpBTermsButton.gravity= Gravity.BOTTOM;
    bTermsButton.setLayoutParams(lpBTermsButton);
    bTermsButton.setText("Terms");
    bTermsButton.setAllCaps(false);
    bTermsButton.setBackgroundColor(Color.TRANSPARENT);
    bTermsButton.setTextColor(Color.BLACK);
    llBottomBlock.addView(bTermsButton);

    setContentView(llRoot);

    final EditText etMail = findViewById(R.id.etEmail);
    final EditText etPasswordNumeric = findViewById(R.id.etPasswordNumeric);
    Button bLogin = findViewById(R.id.bLogin);
    final Button bGooglePlusLogin = findViewById(R.id.bGooglePlusLogin);
    final Toast toast = Toast.makeText(MainActivity.this, "",Toast.LENGTH_SHORT);
    final Button bFacebookLogin = findViewById(R.id.bFacebookLogin);
    TextView tvForgotPassword = findViewById(R.id.tvForgotPassword);
    bLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if (TextUtils.isEmpty(etMail.getText()) || !Patterns.EMAIL_ADDRESS.matcher(
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
