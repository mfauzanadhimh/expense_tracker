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
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }

        //tes upload lewat intlij
        routing{
            get("/"){
                call.respondText("Hello, Expense API!")
            }
            post("/expenses"){
                val expense = call.receive<Pengeluaran>()
                    ?: return@post call.respond(HttpStatusCode.BadRequest, "Input tidak valid")
                repo.tambah(expense)
                call.respond(expense)
            }
                val id = call.parameters["id"]?.toIntOrNull()
                    ?: return@get call.respond(HttpStatusCode.BadRequest, "ID tidak valid")

                val expense = repo.tampilkan(id)
                    ?: return@get call.respond(HttpStatusCode.NotFound, "Pengeluaran tidak ditemukan")

                call.respond(expense)
            }
            put("/expenses/{id}"){


                val expenseBaru = call.receive<Pengeluaran>()

                val expenses = repo.edit(id, expenseBaru)
                    ?: return@put call.respond(HttpStatusCode.NotFound, "Pengeluaran tidak ditemukan")

                call.respond(expenses)
            }
            delete("/expenses/{id}"){
                val id = call.parameters["id"]?.toIntOrNull()
                    ?: return@delete call.respond(HttpStatusCode.BadRequest, "ID tidak valid")

                val expenses = repo.hapus(id)
                    ?: return@delete call.respond(HttpStatusCode.NotFound, "Tidak ada pengeluaran")
                call.respond(expenses)
            }
            get("/expenses/total"){
                val total_uang = repo.total()
                    ?: return@get call.respond(HttpStatusCode.NotFound, "Masih Kosong")

                call.respond(total_uang)
            }
        }
    }.start(wait = true)
}