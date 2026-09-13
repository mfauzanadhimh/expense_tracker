val repo = PengeluaranRepository()

fun menu() {
    println("===== EXPENSE TRACKER =====")
    println("1. Tambah pengeluaran")
    println("2. Lihat semua")
    println("3. Cari berdasarkan kategori")
    println("4. Edit pengeluaran")
    println("5. Hapus pengeluaran")
    println("6. Total pengeluaran")
    println("0. Keluar")
}

fun tambahPengeluaran() {
    repo.tambah()
}

fun tampilkanPengeluaran() {
    repo.tampilkan()
}

fun searchPengeluaran() {
    repo.search()
}

fun editPengeluaran(){
    repo.edit()
}

fun hapusPengeluaran() {
    repo.hapus()
}

fun totalPengeluaran() {
   repo.total()
}

fun main() {
    var run = true
    while (run) {
        menu()
        print("Pilih salah satu: ")
        var pilihan = readln().toIntOrNull() ?: 0

        when (pilihan) {
            1 -> tambahPengeluaran()
            2 -> tampilkanPengeluaran()
            3 -> searchPengeluaran()
            4 -> editPengeluaran()
            5 -> hapusPengeluaran()
            6 -> totalPengeluaran()
            0 -> run = false
            else -> println("Pilih yang bener")
        }
    }
}
