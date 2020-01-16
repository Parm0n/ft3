class Composite(shapes : Shape*) extends Shape {

  var color: String = "#000000"
  var width: Int = 2

  /// Sum all areas
  override def area: Double = {
    var res: Double = 0
    for(it<- shapes){
      res += it.area
    }
    res
  }

  ///Finding of 2 points:
  /// first point has minimal x and y from all of left corners of all
  ///shapes boundingBoxes. And second is opposite: has max x and y
  override def boundingBox: Rectangle = {
    var leftCornerX: Int = Int.MaxValue
    var leftCornerY: Int = Int.MaxValue
    var rightCornerX: Int = Int.MinValue
    var rightCornerY: Int = Int.MinValue

    for(it<- shapes){
      if(leftCornerX > it.boundingBox.tl.x)
        leftCornerX = it.boundingBox.tl.x
      if(leftCornerY > it.boundingBox.tl.y)
        leftCornerY = it.boundingBox.tl.y
      if(rightCornerX < it.boundingBox.tl.x + it.boundingBox.width)
        rightCornerX = it.boundingBox.tl.x + it.boundingBox.width
      if(rightCornerY < it.boundingBox.tl.y + it.boundingBox.height)
        rightCornerY = it.boundingBox.tl.y + it.boundingBox.height
    }

    new Rectangle(new Point(leftCornerX, leftCornerY), rightCornerX - leftCornerX, rightCornerY - leftCornerY)
  }
}
