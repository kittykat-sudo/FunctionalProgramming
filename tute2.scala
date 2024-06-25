//part 1
object VariableAssignment {
  def main(args: Array[String]): Unit = {
    var i, j, k = 2
    var m, n = 5
    var f = 12.0f
    var g = 4.0f
    var c = 'X'

    // Evaluating expressions
    val a = k + 12 * m
    val b = m / j
    val d = n % j
    val e = m / j * j
    val fExpr = f + 10 * 5 + g
    // Scala doesn't have pre-increment operator like ++i
    i += 1
    val gExpr = i * n

    println(s"a) $a")
    println(s"b) $b")
    println(s"c) $d")
    println(s"d) $e")
    println(s"e) $fExpr")
    println(s"f) $gExpr")
  }
}

//part 2
object JavaToScala {
  def main(args: Array[String]): Unit = {
    var a, b, c, d = 0
    a = 2
    b = 3
    c = 4
    d = 5
    var k = 4.3f
    var g = 3.0f // Assuming g is defined

    // Evaluating expressions
    // Note: Scala doesn't support pre-decrement and post-decrement directly. We can achieve the same logic using basic operations.
    println(-(-b) * a + c * d - (-1))
    println(a)
    a += 1
    println(-2 * (g - k) + c)
    println(c)
    c += 1
    println(c)
    c = c + 1 * a
    println(c)
  }
}


//part 3
object EmployeeSalary {
  def main(args: Array[String]): Unit = {
    def calculateSalary(normalHours: Int, otHours: Int): Double = {
      val normalRate = 250
      val otRate = 85
      val taxRate = 0.12
      val grossSalary = (normalHours * normalRate) + (otHours * otRate)
      val netSalary = grossSalary - (grossSalary * taxRate) 
      netSalary
    }

    val normalHours = 40
    val otHours = 30
    val takeHomeSalary = calculateSalary(normalHours, otHours)
    println(s"Take home salary: Rs. $takeHomeSalary")
  }
}

//part 4
object TicketProfit {
  def main(args: Array[String]): Unit = {
    def calculateProfit(ticketPrice: Double): Double = {
      val fixedCost = 500
      val costPerAttendee = 3
      val basePrice = 15
      val baseAttendance = 120

      val attendance = baseAttendance + (basePrice - ticketPrice)/5*20
      val revenue = ticketPrice * attendance
      val totalCost = fixedCost + (attendance * costPerAttendee)
      val profit = revenue - totalCost
      profit
    }

    def findOptimalTicketPrice(): Double = {
      val prices = 1 to 100 map (_ * 5) map (_ / 10.0)
      prices.maxBy(calculateProfit)
    }

    val optimalPrice = findOptimalTicketPrice()
    println(s"The optimal ticket price for maximum profit is Rs. $optimalPrice")
  }
}

