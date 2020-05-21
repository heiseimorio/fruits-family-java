public class Saburo extends Player {

  private int apple_amount;
  private int apple_taste;
  private int banana_amount;
  private int banana_taste;


  Saburo(int apple_amount, int apple_taste, int banana_amount, int banana_taste) {
    this.apple_amount = apple_amount;
    this.apple_taste = apple_taste;
    this.banana_amount =  banana_amount;
    this.banana_taste =  banana_taste;
  }

  @Override
  // 三郎が空腹かどうかを返す
  public boolean isHungry() {
    // 三郎のデータは、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    return (this.apple_amount*this.apple_taste+this.banana_amount*this.banana_taste) < (2000*0.95);
  }

  @Override
  // 三郎の幸福度を返す
  public int HappyPercent() {
    // 三郎のデータは、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    // 三郎の幸福度は味重視
    return (this.apple_taste * 2 + this.banana_taste * 3);
  }

  @Override
  // 三郎が食べる処理
  public void eat(String fruit, String[] fruitData) {
    // りんご
    if (fruit.equals("apple")) {
      this.apple_amount += Fruits.getAppleAmount(fruitData); // 量
      this.apple_taste += Fruits.getAppleTaste(fruitData);  // 味

      // バナナ
    } else {
      this.banana_amount += Fruits.getBananaAmount(fruitData);  // 量
      this.banana_taste += Fruits.getBananaTaste(fruitData);   // 味
    }

  }

}