package com.nms.traits

/**
 * User: nsullins
 * Date: 1/15/11
 * Time: 3:27 PM
 */

trait IncrementingPlus extends Incrementing {

	abstract override def put(x: Int) = {
		println("IncrementingPlus")
		super.put(x + 1)
	}
}