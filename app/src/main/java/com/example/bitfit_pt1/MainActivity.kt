package com.example.bitfit_pt1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.bitfit_pt1.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONException

private const val TAG = "MainActivity/"


class MainActivity : AppCompatActivity() {

    private val exercises = mutableListOf<DisplayExercise>()
    private lateinit var exerciseRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        exerciseRecyclerView = findViewById(R.id.exercisesRecyclerView)
        // Set up Exercise Adapter with exercises
        val exerciseAdapter = ExerciseAdapter(this, exercises)
        exerciseRecyclerView.adapter = exerciseAdapter

        exerciseRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            exerciseRecyclerView.addItemDecoration(dividerItemDecoration)
        }




        lifecycleScope.launch {
            (application as MyApplication).db.ExerciseDao().getAll().collect() { databaseList ->
                databaseList.map { entity ->
                    DisplayExercise(
                        entity.name, entity.time, entity.calories
                    )
                }.also { mappedList ->
                    exercises.clear()
                    exercises.addAll(mappedList)
                    exerciseAdapter.notifyDataSetChanged()
                }
            }
        }



        // Add button
        val addExerciseButtonView = findViewById<Button>(R.id.addExerciseButton)
        addExerciseButtonView.setOnClickListener {

            val intent = Intent(this, AddExerciseActivity::class.java)
            startActivity(intent)

        }
    }
}