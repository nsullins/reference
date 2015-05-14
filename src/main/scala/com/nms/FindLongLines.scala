package com.nms

/**
 * User: nsullins
 * Date: 1/10/11
 * Time: 9:58 PM
 */

object FindLongLines{

  def main(args: Array[String]){

    val width = args(0).toInt
    for(arg <- args.drop(1))
      FunctionsAndClosures.processFile(arg, width)
  }

}