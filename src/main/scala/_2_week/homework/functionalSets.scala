package _2_week.homework

object functionalSets extends App{

  type FunSet = Int => Boolean

  def contains(s: FunSet, elem: Int): Boolean = s(elem)

  // Создание множества только из одного элемента elem
  def singletonSet(elem: Int): FunSet =
    (x: Int) => x == elem

  println(contains(singletonSet(4), -4))

  // Такой вариант тоже подходит
  //def union1(s: FunSet, t: FunSet): FunSet = (x: Int) => s(x) || t(x)
  def union(s: FunSet, t: FunSet): FunSet = (x: Int) => contains(s, x) || contains(t, x)
  def intersect(s: FunSet, t: FunSet): FunSet = (x: Int) => contains(s, x) && contains(t, x)
  def diff(s: FunSet, t: FunSet): FunSet = (x: Int) => contains(s, x) && (!contains(t, x))

  println(contains(union(singletonSet(4), singletonSet(5)), 5))

  def filter(s: FunSet, p: Int => Boolean): FunSet = (x: Int) => contains(s, x) && p(x)

  println(contains(filter(intersect(singletonSet(4),singletonSet(4)), (x: Int) => x > 0), 4))

  val count = 1000

  def forall(s: FunSet, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > count) true
      else if (!contains(filter(s, p), a)) false
      else iter(a + 1)
    }
    iter(-count)
  }

  def exists(s: FunSet, p: Int => Boolean): Boolean = !forall(s, x => !p(x))


  def map(s: FunSet, f: Int => Int): FunSet ={
    def iter(a: Int, accumulateSet: FunSet): FunSet = {
      if (a > count) accumulateSet
      else if (contains(s, a)) iter(a + 1, union(accumulateSet, singletonSet(f(a))))
      else iter(a + 1, accumulateSet)
    }
    iter(-count, x => false)
  }

}
