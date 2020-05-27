package main.src.player;
import main.src.fruits.*;


public class Jiro extends Player {

  private String name = "jiro";
  private int manpuku;
  private int happyPercent;

  public Jiro(int manpuku, int happyPercent) {

    this.manpuku = manpuku;
    this.happyPercent = happyPercent;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  // 次郎が空腹かどうかを返す
  public boolean isHungry() {
    // 次郎のデータは、１つ目が満腹度。満腹度８０％を超えると空腹感はなくなる子。
    return this.manpuku< (2000*0.8);
  }

  // 次郎の幸福度を返す
  public int HappyPercent() {
    // 次郎のデータは、２つめが幸福度。
    return this.happyPercent;
  }

  @Override
  // 次郎が食べる処理
  public void eat(String fruit, Fruits fruitData) {
    // ハイヒール・りんご
    if (fruit.equals("apple")) {
      String color = fruitData.getColor();
      int amount = fruitData.getAmount();
      int taste = fruitData.getTaste();

      // Appleクラスにしかないブランド情報を取得
      Apple apple = (Apple)fruitData;
      String brand = apple.getBrand();

      // 効果
      int kouka = 1;
      if (color.equals("red")) {
        kouka = 2;
      }
      if (brand.equals("ourin")) {
        kouka *= 2;
      }

      // 量 * 味 を満腹度に加算する
      this.manpuku += amount * taste;

      // 幸福度データを更新する。次郎は味・色・ブランドによって幸福度が上がる
      this.happyPercent += taste * kouka;

    // バナナ
    } else {
      String color = fruitData.getColor();
      int amount = fruitData.getAmount();
      int taste = fruitData.getTaste();
      // 白色のバナナは２倍の効果
      int kouka = 1;
      if (color.equals("white")) {
        kouka = 2;
      }

      // 量 * 味 を満腹度に加算する
      this.manpuku += amount * taste * kouka;

      // 幸福度データを更新する。次郎はバナナの時は量によって幸福度が上がる
      this.happyPercent += amount;
    }

  }
}