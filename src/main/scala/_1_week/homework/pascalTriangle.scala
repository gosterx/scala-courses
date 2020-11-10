package _1_week.homework

object pascalTriangle extends App {

  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r || r == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  println(pascal(2, 4))
}
