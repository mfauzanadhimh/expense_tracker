package org.example

import kotlinx.serialization.Serializable

@Serializable
data class Pengeluaran(
    var id: Int,
    var nama: String,
    var kategori: String,
    var jumlah : Int,
    var tanggal: String
//    LocalDateTime = LocalDateTime.now()
)

