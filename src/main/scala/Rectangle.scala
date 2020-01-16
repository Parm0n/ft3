class Rectangle(val tl: Point, val width: Int, val height: Int) extends Shape{

  override def area: Double = width * height
  override def boundingBox: Rectangle = this

}
