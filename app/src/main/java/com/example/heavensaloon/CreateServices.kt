package com.example.heavensaloon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.internal.bind.ObjectTypeAdapter
import java.text.DecimalFormat

class CreateServices : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_services)
        val types = resources.getStringArray(R.array.types)
        val spinner: Spinner = findViewById(R.id.spinner2)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, types
            )
            spinner.adapter = adapter

        }
        val name: EditText = findViewById(R.id.editTextName)
        val desc: EditText = findViewById(R.id.editTextDesc)
        val pricel: EditText = findViewById(R.id.editTextPrice)
        val cat: Spinner = findViewById(R.id.spinner2)
        val save: Button = findViewById(R.id.save)
        save.setOnClickListener {
            val nameOfSevice: String = name.text.toString()
            val description: String = desc.text.toString()
            val priceOfService: Number = pricel.text.toString().toInt()
            val typeOfService = spinner.selectedItem.toString()
            var datatoSave: HashMap<String, Any> = HashMap<String, Any>()

            var document = db.collection("HeavenSaloon").document(nameOfSevice)
            datatoSave.put("name", nameOfSevice)
            datatoSave.put("desc", description)
            datatoSave.put("price", priceOfService)
            datatoSave.put("type", typeOfService)
            document.set(datatoSave)

        }
    }
}
