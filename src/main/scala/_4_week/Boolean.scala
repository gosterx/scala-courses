/*
package _4_week

abstract class Boolean {

  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean): Boolean = ifThenElse(x, false)
  def || (x: => Boolean): Boolean = ifThenElse(true, x)
  def unary_!(x: => Boolean): Boolean = ifThenElse(false, true)

  def <(x: => Boolean): Boolean = ifThenElse(false, x)

}

object True extends Boolean{

  def ifThenElse[T](t: => T, e: => T) = t

}

object False extends Boolean{

  def ifThenElse[T](t: => T, e: => T) = e

}

class Main extends App {

  val firstTrue = True
  val secondTrue = True
  val firstFalse = False

  println(firstFalse && secondTrue)



}
*/
