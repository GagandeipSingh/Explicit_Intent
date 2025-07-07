package com.example.explicit_intent

import android.content.Intent
import android.os.Bundle
import android.os.PatternMatcher
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity4 : AppCompatActivity() {

    private lateinit var etAge: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPhone: TextInputEditText
    private lateinit var etCity: TextInputEditText
    private lateinit var rgGender: RadioGroup
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val etName = findViewById<EditText>(R.id.etName)
        val tilName = findViewById<TextInputLayout>(R.id.tilName)
        etAge = findViewById(R.id.etAge)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etCity = findViewById(R.id.etCity)
        rgGender = findViewById(R.id.rgGender)
        btnSubmit = findViewById(R.id.btnSubmit)
        val dropDown = findViewById<AutoCompleteTextView>(R.id.colorsDropDown)
        val tilDropDown = findViewById<TextInputLayout>(R.id.tilDropDown)

        val items = arrayListOf<String>()
        items.add("Red")
        items.add("Blue")
        items.add("Black")
        items.add("Brown")
        items.add("White")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,items)

        dropDown.setAdapter(adapter)

        dropDown.doOnTextChanged { _,_,_,_ ->
            tilDropDown.isErrorEnabled = false
        }

        var list = arrayListOf<String>()
        var gender = ""

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val age = etAge.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val city = etCity.text.toString().trim()
            val colour = dropDown.text.toString().trim()

            val genderId = rgGender.checkedRadioButtonId
             if (genderId != -1) {
                gender = findViewById<RadioButton>(genderId).text.toString()
            }

            if(name.isEmpty()){
                etName.error = "Enter Name.."
            }
            else if(age.isEmpty()){
                etAge.error = "Enter your Age.."
            }
            else if(email.isEmpty()){
                etEmail.error = "Enter correct Email.."
            }
            else if(phone.isEmpty()){
                etPhone.error = "Enter your Phone.."
            }
            else if(city.isEmpty()){
                etCity.error = "Enter your City.."
            }
            else if(age.isEmpty()){
                etAge.error = "Enter your Age.."
            }
            else if(genderId == -1){
                Toast.makeText(this,"Select Gender..", Toast.LENGTH_SHORT).show()
            }
            else if(colour.isEmpty()){
                tilDropDown.error = "Select Colour"
            }
            else if(list.isEmpty()){
                Toast.makeText(this,"Select Language..", Toast.LENGTH_SHORT).show()

            }
            else{
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
}