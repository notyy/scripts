#!/bin/sh
exec scala -nc "$0" "$@"
!#

import scala.io._
import java.io._

def writeToFile(f: java.io.File)(data: List[String]) {
  val p = new java.io.PrintWriter(f)
  try { data.foreach(p.println) } finally { p.close() }
}

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

def process(fileName: String){
  val source =  Source.fromFile(fileName).getLines
  println("processing " + fileName)
  val target = source.foldLeft(List[String]()){(acc, s) =>
    val rs = replaceUrl(s)
    if(rs.isEmpty) acc
    else (rs.get::acc)
  }
writeToFile(new File(fileName))(target.reverse)
}

println("got " + args.length + " arguments")
args.foreach(process)

