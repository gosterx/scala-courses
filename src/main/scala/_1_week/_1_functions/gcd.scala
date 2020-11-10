package _1_week._1_functions

object gcd extends App {

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  println(gcd(21, 14))
}
