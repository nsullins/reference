package com.nms.traits

/**
 * User: nsullins
 * Date: 1/15/11
 * Time: 3:27 PM
 */

trait Incrementing extends IntQueue{

	abstract override def put(x: Int) = {
		println("Incrementing")
		super.put(x + 1)
	}
}