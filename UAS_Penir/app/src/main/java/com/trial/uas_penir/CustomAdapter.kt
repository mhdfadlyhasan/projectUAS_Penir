package com.trial.uas_penir

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text


class CustomAdapter(val thiscontext: Context, val need: ArrayList<Kebutuhan>): ArrayAdapter<Kebutuhan>(thiscontext,R.layout.card_items,need){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = thiscontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.card_items,parent, false)

        val img = v.findViewById<ImageView>(R.id.imageView)
        val title = v.findViewById<TextView>(R.id.textviewTitle)
        val description = v.findViewById<TextView>(R.id.textViewdesc)
        val jumlah = v.findViewById<TextView>(R.id.textViewjumlah)
        val progress = v.findViewById<TextView>(R.id.textViewprogress)


        if(need[position].id == 1)
        {
            img.setImageResource(R.drawable.a0)
        }
        else if(need[position].id == 2)
        {
            img.setImageResource(R.drawable.a1)
        }
        else
        {
            img.setImageResource(R.drawable.a2)
        }

        title.text = need[position].nama
        description.text = need[position].desc
        jumlah.text = "Kebutuhan : " +need[position].nilai +need[position].satuan
        progress.text = "0 / " +need[position].nilai

        return v
    }
}
