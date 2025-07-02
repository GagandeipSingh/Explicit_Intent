package com.example.explicit_intent

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val printBtn = findViewById<Button>(R.id.printBtn)

        printBtn.setOnClickListener {
            val checkedRadioBtnId = radioGroup.checkedRadioButtonId
            println("Edrr $checkedRadioBtnId")
            if(checkedRadioBtnId == -1){
                println("Edrr Select Krr")
                Toast.makeText(this,"Select One Option", Toast.LENGTH_LONG).show()
            } else{
                val checkedRadioBtn = findViewById<RadioButton>(checkedRadioBtnId)
                val checkedOption = checkedRadioBtn.text
                println("Edrr $checkedOption")
            }

        }

    }
}