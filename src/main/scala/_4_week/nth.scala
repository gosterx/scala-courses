package _4_week
import _4_week._

object nth extends App {
  def nth[T](n: Int, xs: List[T]): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException("Error")
    else if (n == 0) xs.head
    else nth(n-1, xs.tail)


  val List = new Cons(1, new Cons(1, new Cons(3, new Nil())))
  println(nth(1, List))
  println(nth(2, List))
}
