package Shapes

case class Point(val x: Int, val y: Int) extends Shape{
  override def area: Double = 0
  override def boundingBox: Rectangle = new Rectangle(this, 0, 0)

  override def SVGText: String = {
    "<ellipse cx=" + (scaleFactor * x).toString + " cy=\"" + (scaleFactor * y).toString + "\" rx=\"" +
      (10).toString + "\" ry=\"" + (10).toString + "\"/>"
  }
  override def plainText: String = {
    "Point(" + x.toString + ", " + y.toString + ")"
  }
}
