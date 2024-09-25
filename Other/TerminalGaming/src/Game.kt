fun kill() {}

fun run() {}

fun main() {
    println("Welcome to the Game of Games!");

    // Init
    print("Enter your name: ")
    val name = readLine()!!
    println("$name logged in!")

    // Select your class
    println("[ CLASSES ]")
    println("1 - Warrior\n2 - Mage\n3 - Thief")
    print("Enter the number of class: ")

    val classes = readLine()!!.toInt()

    val classChoosen = when(classes) {
        1 -> "Warrior is what you choose! You like the taste of Iron and Blood!"
        2 -> "You pussy litle fillfhy, you chose mage 😂😂😂"
        3 -> "So you indeed are a Thief, like to take the final loot ahn?"
        else -> { "Choose one of the numbers!!!" }
    }

    println(classChoosen);

    // Start the adventure
    println("\n----------------------------------------");
    println("You are walking on a trails of rainbow rocks, you get more and more facinated by the colors... walking by some time, you encounter a Goblin [Level 3]");
    println("You want to kill it or run?\n")

    val playerAction: Int = 0


    println("1 - Attack | 2 - Run")
}