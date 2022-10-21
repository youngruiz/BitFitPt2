package com.example.bitfit_pt1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AddExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_exercise)

        val submitButton = findViewById<Button>(R.id.SubmitButton)

        submitButton.setOnClickListener {

            var name = findViewById<EditText>(R.id.exerciseNameEt).text.toString()
            var time = findViewById<EditText>(R.id.exerciseDurationEt).text.toString()
            var calories = findViewById<EditText>(R.id.exerciseCaloriesEt).text.toString()

            // Save this exersize to the database.
            lifecycleScope.launch(IO) {
                (application as MyApplication).db.ExerciseDao().insert(
                    ExerciseEntity(name, time, calories)
                )
            }

            var nameEt: TextView
            nameEt = findViewById(R.id.exerciseNameEt)
            nameEt.text = ""

            var durationEt: TextView
            durationEt = findViewById(R.id.exerciseDurationEt)
            durationEt.text = ""

            var caloriesEt: TextView
            caloriesEt = findViewById(R.id.exerciseCaloriesEt)
            caloriesEt.text = ""



            // To close keyboard.
            val view = currentFocus
            if (view != null) {
                view.clearFocus()
                val inputMethodManager =
                    getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(
                    view.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)






        }


    }



}
