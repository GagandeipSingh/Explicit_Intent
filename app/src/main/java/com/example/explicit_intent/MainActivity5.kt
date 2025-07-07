package com.example.explicit_intent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity5 : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvAge: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvCity: TextView
    private lateinit var tvGender: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        tvName = findViewById(R.id.tvName)
        tvAge = findViewById(R.id.tvAge)
        tvEmail = findViewById(R.id.tvEmail)
        tvPhone = findViewById(R.id.tvPhone)
        tvCity = findViewById(R.id.tvCity)
        tvGender = findViewById(R.id.tvGender)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val city = intent.getStringExtra("city")
        val gender = intent.getStringExtra("gender")

        if(name != null){
            tvName.text = "Name: $name"
            tvAge.text = "Age: $age"
            tvEmail.text = "Email: $email"
            tvPhone.text = "Phone: $phone"
            tvCity.text = "City: $city"
            tvGender.text = "Gender: $gender"
        }

//        val gender = intent.getStringExtra("gender")
//        tvGender.setText(gender)
//        val langList = intent.getStringArrayListExtra("langList")
//        println("Edrr2 $gender $langList")
    }
}
