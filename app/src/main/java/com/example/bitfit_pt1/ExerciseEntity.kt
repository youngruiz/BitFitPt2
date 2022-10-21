package com.example.bitfit_pt1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "exercise_table")
data class ExerciseEntity(

    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "time") val time: String?,
    @ColumnInfo(name = "calories") val calories: String?,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,

//    @ColumnInfo(name = "headline") val headline: String?,
//    @ColumnInfo(name = "articleAbstract") val articleAbstract: String?,
//    @ColumnInfo(name = "byline") val byline: String?,
//    @ColumnInfo(name = "mediaImageUrl") val mediaImageUrl: String?
)

