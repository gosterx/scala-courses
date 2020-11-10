package _4_week.tasks

object sorting {

  def main(args: Array[String]): Unit = {
    val numbers = List(2, 12, 8, 0, -1, 3, -7)
    val fruits = List("apple", "banana", "pineapple", "orange")
    val a = 5
    //println(isort(numbers))
    println(msort(numbers)((x: Int, y: Int) => x < y))
    println(msort(fruits)((x: String, y: String) => x.compareTo(y) < 0))
  }


  def isort(xs: List[Int]): List[Int] = {

    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
      case List() => List(x)
      case y :: ys => if (x <= y) x :: xs
      else y :: insert(x, ys)
    }

    xs match {
      case List() => List()
      case y :: ys => insert(y, isort(ys))
    }
  }


  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = { //also possible to use Ordering instead of compare fun
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = {
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }

  def bsort(xs: List[Int]): List[Int] = {
    
  }


}
