package com.nms

import java.io._

/**
 * User: nsullins
 * Date: 1/10/11
 * Time: 10:03 PM
 */

object NewControlStructuresAndByNameParams{

  def twice(op: Double => Double, x: Double) = op(op(x))

  //Any time you find a control pattern repeated in multiple parts of your program you should consider implemting it as a new control structure


  //a common control structure for a control pattern is called a loan pattern because it loans a pattern to an operation
  //consider the following withPrintWriter loan pattern that loans a printwriter to a function

  def withPrintWriter(file: File, op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close
    }
  }

  //e.g. of function using printwriter loan pattern
  withPrintWriter(
    new File("filename"), writer => writer.println("someLine")
  )


  //In any method invocation in Scala where you're passing in only one parameter you can use () or {} The purpose of this is to allow
  //programmers to write function literals between the braces
  //Here is the above method refactored to use currying so that we can use the preferred style of braces which makes the method call
  //feel more like a control abstraction


  def withPrintWriterCurried(file: java.io.File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close
    }
  }

  val file = new File("filename")
  withPrintWriterCurried(file){
    writer => writer.println("curried babay")
  }


  //ByName parameters
  //the loan pattern control abstraction above is different from a built in control such as if or while in that the code within the
  //braces operates on a parameter i.e. writer. By-name parameters allows you to create control abstractions with no parameters to be passed
  //in just like an if or while control

  //DEFINITION - by-name parameter is a param that is marked with a => in front of the parameter type e.g. (x: => Int). The argument corresponding to a by-name
  //parameter is evaluated not before the method is invoked but each time the parameter is referenced by name inside the method. If a parmeter is not
  //by-name is is by-value



  //given we had function like so where () is an empty parameter list

  var assertionEnabled = true
  def myAssert(predicate: () => Boolean) = {
    if(assertionEnabled && !predicate())
      throw new AssertionError
  }

  //if we wanted to call this function it would look something like this
  myAssert(() => 5 > 3)

  //using by-name parameter allow us to trade the () => for =>

  def myAssertByParam(predicate: => Boolean) = {
    if(assertionEnabled && !predicate)
      throw new AssertionError
  }

  //and can be called like so
  myAssertByParam(5 > 3)

}