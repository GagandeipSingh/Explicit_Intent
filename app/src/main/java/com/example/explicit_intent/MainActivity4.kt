package com.example.explicit_intent

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity4 : AppCompatActivity() {

    private lateinit var etName: TextInputEditText
    private lateinit var etAge: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPhone: TextInputEditText
    private lateinit var etCity: TextInputEditText
    private lateinit var rgGender: RadioGroup
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etCity = findViewById(R.id.etCity)
        rgGender = findViewById(R.id.rgGender)
        btnSubmit = findViewById(R.id.btnSubmit)
        val dropDown = findViewById<AutoCompleteTextView>(R.id.colorsDropDown)

        val items = arrayListOf<String>()
        items.add("Red")
        items.add("Blue")
        items.add("Black")
        items.add("Brown")
        items.add("White")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,items)

        dropDown.setAdapter(adapter)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val age = etAge.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val city = etCity.text.toString().trim()
            val colour = dropDown.text.toString().trim()

            val genderId = rgGender.checkedRadioButtonId
            val gender = if (genderId != -1) {
                findViewById<RadioButton>(genderId).text.toString()
            } else {
                "Not Specified"
            }

            // Optional: Validate inputs here

            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("email", email)
            intent.putExtra("phone", phone)
            intent.putExtra("city", city)
            intent.putExtra("gender", gender)
            startActivity(intent)
        }
    }
}