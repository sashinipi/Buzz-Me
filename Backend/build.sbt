name := "sample"
 
version := "1.0" 
      
lazy val `sample` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs )
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
libraryDependencies += jdbc

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      