package Shapes

case class Circle(val c: Point, val r: Int) extends Shape{
  override def area: Double = scala.math.Pi * ( r * r )
  override def boundingBox: Rectangle = new Rectangle(new Point(c.x - r, c.y - r), 2*r, 2*r)

  override def SVGText: String = {
    "<ellipse cx=" + (scaleFactor * c.x).toString + " cy=\"" + (scaleFactor * c.y).toString + "\" rx=\"" +
      (scaleFactor * r).toString + "\" ry=\"" + (scaleFactor * r).toString + "\"/>"
  }
  override def plainText: String = {
    "Circle(Point(" + c.x.toString + ", " + c.y.toString + "),  " + r.toString + ", " + r.toString + ")"
  }
}
