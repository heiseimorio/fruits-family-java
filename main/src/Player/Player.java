package main.src.Player;
import main.src.Fruits.*;

public abstract class Player {

  // 名前を返す
  public abstract String getName();

  // 空腹かどうかを返す
  public abstract boolean isHungry();

  // 幸福度を返す
  public abstract int HappyPercent();

  // 食べる処理
  public abstract void eat(String fruit, Fruits fruitData);

}