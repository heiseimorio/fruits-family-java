public class Ichiro extends Player {

  private String name = "ichiro";
  private int manpuku;
  private int happyPercent;
  private boolean eatFlg = false;

  Ichiro(int manpuku, int happyPercent) {
    this.manpuku = manpuku;
    this.happyPercent = happyPercent;
  }

  @Override
  public String getName() {
    return this.name;
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
  public void eat(String fruit, Fruits fruitData) {
    // 一郎はりんごを食べない
    if (fruit.equals("apple")) {
      this.eatFlg = false;
      return;
    }
    String color = fruitData.getColor();
    int amount = fruitData.getAmount();
    int taste = fruitData.getTaste();

    // 白色のバナナは２倍の効果
    int kouka = 1;
    if (color.equals("white")) {
      kouka = 2;
    }

    // 量 * 味　を満腹度に加算して、満腹度データを更新
    this.manpuku += amount * taste * kouka;

    // 幸福度データを更新する。一郎は量によって幸福度が上がる
    this.happyPercent = happyPercent + amount;

    // バナナを食べた時
    this.eatFlg = true;
  }

  // 食べたかどうかを返す
  public boolean isEating() {
    return this.eatFlg;
  }
}