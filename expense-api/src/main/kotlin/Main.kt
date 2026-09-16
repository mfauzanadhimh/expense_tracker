package org.example

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.request.receiveText
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.request.receive

val repo = ExpenseRepository()
val service = ExpenseService(repo)
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val repository = ExpenseRepository()

    val service = ExpenseService(repository)

    val controller = ExpenseController(service)

    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }

        //tes upload lewat intlij
        routing{
            get("/expenses/{id}"){
                controller.getExpense(call)
            }

            post("/expenses"){
                controller.postExpense(call)
            }

            put("/expenses/{id}"){
                controller.putExpense(call)
            }

            delete("/expenses/{id}"){
                controller.deleteExpense(call)
            }

            get("/expenses/total"){
                controller.getTotalExpense(call)
            }
        }
    }.start(wait = true)
}