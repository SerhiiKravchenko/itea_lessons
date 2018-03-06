package ua.org.skravchenko.lesson2;

/**
 * Created by SERGII on 06.03.2018.
 */

public class Book {
  private String name;
  private String author;
  private int url;
  private int rate;
  private String description;

  public Book(String name, String author, int url, int rate, String description) {
    this.name = name;
    this.author = author;
    this.url = url;
    this.rate = rate;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getUrl() {
    return url;
  }

  public void setUrl(int url) {
    this.url = url;
  }

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
