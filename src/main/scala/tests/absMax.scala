package tests

object absMax {

  def main(args: Array[String]): Unit = {
    val nums = List(-1, -22, -3, -4, -5, -8)
    println(nums(2))
    //println(absMax(nums))
    //println(sumBetweenTwoPositive(nums))
  }

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop (n + 1))


  def absMax(array: List[Int]): Int = {

    def abs(n: Int): Int = {
      if (n >= 0) n
      else -n
    }

    def search(arr: List[Int], acc: Int): Int = {
      if (arr.isEmpty) acc
      else if (abs(acc) < abs(arr.head)) search(arr.tail, arr.head)
      else search(arr.tail, acc)
    }

    search(array, array.head)

  }

  def sumBetweenTwoPositive(array: List[Int]): Int = {

    def cutArray(arr: List[Int]): List[Int] = {
      if (arr.isEmpty) throw new Error("No positive elements!")
      else if (arr.head > 0) arr.tail
      else cutArray(arr.tail)
    }

    def sum(arr: List[Int], s: Int): Int = {
      if (arr.isEmpty) throw new Error("No second positive element!")
      else if(arr.head <= 0) sum(arr.tail, s + arr.head)
      else s

    }

    sum(cutArray(array), 0)

  }

}
