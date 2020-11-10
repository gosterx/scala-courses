package _3_week

object intSets extends App {
  val t1 =  new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4
  val t3 = t2 incl 5
  val t4 = t3 incl 1
  val t5 = t4 incl 0
  println(t1)
  println(t2)
  println(t3)
  println(t4)
  println(t5)
}

abstract class IntSet{
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet) : IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int) : IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other

  override def toString: String = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < elem) left.contains(x)
    else if (x > elem) right contains x
    else true
  }

  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left.incl(x), right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem

  override def toString: String = "{" + left + elem + right + "}"
}