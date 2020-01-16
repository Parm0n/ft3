import org.scalatest.{FunSuite, Matchers}
import org.scalactic.Tolerance._
import Shapes.{Circle, Composite, Line, Point, Rectangle}

class ShapesTest  extends FunSuite with Matchers {
  test("point") {
    val p = new Point(0, 0)
    p.area shouldBe 0
    p.boundingBox shouldBe new Rectangle(new Point(0,0), 0, 0)
  }

  test("line") {
    val l = Line(Point(0, 0), Point(1, 1))
    l.area shouldBe 0
    l.boundingBox shouldBe Rectangle(Point(0,0), 1, 1)
  }

  test("circle") {
    val c = Circle(Point(0, 0), 2)
    // never compare floats directly
    c.area shouldBe math.Pi * 2 * 2 +- 0.001
    c.boundingBox shouldBe Rectangle(Point(-2,-2), 4, 4)
  }

  test("rectangle") {
    val r = Rectangle(Point(0, 0), 2, 2)
    r.area shouldBe 4
    r.boundingBox shouldBe r
  }

  test("test Frpm ReadMe") {
    val r1 = Rectangle(Point(3, 1), 3, 2)
    val r2 = Rectangle(Point(1, 3), 7, 2)
    val c1 = Circle(Point(2, 5), 1)
    val c2 = Circle(Point(7, 5), 1)
    val l1 = Line(Point(7, 3), Point(8, 2))
    val l2 = Line(Point(8, 2), Point(9, 2))
    val C = Composite(r1, r2, c1, c2, l1, l2)

    C.area shouldBe 26.28 +- 0.01

    print(C.plainText)
  }
}
