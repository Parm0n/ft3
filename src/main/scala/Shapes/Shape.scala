package Shapes

import java.io.{BufferedWriter, File, FileWriter}

trait Shape {
  val scaleFactor: Int = 100
  def area: Double
  def boundingBox: Rectangle

  def plainText(): String

  def SVGText(): String

  def exportAll(fileName: String): Unit = {

    val filePlain = new File(fileName + ".txt")
    val bwPlain = new BufferedWriter(new FileWriter(filePlain))
    bwPlain.write(plainText())
    bwPlain.close()


    val fileSVG = new File(fileName + ".svg")
    val bwSVG = new BufferedWriter(new FileWriter(fileSVG))
    bwSVG.write(SVGText())
    bwSVG.close()

  }
}
