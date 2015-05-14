package com.nms

/**
 * User: nsullins
 * Date: 1/10/11
 * Time: 9:55 PM
 */
object FirstApplication extends Application{

//	for(season <- List("fall", "spring", "winter", "summer"))
//		println( season + ":" + calculate(season))

	println(multitable)

	def makeRowSeq(row: Int) =
		for(col <- 1 to 10) yield {
			val i = (row * col).toString
			val padding = " " * (4 - i.length)
			padding + i
		}


	def makeRow(i: Int) = makeRowSeq(i).mkString

	def multitable() = {

		val multitab = for(i <- 1 to 10) yield makeRow(i)
		multitab.mkString("\n")
	}
}