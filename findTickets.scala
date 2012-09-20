#!/bin/sh
exec scala -nc "$0" "$@"
!#

import scala.io._

val source = if(args.length>0) Source.fromFile(args(0)).getLines else Source.stdin.getLines
val pattern = """([a-zA-Z]+)-(\d+)""".r
source.flatMap(pattern.findFirstIn).toList.distinct.foreach(println)
