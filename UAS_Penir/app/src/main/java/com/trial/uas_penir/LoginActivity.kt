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
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONException
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    val daftarDonasiUser = mutableListOf<DaftarDonasi>() // move it to somewhere
    companion object
    {
        val U_NAME = "u_name"
        val U_EMAIL = "u_email"
        val U_HP = "u_hp"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        setContentView(R.layout.activity_login)

        buttonSign.setOnClickListener {
            var email = txtEmail.text.toString()
            var pass = txtPassword.text.toString()

            if(email.isEmpty() || pass.isEmpty())
            {
                Toast.makeText(this, "Fill all field",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val q = Volley.newRequestQueue(this)
                val url = "http://192.168.0.6/donasiku/login.php"

                val sr = object : StringRequest(Request.Method.POST,url,Response.Listener<String>{
                        response -> try{
                    val obj = JSONObject(response)
                    //textViewTrial.text = response
                    val arr_user = obj.getJSONArray("userdata")
                    val users = ArrayList<Users>()

                    val user_data = arr_user.getJSONObject(0)
                    users.add(Users(user_data.getString("email"),user_data.getString("nama"),user_data.getString("password"),user_data.getString("no_hp")))

                    Toast.makeText(this, "Welcome " +users[0].nama,Toast.LENGTH_SHORT).show()

                    var intent = Intent(this,MainActivity::class.java)
                    intent.putExtra(U_NAME,user_data.getString("nama"))
                    intent.putExtra(U_EMAIL,user_data.getString("email"))
                    intent.putExtra(U_HP,user_data.getString("no_hp"))
                    startActivity(intent)


                }catch(e:JSONException)
                {
                    Toast.makeText(this, "Email/Password salah",Toast.LENGTH_SHORT).show()
                }
                },Response.ErrorListener {
                    Toast.makeText(this, "Email/Password salah",Toast.LENGTH_SHORT).show()
                })
                {
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String,String>()
                        params.put("email", txtEmail.text.toString())
                        params.put("password",txtPassword.text.toString())
                        return params
                    }
                }

                q.add(sr)
            }
    }

    }
}
