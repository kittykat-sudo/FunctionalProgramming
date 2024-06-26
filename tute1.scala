object MathProblems extends App {
    // 1. Area of a disk with radius r is Pi r*r. What is the area of a disk with radius 5?
    def diskArea(rad: Double): Double = Math.PI *rad *rad
    println ("Area of a disk with radius 5: " + diskArea(5))

    //The s before the string literal println(s"Area of a disk with radius 5: ${diskArea(5)}") in Scala is a string interpolator that allows the inclusion of variable references directly inside string literals.
    
    // 2. The temperature is 35C; convert this temperature into Fahrenheit.
    def celciustofaren(celcius: Double):Double = celcius * 1.8000 + 32.00
    println(s"35C in Fahrenheit: ${celciustofaren(35)}")

    // 3. The volume of a sphere with radius r is 4/3 Pi r^3. What is the volume of a sphere with radius 5?
    def sphereVolume(radius:Double): Double = (4.0/ 3) * Math.PI * Math.pow(radius, 3)
    println(s"Volume of a sphere with radius 5: ${sphereVolume(5)}")


    // 4. Suppose the cover price of a book is Rs. 24.95, but bookstores get a 40% discount. Shipping costs Rs. 3 for the first 50 copies and 75 cents for each additional copy. What is the total wholesale cost for 60 copies?
    def bookPrice(x: Int): Double = x * 24.95
    def discount(x: Int): Double = bookPrice(x) * 0.4
    def shippingCost(x: Int): Double = if (x <= 50) x * 3 else (50 * 3) + ((x - 50) * 0.75)
    def totalCost(x: Int): Double = bookPrice(x) + shippingCost(x) - discount(x)

    // Calculate the total wholesale cost for 60 copies
    val totalWholesaleCost = totalCost(60)
    println(f"Total wholesale cost for 60 copies: Rs. $totalWholesaleCost%.2f")

    // 5. I run 2 km at an easy pace (8 min per km), then 3 km at Tempo (7 min per km) and 2 km at easy pace again to reach home. What is the total running time?
    def totalRunningTime(easyPaceKm: Int, tempoKm: Int, easyPaceTime: Int, tempoTime: Int): Int = {
        (easyPaceKm * easyPaceTime) + (tempoKm * tempoTime) + (easyPaceKm * easyPaceTime)
    }
    println(s"Total running time: ${totalRunningTime(2, 3, 8, 7)} minutes")
}
