package com.example.numbergameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast.LENGTH_SHORT
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_INDEFINITE
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var main : ConstraintLayout
    lateinit var submitButton: Button
    lateinit var inputText: EditText

    val  random = Random.nextInt(0,10)
    var myNumbers = ArrayList<String>()
    var trys = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main = findViewById(R.id.clMain)
        submitButton = findViewById(R.id.btSubmit)
        inputText = findViewById(R.id.textInput)

        submitButton.setOnClickListener {
            addNumbers()

        }
    }
fun calcylate(){while (trys != 3){
                addNumbers()
    if (trys==0){break
    submitButton.isEnabled = false}
            }}

    fun addNumbers() {

        try {
            val input = inputText.text.toString()
            myNumbers.add("You guessed $input")

                if (input.toInt() == random){
                    myNumbers.add("You have guessed correctly")

                    Snackbar.make(main,"correct! congrats", LENGTH_LONG).show()
submitButton.isEnabled=false
                }else{
                    //myNumbers.add(random.toString())
                    myNumbers.add("You have ${trys} guesses left")
                    Snackbar.make(main,"wrong guess, try again", LENGTH_LONG).show()
trys--
                }

//trys++
           //submitButton.isEnabled = false

        }catch(e: Exception) {
            print(e)
        }
inputText.text.clear()

        val myREcycle = findViewById<RecyclerView>(R.id.rvMain)
        myREcycle.adapter = RVAdapter(myNumbers)
        myREcycle.layoutManager = LinearLayoutManager(this)
    }
}