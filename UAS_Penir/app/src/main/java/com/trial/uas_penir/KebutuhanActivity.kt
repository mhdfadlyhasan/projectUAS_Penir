package com.trial.uas_penir

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_kebutuhan.*
import org.json.JSONException
import org.json.JSONObject
import java.time.LocalDate

class KebutuhanActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_kebutuhan)
        val List_Donasi = list_of_donasi
        //val useremail = intent.getStringExtra(MainActivity.U_EMAIL)

        buttonSubmit.setOnClickListener {

//            val q = Volley.newRequestQueue(this)
//            val url = "http://10.0.2.2/donasiku/tambahdonasi.php"
//            val sr = object: StringRequest(Request.Method.POST,url,Response.Listener {
//
//               response -> try {
//                val obj = JSONObject(response)
//                textViewJumlahKebutuhan.text = obj.getString("hasil")
//
//               }catch(e:JSONException)
//            {
//                Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
//            }
//
//            },Response.ErrorListener { response -> textViewJumlahKebutuhan.text = response.toString() + useremail })
//            {
//                override fun getParams(): Map<String, String> {
//                    val params = HashMap<String,String>()
//                    params.put("email",useremail)
//                    return params
//                }
//            }
//
//            q.add(sr)
            var jumlah = editTextJumlah.text.toString()
            var id = spinnerKebutuhan.selectedItemPosition

            List_Donasi.add_item("barang",jumlah.toInt())//membuat entry baru di dalam list donasi

            //val daftardonasi = intent.getStringArrayListExtra(DonasiActivity.U_DAFTAR)

            Toast.makeText(this,"sukses",Toast.LENGTH_SHORT).show()

            var intent = Intent(this,DonasiActivity::class.java)
//            val fragment = ListDonasiFragment()
//            val bundle = Bundle()
//            bundle.putInt("d_id",id)
//            bundle.putString("d_name",spinnerKebutuhan.selectedItem.toString())
//            bundle.putInt("d_amount",jumlah.toInt())
//
//            fragment.arguments = bundle

            intent.putExtra(D_ID, id.toInt())
            intent.putExtra(D_NAME,spinnerKebutuhan.selectedItem.toString())
            intent.putExtra(D_AMOUNT,jumlah.toInt())
            intent.putExtra(U_FROM,1)
            //intent.putExtra(U_DAFTAR,daftardonasi)
            startActivity(intent)

        }

    }
}
