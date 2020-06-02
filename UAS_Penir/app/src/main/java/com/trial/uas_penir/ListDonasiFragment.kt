package com.trial.uas_penir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.fragment_list_donasi.*
import kotlinx.android.synthetic.main.fragment_list_donasi.view.*

/**
 * A simple [Fragment] subclass.
 */
class ListDonasiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_list_donasi, container, false)
        val listViewDonasi = view.findViewById<ListView>(R.id.listDonasi)

        val daftarDonasiUser = mutableListOf<DaftarDonasi>() // move it to somewhere
        val id = arguments?.getInt("d_id") ?: 0
        val name = arguments?.getString("d_name") ?: ""
        val sum = arguments?.getInt("d_amount") ?: 0
        //val list = arguments?.get("d_arraylist") ?: ""

        //list(DaftarDonasi(id,name,sum))
        Toast.makeText(view.context,daftarDonasiUser.size.toString(),Toast.LENGTH_LONG).show()
        val arrayAdapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, daftarDonasiUser)
        listViewDonasi.adapter = arrayAdapter
        arrayAdapter.notifyDataSetChanged()

        return view
    }

}
