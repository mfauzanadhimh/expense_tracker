package org.example.database

import org.jetbrains.exposed.sql.Database


object DatabaseFactory {


    fun init(){


        Database.connect(
            url = "jdbc:postgresql://localhost:5432/expense_db",
            driver = "org.postgresql.Driver",
            user = "expense_user",
            password = "expense_password"
        )


    }

}