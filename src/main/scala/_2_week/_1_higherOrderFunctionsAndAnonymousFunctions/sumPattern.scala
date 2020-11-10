package _2_week._1_higherOrderFunctionsAndAnonymousFunctions

object sumPattern extends App{

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)


  def sumInts(a: Int, b: Int) = sum(id, a, b)
  def sumCubes(a: Int, b: Int) = sum(cube, a, b)
  def sumFactorials(a: Int,b: Int) = sum(fact, a, b)

  def id(x: Int) = x
  def cube(x: Int) = x * x * x
  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x-1)

  //tail recoursion
  def sumTailRecoursion(f: Int => Int, a: Int, b: Int): Int ={
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

  //use of anonymous functions
  def sumIntsAnonymous(a: Int,b: Int) = sum(x => x, a, b)
  def sumCubesAnonymous(a: Int, b: Int) = sum(x => x * x * x, a, b)

  print(sumInts(1, 5))
}
