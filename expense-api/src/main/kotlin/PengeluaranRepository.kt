package org.example

var nextId = 0
var daftarPengeluaran = mutableListOf<Pengeluaran>()

class PengeluaranRepository {
    fun tambah(expense: Pengeluaran) {
        daftarPengeluaran.add(expense)
    }

    fun tampilkan(id: Int): Pengeluaran? {
        return daftarPengeluaran.find { it.id == id }
    }

    fun search(){
        println("=== Cari org.example.Pengeluaran Berdasarkan Kategori ===")
        print("Masukkan kategori yang dicari: ")
        var kategoriDicari = readln()

        var ditemukan = false
        var nomor = 1

        for (p in daftarPengeluaran) {
            if (p.kategori.equals(kategoriDicari, ignoreCase = true)) {
                println("$nomor. ${p.nama} - ${p.kategori} - Rp${p.jumlah}")
                nomor++
                ditemukan = true
            }
        }

        if (!ditemukan) {
            println("Tidak ada pengeluaran dengan kategori '$kategoriDicari'")
        }
    }

    fun edit(id: Int, expenseBaru: Pengeluaran): Pengeluaran {
        val index = daftarPengeluaran.indexOfFirst { it.id == id }
        daftarPengeluaran[index] = expenseBaru
        return expenseBaru
    }

    fun hapus(id : Int): Pengeluaran? {
        val index = daftarPengeluaran.indexOfFirst { it.id == id }
        return daftarPengeluaran[index] = expenseBaru
        return expenseBaru

    }

    fun total(){
        var total = daftarPengeluaran.sumOf { it.jumlah }
        println("Total pengeluaran: Rp$total")
    }
}