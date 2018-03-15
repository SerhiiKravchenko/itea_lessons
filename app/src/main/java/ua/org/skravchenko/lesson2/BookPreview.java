package ua.org.skravchenko.lesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class BookPreview extends AppCompatActivity {

  private ImageView ivSingleUrl;
  private TextView tvSingleItemName;
  private TextView tvSingleItemAuthor;
  private TextView tvSingleDescription;
  private RatingBar rbSingleRating;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_book_preview);

    Intent intent = getIntent();
    Bundle bundle = intent.getExtras();
    ivSingleUrl = (ImageView) findViewById(R.id.ivSingleUrl);
    tvSingleItemName = (TextView) findViewById(R.id.tvSingleItemName);
    tvSingleItemAuthor = (TextView) findViewById(R.id.tvSingleItemAuthor);
    rbSingleRating = (RatingBar) findViewById(R.id.rbSingleRating);
    tvSingleDescription = (TextView) findViewById(R.id.tvSingleDescription);
    ivSingleUrl.setImageResource(bundle.getInt("url", 0));
    tvSingleItemName.setText(bundle.getString("name", "NoName"));
    tvSingleItemAuthor.setText(bundle.getString("author", "NoName"));
    rbSingleRating.setRating(bundle.getInt("rate", 0));
    tvSingleDescription.setText(bundle.getString("description", "NoName"));
  }
}
