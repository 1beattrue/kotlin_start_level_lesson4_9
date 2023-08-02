class Programmer(name: String, age: Int, val language: String) : Worker(name, age), Cleaner {
    override fun work() {
        println("Пишу код на языке $language")
    }

    override fun clean() {
        println("Программист убирает")
    }
}