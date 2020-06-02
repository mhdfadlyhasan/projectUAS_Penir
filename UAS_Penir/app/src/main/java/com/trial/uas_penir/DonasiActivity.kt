package com.trial.uas_penir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_donasi.*

class DonasiActivity : AppCompatActivity() {

    companion object
    {
        val U_NAME = "u_name"
        val U_EMAIL = "u_email"
        val U_HP = "u_hp"
        val U_FROM = "u_from"
        val U_DAFTAR = "u_daftar"

        val D_ID = "d_id"
        val D_NAME = "d_name"
        val D_AMOUNT = "d_amount"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_donasi)

        if(intent.getIntExtra(KebutuhanActivity.U_FROM,1000) == 1)
        {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment = ListDonasiFragment()

            val idselected = intent.getIntExtra(KebutuhanActivity.D_ID,1000)
            val nameselected = intent.getStringExtra(KebutuhanActivity.D_NAME)
            val jumlah = intent.getIntExtra(KebutuhanActivity.D_AMOUNT,10000)
            //val daftardonasikeb = intent.getStringArrayListExtra(KebutuhanActivity.U_DAFTAR)

            val bundle = Bundle()
            bundle.putInt("d_id",idselected+1)
            bundle.putString("d_name",nameselected)
            bundle.putInt("d_amount",jumlah)
            //bundle.putStringArrayList("d_arraylist",daftardonasikeb)

            fragment.arguments = bundle

            transaction.add(R.id.container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        val email = intent.getStringExtra(MainActivity.U_EMAIL)
        val hp = intent.getStringExtra(MainActivity.U_HP)
        //val daftardonasi = intent.getStringArrayListExtra(MainActivity.U_DAFTAR)

        fabDonasiAct.setOnClickListener {
            var intent = Intent(this,KebutuhanActivity::class.java)
            intent.putExtra(U_EMAIL,email)
            intent.putExtra(U_HP,hp)
            //intent.putExtra(U_DAFTAR,daftardonasi)
            startActivity(intent)
        }
    }
}
