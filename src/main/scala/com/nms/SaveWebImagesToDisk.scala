package com.nms

/**
 * User: nsullins
 * Date: 1/10/11
 * Time: 10:08 PM
 */

object SaveWebImagesToDisk extends Application {

  //this was used as a script for MNP


  val filename = "/Users/nsullins/dev/errorsTest.csv"
  System.out.println("filename is:" + filename)
  val errors = scala.io.Source.fromFile(filename)
  val tuples = for{line <- errors.getLines
      arr = line.trim.split(",")
      t = (arr(0), arr(1))
  }yield t

  val path = "/Users/nsullins/dev"
  for(tuple <- tuples){
	  val filePath = tuple._1
	  val filename = filePath + "/" + tuple._2
	  val file = new java.io.File(path + filePath)
	  if(!file.exists){
	 	  file.mkdirs
	  }

	  val url = new java.net.URL("http://g.mnp0.com/" + filename)
	  val inputStream = url.openConnection.getInputStream
	  var outputStream = new java.io.FileOutputStream(path + filename)
	  var data = new Array[Byte](4096)
	  try {
		  	Iterator.continually(inputStream.read(data)).takeWhile(_ != -1).foreach{
		  		outputStream.write(data, 0, _)
	  		}
	  }finally {
        outputStream.close()
        inputStream.close()
	  }

  }
}