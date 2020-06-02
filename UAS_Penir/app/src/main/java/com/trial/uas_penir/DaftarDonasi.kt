package com.trial.uas_penir

class DaftarDonasi(id: Int, barang:String, jumlah:Int) {

    var namabarang = barang
    var jumlahbarang = jumlah

    override fun toString(): String {
        return "$namabarang ($jumlahbarang)"
    }
}