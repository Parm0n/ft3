class Point(val x: Int, val y: Int) extends Shape{
  override def area: Double = 0
  override def boundingBox: Rectangle = new Rectangle(this, 0, 0)
}
