package _1_week.homework

object parenthesesBalancing extends App{

  def balance(l: List[Char]): Boolean = {

    @scala.annotation.tailrec
    def countQuotes(list: List[Char], count: Int): Int = {
      if (count < 0) -1
      else if (list.isEmpty) count
      else if (list.head == '(') countQuotes(list.tail, count + 1)
      else if (list.head == ')') countQuotes(list.tail, count - 1)
      else countQuotes(list.tail, count)
    }



    countQuotes(l, 0) == 0

  }

}
