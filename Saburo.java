public class Saburo extends Player {

  private int appleMount;
  private int appleTaste;
  private int bananaMount;
  private int bananaTaste;

  Saburo(String name, int appleMount, int appleTaste, int bananaMount, int bananaTaste) {
    super(name);
    this.appleMount = appleMount;
    this.appleTaste = appleTaste;
    this.bananaMount =  bananaMount;
    this.bananaTaste =  bananaTaste;
  }

  @Override
  // 三郎が空腹かどうかを返す
  public boolean isHungry() {
    // 三郎のデータは、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    return (this.appleMount*this.appleTaste+this.bananaMount*this.bananaTaste) < (2000*0.95);
  }

  @Override
  // 三郎の幸福度を返す
  public int HappyPercent() {
    // 三郎のデータは、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    // 三郎の幸福度は味重視
    return (this.appleTaste * 2 + this.bananaTaste * 3);
  }

  @Override
  // 三郎が食べる処理
  public void eat(String fruit, String[] fruitData) {
    // りんご
    if (fruit.equals("apple")) {
      this.appleMount += Fruits.getAppleAmount(fruitData); // 量
      this.appleTaste += Fruits.getAppleTaste(fruitData);  // 味

      // バナナ
    } else {
      this.bananaMount += Fruits.getBananaAmount(fruitData);  // 量
      this.bananaTaste += Fruits.getBananaTaste(fruitData);   // 味
    }

  }

}