package com.nms.compAndInherit

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:04 PM
 */

abstract class Element{

	//a method is abstract if it doesnt have an implementation i.e. an equals sign or body. the following method is abstract
	def contents: Array[String]

	def height: Int = contents.length

	def width: Int = if(height == 0) 0 else contents(0).length

	def above(that: Element): Element =
		new ArrayElement(this.contents ++ that.contents)

	def beside(that: Element): Element = {
		new ArrayElement(for(
			(line1, line2) <- this.contents zip that.contents) yield line1 + line2)
	}
}

object Element{

	def elem(contents: Array[String]): Element = {
		new ArrayElement(contents)
	}

	def elem(line: String): Element = {
		new LineElement(line)
	}

	def elem(ch: Char, height: Int, width: Int): Element = {
		new UniformElement(ch, height, width)
	}

}

