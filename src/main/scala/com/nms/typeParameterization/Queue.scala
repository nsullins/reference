package com.nms.typeParameterization

/**
 * User: nsullins
 * Date: 1/15/11
 * Time: 3:34 PM
 */

trait Queue[+T] {

	def head: T
	def tail: Queue[T]
	def append[U >: T](ele: U): Queue[U]
}
object Queue{

	//we can't use just T here and have a covariant class definition. we have to apply a lower bound in order to achieve this
	def apply[T](x: T*) : Queue[T] =
		new QueueImpl(x.toList, Nil)

	private class QueueImpl[T] (
	private val leading: List[T],
	private val trailing: List[T]) extends Queue[T]{

		private def mirror: QueueImpl[T] = {
			if(leading.isEmpty)
				new QueueImpl(trailing.reverse, Nil)
			else
				this
		}

		def head: T = mirror.leading.head

		def tail: QueueImpl[T] = {
			val q = mirror
			new QueueImpl(q.leading.tail, q.trailing)
		}

		def append[U >: T](x: U) = {
			new QueueImpl(mirror.leading, x :: trailing)
		}
	}

}
