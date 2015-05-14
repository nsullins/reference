package com.nms.compAndInherit

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:09 PM
 */

class UniformElement(ch: Char, override val height: Int, override val width: Int) extends Element {

	println("asserting height is greater than zero")
	assert(height > 0)
	private val line = ch.toString * width
	def contents = Array.make(height, line)

}