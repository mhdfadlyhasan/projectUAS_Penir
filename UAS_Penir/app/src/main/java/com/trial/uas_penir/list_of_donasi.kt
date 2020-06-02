package com.trial.uas_penir
//object kelas singleton!
//https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e
//https://medium.com/swlh/singleton-class-in-kotlin-c3398e7fd76b
//https://kotlinlang.org/docs/tutorials/kotlin-for-py/objects-and-companion-objects.html
object list_of_donasi {
    val list_donasi = mutableListOf<DaftarDonasi>()

    init {
        android.util.Log.d("List Donation","list of donations created!")
    }
    public fun add_item(barang:String, jumlah:Int) {
        this.list_donasi.add(DaftarDonasi(1,barang, jumlah))//idnya masih random gomen!
    }

    public fun get_list(): MutableList<DaftarDonasi>
    {
        return this.list_donasi
    }
}