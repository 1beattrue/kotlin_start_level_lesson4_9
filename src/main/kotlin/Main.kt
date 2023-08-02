fun main() {
    // абстрактные классы, интерфейсы

    val workers = mutableListOf<Worker>()
    workers.add(Programmer("Антон", 19, "java"))
    workers.add(Programmer("Кирилл", 23, "kotlin"))
    workers.add(Seller("Павел", 34))
    workers.add(Director("Виталий", 20))

    for (worker in workers) {
        print("${worker.name}: ")
        worker.work()
    }

    println()

    // теперь нужно заставить всех убрать свои рабочие места(кроме директора, ему по статусу не положено)
    for (worker in workers) {
        // worker.clean() - так сделать не можем, ибо в классе Worker метод clean() не определен
        // наша задача: проверить, реализует ли worker интерфейс Cleaner, если реализует - вызвать метод clean()

        // используем для этого Smart Cast
        if (worker is Cleaner) {
            worker.clean()
        }
    }

    // Smart Cast - умное преобразование типов
    // еще пример:

    for (worker in workers) {
        if (worker is Programmer) {
            println(worker.language) // так как мы проверили, что работник является программистом -> автоматически приведя тип к Programmer, получаем доступ к полю language
        }
    }

    // явное приведение типа - type1 as type2 (аналог (type2) type1 из java)

    println()

    // домашнее задание - сделать из коллекции работников коллекцию уборщиков
    val cleaners = workersToCleaners(workers)
    for (cleaner in cleaners) cleaner.clean() // солнце светит - бебры пашут

    // итак, оператор is - проверка, является ли объект типом какого-то класса, если является - в блоке if (is) сразу обратиться к нему как к типу этого класса с помощью Smart Cast
    //       оператор as - явное приведение типа
}

fun workersToCleaners(workers: List<Worker>): List<Cleaner> {
    return workers.filter { it is Cleaner }.map { it as Cleaner }
}