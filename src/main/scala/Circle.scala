class Circle(val c: Point, val r: Int) extends Shape{
  override def area: Double = scala.math.Pi * ( r * r )
  override def boundingBox: Rectangle = new Rectangle(new Point(c.x - r, c.y - r), 2*r, 2*r)
}
