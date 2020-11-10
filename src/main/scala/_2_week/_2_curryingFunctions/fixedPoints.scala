package _2_week._2_curryingFunctions

object fixedPoints extends App {
  val tolerance = 0.001

  def abc(x: Double): Double = if (x < 0) -x else x

  def isCloseEnough(x: Double, y: Double): Boolean =
    abc((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double ={
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def sqrt(x: Double) = fixedPoint(y =>(y +  x / y) / 2)(1.0)
  println(fixedPoint(x => 1 + x / 2)(1))
  println(sqrt(3))

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2

  def sqrtWithAverageDamp(x: Double) =
    fixedPoint(averageDamp(y => x / y))(1)

  println(sqrtWithAverageDamp(2))

}
