package com.ngctien.noteapps.data

import java.io.Serializable
import java.util.Date

data class Note(val id: String, val title: String, val content: String, val createdDate: Date) :
    Serializable

/*
val NOTES = listOf(
    Note(
        id = 1,
        title = "Youtube script ideas \uD83C\uDF96",
        content = "There are many apps in Android that can run or emulate other operating systems, via utilizing hardware support for platform... "
    ),
    Note(
        id = 2,
        title = "Datastore Blog Ideas  \uD83E\uDD8B",
        content = "There are many apps in Android that can run or emulate other operating systems, via utilizing hardware support for platform... "
    ),
    Note(
        id = 3,
        title = "College skit review \uD83C\uDFC4\uD83D\uDE1D",
        content = "There are many apps in Android that can run or emulate other operating systems, via utilizing hardware support for platform... "
    ),
    Note(
        id = 4,
        title = "\uD83D\uDCCC Points to remember",
        content = "There are many apps in Android that can run or emulate other operating systems, via utilizing hardware support for platform... "
    )
)
*/