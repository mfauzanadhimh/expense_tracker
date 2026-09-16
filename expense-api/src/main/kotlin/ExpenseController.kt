package org.example

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond

class ExpenseController(
    private val service: ExpenseService
    ){


    suspend fun getExpense(call: ApplicationCall) {
        val id = call.parameters["id"]?.toIntOrNull()
            ?: return call.respond(HttpStatusCode.BadRequest)

        val expense = service.getExpense(id)

        call.respond(expense)
    }



    suspend fun postExpense(call: ApplicationCall) {
        val expense = call.receive<Expenses>()

        val create = service.postExpense(expense)

        call.respond(create)
    }

    suspend fun putExpense(call: ApplicationCall) {
        val id = call.parameters["id"]?.toIntOrNull()
            ?: return call.respond(HttpStatusCode.BadRequest)
        val expense = call.receive<Expenses>()

        val update = service.putExpense(id, expense)
        call.respond(update)
    }

    suspend fun deleteExpense(call: ApplicationCall) {
        val id = call.parameters["id"]?.toIntOrNull()
            ?: return call.respond(HttpStatusCode.BadRequest)

        val expense = service.deleteExpense(id)

        call.respond(expense)
    }

    suspend fun getTotalExpense(call: ApplicationCall) {
        val expense = service.getTotalExpenses()

        call.respond(expense)
    }
}
