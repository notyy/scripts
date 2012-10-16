#!/bin/sh
exec scala -nc "$0" "$@"
!#

import java.io._

args.foreach {fileName =>
  val newFileName = fileName.replace("_high","")
  val file = new File(newFileName)
  if (file.exists()){
    println("backup $newFileName")
    file.renameTo(new File(newFileName + ".bak"))
  }
  import scala.sys.process._
  ("git mv " + fileName + " " + newFileName).!
}
