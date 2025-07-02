package com.example.explicit_intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etAge: EditText
    private lateinit var etCountry: EditText
    private lateinit var etColor: EditText
    private lateinit var etOccupation: EditText
    private lateinit var etHobby: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // your input layout file

        // Initialize views
        etUsername = findViewById(R.id.etUsername)
        etAge = findViewById(R.id.etAge)
        etCountry = findViewById(R.id.etCountry)
        etColor = findViewById(R.id.etColor)
        etOccupation = findViewById(R.id.etOccupation)
        etHobby = findViewById(R.id.etHobby)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("username", etUsername.text.toString())
                putExtra("age", etAge.text.toString())
                putExtra("country", etCountry.text.toString())
                putExtra("color", etColor.text.toString())
                putExtra("occupation", etOccupation.text.toString())
                putExtra("hobby", etHobby.text.toString())
            }
            startActivity(intent)
        }
    }
}
