package com.nms.traits

import scala.collection.mutable.{ArrayBuffer}

/**
 * User: nsullins
 * Date: 1/13/11
 * Time: 4:36 PM
 */

class BasicQueue extends IntQueue{

	private val buf = new ArrayBuffer[Int]()
	def get(): Int = buf.remove(0)
	def put(elem: Int) {
		println("BasicQueuing")
		buf += elem
	}
}