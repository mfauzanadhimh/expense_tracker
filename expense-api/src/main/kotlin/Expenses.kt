package org.example

import kotlinx.serialization.Serializable

@Serializable
data class Expenses(
    var id: Int,
    var name: String,
    var category: String,
    var quantity : Int,
    var date: String
//    LocalDateTime = LocalDateTime.now()
)

