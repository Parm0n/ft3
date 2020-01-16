package Shapes

case class Rectangle(val tl: Point, val width: Int, val height: Int) extends Shape{

  override def area: Double = width * height
  override def boundingBox: Rectangle = this

  override def SVGText: String = {
      "<rect x=" + (scaleFactor * tl.x).toString + " y=\"" + (scaleFactor * tl.y).toString +
        "\" width=\"" + (scaleFactor * width).toString + "\" height=\"" + (scaleFactor * height).toString + "\"/>"
  }
  override def plainText: String = {
    "Rectangle(Point(" + tl.x.toString + ", " + tl.y.toString + "),  " + width.toString + ", " + height.toString + ")"
  }

}
