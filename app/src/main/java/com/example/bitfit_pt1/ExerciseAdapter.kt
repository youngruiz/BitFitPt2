package com.example.bitfit_pt1

import android.content.Context

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.util.Log
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.text.FieldPosition

class ExerciseAdapter(
    private val context: Context,
    private val exercises: MutableList<DisplayExercise>
) :

        RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view = LayoutInflater.from(context).inflate(R.layout.item_exercise, parent, false)
                return ViewHolder(view)
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val exercise = exercises[position]
                holder.bind(exercise)
            }

            override fun getItemCount() = exercises.size

            inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
                View.OnClickListener {

                private val exerciseNameTextView = itemView.findViewById<TextView>(R.id.exerciseName)
                private val exerciseTimeTextView = itemView.findViewById<TextView>(R.id.exerciseTime)
                private val exerciseCaloriesTextView = itemView.findViewById<TextView>(R.id.exercizeCalories)

                //            private val mediaImageView = itemView.findViewById<ImageView>(R.id.mediaImage)
    //            private val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle)
    //            private val abstractTextView = itemView.findViewById<TextView>(R.id.mediaAbstract)

                init {
                    itemView.setOnClickListener(this)
                }

                // TODO: Write a helper method to help set up the onBindViewHolder method
                fun bind(exercise: DisplayExercise) {

                    exerciseNameTextView.text = exercise.name
                    exerciseTimeTextView.text = exercise.time
                    exerciseCaloriesTextView.text = exercise.calories

                    //titleTextView.text = article.headline
                    //abstractTextView.text = article.abstract

    //                Glide.with(context)
    //                    .load(article.mediaImageUrl)
    //                    .into(mediaImageView)
                }


                override fun onClick(v: View?) {
    //                // TODO: Get selected article
    //                var article = articles[absoluteAdapterPosition]
    //                Log.i("Daniel", article.headline.toString())
    //
    //                // TODO: Navigate to Details screen and pass selected article
    //                val intent = Intent(context, DetailActivity::class.java)
    //                intent.putExtra(ARTICLE_EXTRA, article)
    //                context.startActivity(intent)
                }
            }

        }