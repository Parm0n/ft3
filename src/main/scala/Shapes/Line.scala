package Shapes
import additional._

case class Line(val s: Point, val t: Point) extends Shape{
  override def area: Double = 0
  override def boundingBox: Rectangle = new Rectangle(
    new Point(Helpers.Min(s.x, t.x), Helpers.Min(s.y, t.x)),
    Helpers.Max(s.x, t.x) - Helpers.Min(s.x, t.x),
    Helpers.Max(s.y, t.y) - Helpers.Min(s.y, t.y))


  override def SVGText: String = {
    "<polyline  points=\"" + (scaleFactor * s.x).toString + ", " + (scaleFactor * s.y).toString +
      ", " + (scaleFactor * t.x).toString + ", " + (scaleFactor * t.y).toString + "\"/>"
  }
  override def plainText: String = {
    "Line(Point(" + s.x.toString + ", " + s.y.toString + "),  Point(" + t.toString + ", " + t.toString + "))"
  }
}
