package com.example.heavensaloon

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.heavensaloon.ui.login.LoginActivity

class Frag1:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {

        val view:View= inflater.inflate(R.layout.frag1_layout,container,false)
        val button:Button=view.findViewById(R.id.button2)
        button.setOnClickListener { val intent= Intent(activity, CreateServices::class.java)
            activity?.startActivity(intent) }
        return view
    }




}