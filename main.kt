//How many standard young tableaux are there of L-shape with 2 boxes in the first row and 1 box for the next n-2 rows with a total of n boxes?

fun main() {

    for (n in 1..10) {
        println("How many standard young tableaux are there of L-shape\n" +
                " with 2 boxes in the first row and 1 box for the next\n" +
                " ${n-2} rows with a total of $n boxes?")
        println("n = $n")
        var results = mutableListOf<Tableaux>()
        var numList = mutableListOf<Int>()
        for (i in 2..n) {
            numList.add(i)
        }
        for (i in 2..n) {
            var tableaux = Tableaux(n)
            var list = numList.toMutableList()
            tableaux.insert(1)

            var rightNum = list.removeAt(i - 2)
            tableaux.insert(rightNum)
            for (e in numList) {
                if (e != rightNum)
                    tableaux.insert(e)
            }
            results.add(tableaux)
        }
        results.forEach { println(it) }
        println("total number: ${results.size}")
        println()
    }
}

class Tableaux(var size: Int) {
    var firstRow = mutableListOf<Int?>()
    var subsequentRows = mutableListOf<Int?>()
    fun insert(num: Int): Boolean {
        if (subsequentRows.size + firstRow.size >= this.size)
            return false

        if (firstRow.size < 2) {
            firstRow.add(num)
        } else {
            subsequentRows.add(num)
        }
        return true
    }
    fun equals(other: Tableaux): Boolean {
        if (this.firstRow == other.firstRow)
            if (this.subsequentRows == other.subsequentRows)
                return true
        return false
    }
    override fun toString(): String {
        var output = "first row: " + firstRow[0] + " " + firstRow[1] + " then"
        subsequentRows.forEach {
            output = "$output $it"
        }
        return output
    }
}
