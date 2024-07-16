object Fibonacci {
  def fibonacci(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def printFibonacciSequence(n: Int): Unit = {
    for (i <- 0 until n) {
      println(fibonacci(i))
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 10 // Example: print first 10 Fibonacci numbers
    println(s"First $n Fibonacci numbers:")
    printFibonacciSequence(n)
  }
}