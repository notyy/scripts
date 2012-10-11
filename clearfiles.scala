#!/bin/sh
exec scala -nc "$0" "$@"
!#

import scala.io._
import java.io._

val source = Source.stdin.getLines
var count = 0;
source.foreach { filePath =>
  val file = new File(filePath)
  if(file.isFile && file.delete()) {
    count+=1
  }
}
println(""+count+" files delted");
