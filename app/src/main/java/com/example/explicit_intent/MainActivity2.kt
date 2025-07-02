package com.example.explicit_intent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var valueUsername: TextView
    private lateinit var valueAge: TextView
    private lateinit var valueCountry: TextView
    private lateinit var valueColor: TextView
    private lateinit var valueOccupation: TextView
    private lateinit var valueHobby: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2) // your display layout file

        // Initialize views
        valueUsername = findViewById(R.id.valueUsername)
        valueAge = findViewById(R.id.valueAge)
        valueCountry = findViewById(R.id.valueCountry)
        valueColor = findViewById(R.id.valueColor)
        valueOccupation = findViewById(R.id.valueOccupation)
        valueHobby = findViewById(R.id.valueHobby)

        // Get data from Intent
        val username = intent.getStringExtra("username")
        val age = intent.getStringExtra("age")
        val country = intent.getStringExtra("country")
        val color = intent.getStringExtra("color")
        val occupation = intent.getStringExtra("occupation")
        val hobby = intent.getStringExtra("hobby")

        // Set values
        valueUsername.text = username
        valueAge.text = age
        valueCountry.text = country
        valueColor.text = color
        valueOccupation.text = occupation
        valueHobby.text = hobby
    }
}
