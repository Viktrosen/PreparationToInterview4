package com.example.preparationtointerview4.model

class MainRepository {
    private var minute = 1000 * 60
    val exam:Long =  ((minute * 1440) + (minute * 155) + (1000 * 50)).toLong()

    var classes = mutableListOf<Classes>(
        Classes("History","8:00-8:45"),
        Classes("Physics","8:50-9:35"),
        Classes("P.E.","9:50-10:35")
    )

    var homework = mutableListOf<Homework>(
        Homework("History","3 days ago","Learn a lot of dates"),
        Homework("Physics","1 days ago","Solve task number 5"),
        Homework("Literature","4 days ago","Read 'Master and Margarita'")
    )
}