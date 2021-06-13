package mohsen

case class Dot(x: Double, y: Double)

case class Triangle(dot1: Dot, dot2: Dot, dot3: Dot):
  def area(): Double = Math.abs((dot1.x * dot2.y + dot2.x * dot3.y + dot3.x * dot1.y - dot1.y * dot2.x - dot2.y * dot3.x - dot3.y * dot1.x) / 2)
