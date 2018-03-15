package ua.org.skravchenko.lesson2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.List;

/**
 * Created by SERGII on 06.03.2018.
 */

public class BookListAdapter extends ArrayAdapter<Book> {
  private Context context;
  private List<Book> books;

  public BookListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
    super(context, resource, objects);
    this.context = context;
    this.books = objects;
  }

  public List<Book> getBooks() {
    return books;
  }

  @NonNull @Override
  public View getView(final int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
    View rootView = null;
    if (convertView == null) {
      LayoutInflater layoutInflater =
          (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      rootView = layoutInflater.inflate(R.layout.custom_item_list, parent, false);
      ImageView ivImage = (ImageView) rootView.findViewById(R.id.ivImage);
      TextView tvBookName = (TextView) rootView.findViewById(R.id.tvBookName);
      TextView tvBookAuthor = (TextView) rootView.findViewById(R.id.tvBookAuthor);
      RatingBar rbBook = (RatingBar) rootView.findViewById(R.id.rbBook);
      ivImage.setImageResource(books.get(position).getUrl());
      tvBookName.setText(books.get(position).getName());
      tvBookAuthor.setText(books.get(position).getAuthor());
      rbBook.setRating(books.get(position).getRate());
      //ListView lv = (ListView)rootView.findViewById(R.id.lvBooks);
      BookList.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
          Log.wtf("click","Clicked item");
          Intent intent = new Intent(context,BookPreview.class);
          intent.putExtra("name",BookList.lAdapter.getBooks().get(i).getName());
          intent.putExtra("author",BookList.lAdapter.getBooks().get(i).getAuthor());
          intent.putExtra("url",BookList.lAdapter.getBooks().get(i).getUrl());
          intent.putExtra("rate",BookList.lAdapter.getBooks().get(i).getRate());
          intent.putExtra("description",BookList.lAdapter.getBooks().get(i).getDescription());
          context.startActivity(intent);
        }
      });
    } else {
      rootView = convertView;
    }
    return rootView;
  }

}
