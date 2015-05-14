package com.nms.lists

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:20 PM
 */

class HighOrderListFuncs{

  def flatMapExample{

    val functionalVal = List.range(1, 5) flatMap(i => List.range(1, i) map (j => (i, j)))
    val forVal = for(i <- 1 to 5; j <- i to 5)yield (i, j)
    assert(functionalVal == forVal)
    List(2).flatMap
  }

  //foreach takes a procedure (a function with result type Unit) as right operand. It simply applies the procedure to each element in the list
  def foreachExample{

    var sum = 0
    List(1, 2, 3, 4) foreach (sum += _)
    assert(10 == sum)
  }

  //filter takes as perands a list xs of type List[T] and a predicate function p of type T => Boolean
  def filterExample{

    val ls = List(1,2,3,5) filter (_ % 2 == 0)
    assert(2 == ls.head)
  }

  //the partition method is like filter but it returns a pair of lists. One list contains all elements for which the predicate is true while the other
  //list contains all elements for which the predicate is false. It is defined by the equality
  //			xs partion p equals (xs filter p, xs filter (!p(_)))
  def partitionExample{

    val ls = List(1,2,3,4,5) partition (_ % 2 == 0)
    val evens = ls._1
    val odds = ls._2
    assert(List(2,4) == evens)
    assert(List(1,3,5) == odds)
  }

  //find is similar to filter except that it returns the first element that satisfies the condition instead of a list
  def findExample{

    val ls = List(1,2,3,4,5) find (_ % 2 == 0)
    assert(ls == Some(2))
  }

  //takes the longest prefix of a list such that the predicate boolean funtion is true
  def takeWhileExample{
    val integers = List(1,2,3,-4,5) takeWhile (_ > 0)
    assert(List(1,2,3) == integers)
  }

  //whereas takeWhile will 'take' from the list the values that satisfy the predicate the dropWhile will drop from the list being invoked on returning
  //whats left
  def dropWhileExample{
    val integers = List(1,-2,3,4,5) dropWhile (_ > 0)
    assert(List(-2,3,4,5) == integers)
  }

  //the span method combines takeWhile and dropWhile in one operation just like splitAt combines take and drop
  // xs span p equals (xs takeWhile p, xs dropWhile p)
  def spanExample{
    val integers = List(1,2,3,4,5,-7,8,9,10,11) span (_ > 0)
    assert(integers._1 == List(1,2,3,4,5))
    assert(integers._2 == List(-7,8,9,10,11))
  }

  //forall takes as arguments a list xs and a predicate p and returns true when all elements of the list satisfy the predicate
  def forallExample{

    val isPos = List(1,2,3) forall (_ > 0)
    assert(isPos == true)
  }

  //exists returns true if any of the elements in the list satisfy the predicate
  def existsExample{

    val isPos = List(-1,-2,3) exists (_ > 0)
    assert(isPos == true)
  }

  //folding lists
  //fold left is defined by the following
  //  (z /: List(a,b,c)) (op) equals op(op(op(z,a),b),c)
  /* Graphical Representation: leans left and thus the name fold LEFT
   *
   *				      op
   *             /  \
   *           op    c
   *          /  \
   *         op   b
   *        /  \
   *       z    a
   */
  def foldLeftExample{

    val words = List("one", "flew", "over", "the", "cuckoos", "nest")
    val wordsWithSpaces = ("" /: words)(_ + " " + _)
    assert(" one flew over the cuckoos nest" == wordsWithSpaces)

    //to remove the intial space use the following
    val modifiedWordsWithSpaces = (words.head /: words.tail)(_ + " " + _)
    assert("one flew over the cuckoos nest" == modifiedWordsWithSpaces)
  }

  //fold right is defined by the following
  //(List(a,b,c) :\ z)(op) equals op(a, op(b, op(c,z)))
  /*
   * 			  op
   * 		   /  \
   * 		  a	   op
   * 			    /  \
   *         b   op
   *            /  \
   *           c    z
   */
  def foldRightExample{
    val words = List("one", "flew", "over", "the", "cuckoos", "nest")
    val wordsWithSpaces = (words :\ "")(_ + " " + _)
    assert("one flew over the cuckoos nest" == wordsWithSpaces)
  }

  //IMPORTANT NOTE: although the /: and :\ operators have the advantage that the direction of the slash resembles the graphical depiciton of their
  //respective left or right-leaning trees, and the associativity of the colon character places the start value in the same position in the expression
  //as it is in the tree, alternatively you can use the methods foldLeft and foldRight defined on the List class


  //sorting -
  //note that sort does a merge sort much as msort in MergeSort.scala example. Obviously this is a method of List class
  def sortExample{

    val sortedList = List(1,2,3,4,-5,-8,9) sort (_ < _)
    assert(List(-8,-5,1,2,3,4,9) == sortedList)
  }

}