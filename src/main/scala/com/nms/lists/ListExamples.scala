package com.nms.lists

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:54 PM
 */

class ListExamples{

	//here are c couple of methods that do sort insertion

	def isortI(ls: List[Int]): List[Int] = {
		if(ls.isEmpty) Nil
		else insert(ls.head, ls.tail)
	}

	def insert(x: Int, ls: List[Int]): List[Int] = {
		if(x <= ls.head) x::ls
		else ls.head :: insert(x, ls.tail)
	}

	//and here's the same two functions but using pattern matching instead

	def isortP(ls: List[Int]): List[Int] = ls match{
		case List() => Nil
		case _ => insertP(ls.head, ls.tail)
	}

	def insertP(x: Int, ls: List[Int]): List[Int] = ls match{
		case List() => List(x)
		case y::ys => if(x <= ls.head) x::ls
					  else ls.head :: insertP(x, ys)
	}

	//First order methods on Lists

	//Concatenation

	def consVersusConcatenation[A](l1: List[A], l2: List[A]): List[A] = {

		//unlike cons :: concatenation takes two lists as operands
		val newList = l1:::l2
		val prependedList = 9 :: newList
		newList
	}


	//Here is an implementation of concatenation using pattern matching
	def append[T](xs: List[T], ys: List[T]): List[T] = xs match{

		case List() => ys
		case x :: xs1 => x :: append(xs1, ys)
	}

}