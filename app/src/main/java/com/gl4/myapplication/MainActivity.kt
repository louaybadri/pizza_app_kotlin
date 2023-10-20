package com.gl4.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//    private val types = listOf<String>("MAX","MEDIUM","MIN",);
//    private val ingrediants = listOf<String>("Fromage", "Champignon",);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)

//        for (type in types){
//            val typeRadio= RadioButton(this)
//            typeRadio.text=type
//            radioGroup.addView(typeRadio)
//        }


//        val layout = findViewById<LinearLayout>(R.id.linear_layout)
//        for (ingrediant in ingrediants){
//            val ingrediantCheckBox= CheckBox(this)
//            ingrediantCheckBox.text=ingrediant
//            layout.addView(ingrediantCheckBox)
//        }


    }



    fun sendEmail(view: View) {
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val fromage = findViewById<CheckBox>(R.id.fromage)
        val champignon = findViewById<CheckBox>(R.id.champignon)
        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
        val firstname= findViewById<EditText>(R.id.firstname)
        val lastname= findViewById<EditText>(R.id.lastname)
        val subject = "Pizzaaaaaaaaaaa"

        var ingredients = ""
        if(fromage.isChecked){
            ingredients += "Fromage "
        }
        if(champignon.isChecked){
            ingredients += "Champignom "
        }
        if(firstname.text.isNotEmpty() && lastname.text.isNotEmpty()){
        val message = """
            hi ${firstname.text} ${lastname.text}
            Your Pizza is set to be
            ${selectedRadioButton.text}

            And the ingrediant are
            ${ingredients}
        

        """.trimIndent()

        println(message)
        val intentEmail = Intent(Intent.ACTION_SEND,
            Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_EMAIL, "louaybadri001@gmail.com");
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
        intentEmail.putExtra(Intent.EXTRA_TEXT, message);
        intentEmail.setType("text/plain");
        startActivity(Intent.createChooser(intentEmail, "Choose an email client from..."));
        }else{
            Toast.makeText(this, "Please check all the data", Toast.LENGTH_SHORT).show()
        }
    }
}