import Shapes.{Circle, Composite, Line, Point, Rectangle}

object Main {

  def main(args: Array[String]): Unit = {

    val r1 = Rectangle(Point(3, 1), 3, 2)
    val r2 = Rectangle(Point(1, 3), 7, 2)
    val c1 = Circle(Point(2, 5), 1)
    val c2 = Circle(Point(7, 5), 1)
    val l1 = Line(Point(7, 3), Point(8, 2))
    val l2 = Line(Point(8, 2), Point(9, 2))
    val C = Composite(r1, r2, c1, c2, l1, l2)

    C.exportAll("example")
    print(C.SVGText())
  }
}
