package _1_week._1_functions

object factorial extends App{

    def factorial(x: Int) : Int =
      if (x == 0) 1
      else x * factorial(x - 1)

    def factorial_tail_rec(x : Int) : Int ={
      @scala.annotation.tailrec
      def loop(n : Int, acc : Int) : Int =
        if (n == 0) acc
        else loop(n - 1, acc * n)
      loop(x, 1)
    }



    println(factorial(4))
    println(factorial_tail_rec(4))
}
