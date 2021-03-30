package com.example.heavensaloon

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Frag2:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.frag2_layout,container,false)
        val button: Button =view.findViewById(R.id.upload)
        button.setOnClickListener { val intent= Intent(activity, GalleryUplod::class.java)
            activity?.startActivity(intent) }
        return view
    }
}