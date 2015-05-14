package com.nms.typeParameterization

/**
 * User: nsullins
 * Date: 1/15/11
 * Time: 3:35 PM
 */

class FunctionalQueue[T]private (
	private val leading: List[T],
	private val trailing: List[T]){

	private def mirror = {
		if(leading.isEmpty)
			new FunctionalQueue(trailing.reverse, Nil)
		else
			this
	}

	def head = mirror.leading.head

	def tail = {
		val q = mirror
		new FunctionalQueue(q.leading.tail, q.trailing)
	}

	def append(x: T) = {
		new FunctionalQueue(mirror.leading, x :: trailing)
	}
}

object FunctionalQueue {

	//remember that the * means that there could be multiple params of the same type
	def apply[T](x: T*) = {
		new FunctionalQueue[T](x.toList, Nil)
	}
}