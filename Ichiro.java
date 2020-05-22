public class Ichiro extends Player {

  private String name;
  private int manpuku;
  private int happyPercent;

  Ichiro(int manpuku, int happyPercent) {
    this.manpuku = manpuku;
    this.happyPercent = happyPercent;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  // 一郎が空腹かどうかを返す
  public boolean isHungry() {
  // 一郎のデータは、１つ目が満腹度。満腹度１００％にならないと空腹感はなくならない子。
  return this.manpuku < (2000*1.0);
  }

  // 一郎の幸福度を返す
  public int HappyPercent() {
    // 一郎のデータは、２つめが幸福度。
    return this.happyPercent;
  }

  @Override
  // 一郎が食べる処理
  public void eat(String fruit, String[] fruitData) {
    // 一郎はりんごを食べない
    if (fruit.equals("apple")) {
      return;
    }
    String color = Fruits.getBananaColor(fruitData);
    int amount = Fruits.getBananaAmount(fruitData);
    int taste = Fruits.getBananaTaste(fruitData);

    // 白色のバナナは２倍の効果
    int kouka = 1;
    if (color.equals("white")) {
      kouka = 2;
    }

    // 量 * 味　を満腹度に加算して、満腹度データを更新
    this.manpuku += amount * taste * kouka;

    // 幸福度データを更新する。一郎は量によって幸福度が上がる
    this.happyPercent = happyPercent + amount;

  }
}