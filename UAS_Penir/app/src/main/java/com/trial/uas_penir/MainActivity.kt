package com.trial.uas_penir

import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    companion object
    {
        val U_NAME = "u_name"
        val U_EMAIL = "u_email"
        val U_HP = "u_hp"
        val U_FROM = "u_from"
        val U_DAFTAR = "u_daftar"
    }

    var needs = ArrayList<Kebutuhan>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        //val daftarDonasiUser = ArrayList<DaftarDonasi>()// move it to somewhere

        //intent
        val nama = intent.getStringExtra(LoginActivity.U_NAME)
        val email = intent.getStringExtra(LoginActivity.U_EMAIL)
        val hp = intent.getStringExtra(LoginActivity.U_HP)

        val q = Volley.newRequestQueue(this)
        val url = "http://10.0.2.2/donasiku/kebutuhan.php"
        var sr = StringRequest(Request.Method.GET, url, Response.Listener { 
            response ->  try {
                val obj = JSONObject(response)
                val arr = obj.getJSONArray("kebutuhan")

                for(i in 0 until arr.length())
                {
                    val kebutuhan = arr.getJSONObject(i)
                    needs.add(Kebutuhan(kebutuhan.getInt("id"),
                        kebutuhan.getString("kebutuhan"),
                        kebutuhan.getString("deskripsi"),
                        kebutuhan.getString("satuan"),
                        kebutuhan.getInt("nilai")))
                }

                val arrayAdapter = CustomAdapter(this,needs)
                listItems.adapter = arrayAdapter

                //textViewdesc.text = obj.toString()

            }catch (e:JSONException)
            {
                Toast.makeText(this, e.message.toString(),Toast.LENGTH_SHORT).show()
            }
        },Response.ErrorListener { response-> Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()})

        q.add(sr)


        fabDonasi.setOnClickListener {
            var intent = Intent(this,DonasiActivity::class.java)
            intent.putExtra(U_EMAIL,email)
            intent.putExtra(U_HP,hp)
            intent.putExtra(U_FROM, "Main")
            //intent.putExtra(U_DAFTAR,daftarDonasiUser)
            startActivity(intent)
        }
    }
}
