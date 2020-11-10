package _2_week._2_curryingFunctions

object sumPatternWithCurrying extends App {

  def sum(f: Int => Int)(a: Int, b: Int) : Int = {
      if (a > b) 0
      else f(a) + sum(f)(a + 1, b)
  }

  def sumInts(x: Int) = x
  def sumCubes(x: Int) = x * x * x

  print(sum(sumInts)(1, 4))
}
