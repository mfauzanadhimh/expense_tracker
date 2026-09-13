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

val repo = PengeluaranRepository()
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }

        routing{
            get("/"){
                call.respondText("Hello, Expense API!")
            }
            post("/expenses"){
                val expense = call.receive<Pengeluaran>()
                repo.tambah(expense)
                call.respond(expense)
            }
            get("/expenses/{id}"){
                val id = call.parameters["id"].toIntOrNull() ?: 0
                val expenses = repo.tampilkan(id)
                call.respond(expenses)
            }
            put("expenses/{id}"){
                val id = call.parameters["id"].toIntOrNull() ?: 0
                val expenseBaru = call.receive<Pengeluaran>()
                val expenses = repo.edit(id, expenseBaru)
                call.respond(expenses)
            }
            delete("expenses/{id}"){
                val id = call.parameters["id"].toInt()
                val expenses = repo.hapus(id)
                call.respond(expenses)
            }
        }
    }.start(wait = true)
}