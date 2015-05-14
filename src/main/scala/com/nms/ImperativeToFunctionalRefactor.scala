package com.nms

/**
 * User: nsullins
 * Date: 1/10/11
 * Time: 10:00 PM
 */

object ImperativeToFunctionalRefactor{

  val radius = 7F
    val r = Math.ceil(radius).toInt
    val rows = r*2+1;
    val matrixArray = new Array[Float](rows)
    val sigma = radius/3F
    val sigma22 = 2*sigma*sigma;
    val sigmaPi2 = 2*java.lang.Math.PI*sigma
    val sqrtSigmaPi2 = Math.sqrt(sigmaPi2)
    val radius2 = radius*radius
    val total = matrixArray.foldLeft(0.0)((x, y) => x + y).toFloat
    val indexVals = for(row <- Iterator.range(-r, r))yield arrVal(row)
    val funcMatrix = new Array[Float](rows)
    indexVals.copyToArray(funcMatrix, 0, funcMatrix.length)
    println(funcMatrix.map((arg: Float) => arg/total).mkString(":"))

    def arrVal(row: Int) :Float = {
      val distance = row*row
          if (distance > radius2)
                0
          else{
                val num = Math.exp(-(distance)/sigma22).toFloat
                val den = sqrtSigmaPi2.toFloat
                num/den
          }
    }

}