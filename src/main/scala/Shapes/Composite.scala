package Shapes

case class Composite(shapes : Shape*) extends Shape {

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

  override def SVGText: String = {
    var res: String = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
      "<!DOCTYPE svg  PUBLIC '-//W3C//DTD SVG 1.1//EN'  'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'>\n"

    res += "<svg width=\"" + (scaleFactor * (boundingBox.width + boundingBox.tl.x)).toString + "\" height=\"" +
      (scaleFactor * (boundingBox.height + boundingBox.tl.y)).toString + "\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n"
    res += "<g stroke=\"" + color + "\" stroke-width=\"" + width.toString + "\" fill=\"none\">\n"

    for(it <- shapes){
      res += it.SVGText() + "\n"
    }

    res += "\n  </g>\n</svg>\n"

    res
  }
  override def plainText: String = {
    var res: String = "Composite(\n  List(\n"

    for(it <- shapes){
      res += "    " + it.plainText() + ",\n"
    }

    //Deletes last ',\n' symbols
    res = res.dropRight(2)
    res += "\n  ),\n  Stroke(" + width.toString + " " + color + ")\n)\n"
    res
    // "Rectangle(Point(" + tl.x.toString + ", " + tl.y.toString + "),  " + width.toString + ", " + height.toString + ")"
  }
}
