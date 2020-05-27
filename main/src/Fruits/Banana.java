package main.src.fruits;
import main.src.fruitssecret.Check;

public class Banana implements Fruits {

  private String color;
  private int amount;
  private int taste;
  private int amount2;

  public Banana(String color, int amount, int taste, int amount2) {
    this.color = color;
    this.amount = amount;
    this.taste = taste;
    this.amount2 = amount2;
  }

  // バナナの色を返す関数
  public String getColor() {
    Check.check();
    return this.color;
  }

  // バナナの量を返す関数
  public int getAmount() {
    return this.amount * this.amount2;
  }

  // バナナのうまみ具合を返す関数
  public int getTaste() {
    return this.taste;
  }

}