package org.example.controller

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import org.example.service.ExpenseService
import org.example.model.Expenses


class ExpenseController(
    private val service: ExpenseService
){


    suspend fun getExpense(
        call: ApplicationCall
    ){

        val id =
            call.parameters["id"]
                ?.toIntOrNull()
                ?: return call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid ID"
                )


        val expense =
            service.getExpense(id)


        call.respond(
            HttpStatusCode.OK,
            expense
        )

    }



    suspend fun postExpense(
        call: ApplicationCall
    ){

        val expense =
            call.receive<Expenses>()


        val result =
            service.createExpense(expense)


        call.respond(
            HttpStatusCode.Created,
            result
        )

    }



    suspend fun putExpense(
        call: ApplicationCall
    ){

        val expense =
            call.receive<Expenses>()


        val result =
            service.updateExpense(expense)


        call.respond(
            HttpStatusCode.OK,
            result
        )

    }



    suspend fun deleteExpense(
        call: ApplicationCall
    ){

        val id =
            call.parameters["id"]
                ?.toIntOrNull()
                ?: return call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid ID"
                )


        val result =
            service.deleteExpense(id)


        call.respond(
            HttpStatusCode.OK,
            result
        )

    }



    suspend fun getTotalExpense(
        call: ApplicationCall
    ){

        val total =
            service.getTotalExpense()


        call.respond(
            HttpStatusCode.OK,
            total
        )

    }

}