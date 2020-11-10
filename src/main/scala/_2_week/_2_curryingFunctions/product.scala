package _2_week._2_curryingFunctions

object product extends App {
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }

  println(product(x => x * x)(1, 3))

  def factorial(n: Int): Int = product(x => x)(1, n)

  println(factorial(3))

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }

  println(mapReduce(x => x * x, (x, y) => x * y, 1)(1, 3))
}
