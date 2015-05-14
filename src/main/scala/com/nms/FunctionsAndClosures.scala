package com.nms

import scala.io._


/**
 * User: nsullins
 * Date: 1/10/11
 * Time: 8:51 PM
 */

object FunctionsAndClosures{

  def processFile(filename: String, width: Int) {

    val source = Source.fromFile(filename)
    for(line <- source.getLines )
      processLine(filename, width, line)
  }

  private def processLine(filename: String, width: Int, line: String) {
    if(line.length >= width) println(filename + ": " + line.trim)
  }

  //example of a local function notice how the method signatures are simplified
  def processFileLocalFunction(filename: String, width: Int) {

    def processLine(line: String){
      if(line.length >= width) println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for(line <- source.getLines )
      processLine(line)
  }


  //e.g. of closure which is a function literal with variable binding in this case the variable more
  def makeIncreaser(more: Int) = (x: Int) => x + more

  //in this call the val is a function value closure capturing the value 9999
  val closure = makeIncreaser(9999)

  closure(10)// thiswill return 10009

  //note: for closures 9999 is stored on the heap so that the value can be accessed oustide of the method call that created it

}