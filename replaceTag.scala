#!/bin/sh
exec scala -nc "$0" "$@"
!#

import scala.io._

var url:String =""
val MobilePattern = ".*<mobile:import url=\"(.*)\">.*".r
val CPattern = """.*<c:import url=\Q"${ path }"\E.*""".r
val EndMobilePattern=""".*</mobile:import>.*""".r
def replaceUrl(s: String): Option[String] = s match {
  case (MobilePattern(subUrl)) => url = subUrl; None
  case (CPattern()) => Some(s.replace("${ path }", url))
  case (EndMobilePattern()) => None
  case _ => Some(s)
}

val arg = args(0)
println("processing " + arg)
val source = if(args.length>0) Source.fromFile(arg).getLines.toList else List()
val target = source.foldLeft(List[String]()){(acc, s) => 
  val rs = replaceUrl(s)
  if(rs.isEmpty) acc
  else (rs.get::acc)
}

target.reverse.map(println)
