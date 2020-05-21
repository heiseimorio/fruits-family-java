public abstract class Player {

  // 空腹かどうかを返す
  public abstract boolean isHungry(int[] data);

  // 幸福度を返す（三郎だけ違う）
  public int HappyPercent(int[] data) {
    // 一郎、二郎のデータは配列になってて、２つめが幸福度。
    return data[1];
  }

  // 食べる処理
  public abstract void eat(int[] personData, String fruit, String[] fruitData);

}