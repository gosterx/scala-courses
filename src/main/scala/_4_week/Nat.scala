/*
package _4_week

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {

  def isZero = true
  def predecessor = throw new Error("zero.predecessor")
  def successor = new Succ(this)
  def + (that:Nat) = that
  def - (that:Nat) = if (that.isZero) this throw new Error("zero.-")

}
class Succ(n: Nat) extends Nat {

  def isZero = false
  def predecessor = n
  def successor = new Succ(this)
  def + (that: Nat) = new Succ(n + that)
  def - (that: Nat) = if (that.isZero) this else n - that.predecessor


}

object Main extends App {

  val zero = Zero
  val one = zero.successor
  val two = one.successor
  val res = one.+(two)


}*/
