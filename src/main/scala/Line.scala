class Line(val s: Point, val t: Point) extends Shape{
  override def area: Double = 0
  override def boundingBox: Rectangle = new Rectangle(
    new Point(Helpers.Min(s.x, t.x), Helpers.Min(s.y, t.x)),
    Helpers.Max(s.x, t.x) - Helpers.Min(s.x, t.x),
    Helpers.Max(s.y, t.y) - Helpers.Min(s.y, t.y))
}
