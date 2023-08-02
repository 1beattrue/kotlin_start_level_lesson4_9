class Seller(name: String, age: Int) : Worker(name, age), Cleaner {
    override fun work() {
        println("Продаю товар")
    }

    override fun clean() {
        println("Продавец убирает")
    }
}