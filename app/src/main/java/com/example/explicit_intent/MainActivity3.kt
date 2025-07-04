package com.example.explicit_intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
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

        var langList = arrayListOf<String>()
        var selectedTxt = ""

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val printBtn = findViewById<Button>(R.id.printBtn)

        val chkBoxC = findViewById<CheckBox>(R.id.chkBoxC)
        val chkBoxCpp = findViewById<CheckBox>(R.id.chKBoxCpp)
        val chkBoxKotlin = findViewById<CheckBox>(R.id.chkBoxKotlin)
        val chkBoxJava = findViewById<CheckBox>(R.id.chkBoxJava)

        printBtn.setOnClickListener {
            langList = arrayListOf()
            val checkedId = radioGroup.checkedRadioButtonId
            if(checkedId == -1){
                Toast.makeText(this,"Select Any Option..", Toast.LENGTH_SHORT).show()
            } else{
                val selectedRadioBtn = findViewById<RadioButton>(checkedId)
                selectedTxt = selectedRadioBtn.text.toString()
            }

            if(chkBoxC.isChecked){
                langList.add("C")
            }
            if(chkBoxCpp.isChecked){
                langList.add("Cpp")
            }
            if(chkBoxKotlin.isChecked){
                langList.add("Kotlin")
            }
            if(chkBoxJava.isChecked){
                langList.add("Java")
            }

            println("Edrr $selectedTxt $langList")


            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("gender",selectedTxt)
            intent.putStringArrayListExtra("langList",langList)
            startActivity(intent)

        }

    }
}