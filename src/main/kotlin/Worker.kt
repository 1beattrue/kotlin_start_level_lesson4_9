abstract class Worker(val name: String, val age: Int) { // ключевое слово abstract запрещает создавать экземпляры данного класса
    // теперь от этого класса можно только наследоваться

    abstract fun work() // если мы не хотим оставлять реализацию метода по умолчанию, мы также должны сделать его абстрактным
}