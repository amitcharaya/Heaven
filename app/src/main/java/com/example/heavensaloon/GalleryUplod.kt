package com.example.heavensaloon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class GalleryUplod : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    val button:Button = findViewById(R.id.button)
    private val pickImage = 100
    private var imageUri: Uri? = null
    val list: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_uplod)
        getData()
        val types = resources.getStringArray(R.array.types)
        val spinner: Spinner = findViewById(R.id.spinner)
        if (spinner != null) {
            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                types
            )

            spinner.setAdapter(adapter)
        }
        button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)

        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (resultCode == RESULT_OK && requestCode == pickImage) {
                imageUri = data?.data

            }
        }


    }


    fun getData()
    {
        db.collection("HeavenSaloon")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    list.add("${document.id}")
                    Log.d("DOCUMENT", "${document.id} => ${document.data["type"]}")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DOCUMENT", "Error getting documents: ", exception)
            }
    }
}