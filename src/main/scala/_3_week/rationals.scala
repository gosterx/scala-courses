package _3_week

object rationals extends App {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  //println(x.numer)
  //println(x.denom)

  // def addRationals(r: Rational, s: Rational): Rational = {
  //   new Rational(r.numer * s.denom + s.numer * r.denom, r.denom * s.denom)
  // }

  // def makeString(r: Rational) =
  //   r.numer + "/" + r.denom

  //println(makeString(addRationals(x, new Rational(2, 3))))


  println(x + y)
  println(x - y - z)
  println(y + y)
  println(x < y)
  println(x max y)
  println(new Rational(2))

  //val strange = new Rational(1, 0)
  //println(strange.add(strange))

}

class Rational(x: Int, y: Int){
  require(y != 0, "denominator must be nonzero")
  //require(y > 0, "denominator must be positive")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer: Int = x
  def denom: Int = y

  def <(that: Rational): Boolean = this.numer * that.denom < this.denom * that.numer

  def max(that: Rational): Rational = if (this < that) that else this

  def +(that: Rational): Rational ={
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom
    )
  }

  def -(that: Rational): Rational = this + -that

  def unary_- : Rational = {
    new Rational(-this.numer, this.denom)
  }

  override def toString: String = {
    val g: Int = gcd(numer, denom)
    numer / g + "/" + denom / g
  }
}



/*
package _3_week

object rationals extends App {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  //println(x.numer)
  //println(x.denom)

  // def addRationals(r: Rational, s: Rational): Rational = {
  //   new Rational(r.numer * s.denom + s.numer * r.denom, r.denom * s.denom)
  // }

  // def makeString(r: Rational) =
  //   r.numer + "/" + r.denom

  //println(makeString(addRationals(x, new Rational(2, 3))))


  println(x.add(y))
  println(x.sub(y).sub(z))
  println(y add y)
  println(x.less(y))
  println(x.max(y))
  println(new Rational(2))

  //val strange = new Rational(1, 0)
  //println(strange.add(strange))

}

class Rational(x: Int, y: Int){
  require(y != 0, "denominator must be nonzero")
  //require(y > 0, "denominator must be positive")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer: Int = x
  def denom: Int = y

  def less(that: Rational) = this.numer * that.denom < this.denom * that.numer

  def max(that: Rational) = if (this.less(that)) that else this

  def add(that: Rational): Rational ={
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom
    )
  }

  def sub(that: Rational) = add(that.neg)

  def neg : Rational = {
    new Rational(-this.numer, this.denom)
  }

  override def toString: String = {
    val g: Int = gcd(numer, denom)
    numer / g + "/" + denom / g
  }
}
 */
