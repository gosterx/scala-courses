package _1_week.homework

object countingChange extends App {
  def countChange(money: Int, coins: List[Int]) : Int = {
    def countChangeCombinations(money: Int, coins: List[Int]): Int = {
      if (money == 0)
        1
      else if (money < 0 || coins.isEmpty)
        0
      else
        countChangeCombinations(money - coins.head, coins) + countChangeCombinations(money, coins.tail)
    }

    countChangeCombinations(money, coins)
  }

  val numbers = List(1,2)
  print(countChange(4, numbers))
}
