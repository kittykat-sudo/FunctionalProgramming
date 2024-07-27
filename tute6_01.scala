object InventorySystem extends App {
  // Define the product case class
  case class Product(name: String, quantity: Int, price: Double)

  // Sample inventories
  val inventory1: Map[Int, Product] = Map(
    101 -> Product("ProductA", 10, 15.5),
    102 -> Product("ProductB", 5, 25.0),
    103 -> Product("ProductC", 20, 7.5)
  )

  val inventory2: Map[Int, Product] = Map(
    102 -> Product("ProductB", 10, 20.0),
    104 -> Product("ProductD", 15, 30.0)
  )

  // I. Retrieve all product names from inventory1
  val productNames = inventory1.values.map(_.name).toList
  println("Product Names in Inventory1: " + productNames)

  // II. Calculate the total value of all products in inventory1
  val totalValue = inventory1.values.map(p => p.quantity * p.price).sum
  println("Total Value of Inventory1: " + totalValue)

  // III. Check if inventory1 is empty
  val isEmpty = inventory1.isEmpty
  println("Is Inventory1 Empty? " + isEmpty)

  // IV. Merge inventory1 and inventory2, updating quantities and retaining the highest price
  val mergedInventory = (inventory1.keySet ++ inventory2.keySet).map { id =>
    val product1 = inventory1.get(id)
    val product2 = inventory2.get(id)
    val mergedProduct = (product1, product2) match {
      case (Some(p1), Some(p2)) =>
        Product(p1.name, p1.quantity + p2.quantity, math.max(p1.price, p2.price))
      case (Some(p1), None) => p1
      case (None, Some(p2)) => p2
      case _ => throw new IllegalStateException("Unexpected case")
    }
    id -> mergedProduct
  }.toMap
  println("Merged Inventory: " + mergedInventory)

  // V. Check if a product with a specific ID (e.g., 102) exists and print its details
  val productIdToCheck = 102
  inventory1.get(productIdToCheck) match {
    case Some(product) => println(s"Product with ID $productIdToCheck: $product")
    case None => println(s"Product with ID $productIdToCheck does not exist in Inventory1")
  }
}