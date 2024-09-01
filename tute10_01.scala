class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be non-zero")
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def neg: Rational = new Rational(-numer, denom)

  override def toString: String = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object Main {
  def main(args: Array[String]): Unit = {
    // Example usage
    val x = new Rational(3, 4)
    println("Here the output " + x.neg)  // Output: -3/4
  }
}