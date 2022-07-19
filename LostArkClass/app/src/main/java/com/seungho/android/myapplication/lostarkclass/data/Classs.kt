package com.seungho.android.myapplication.lostarkclass.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classes")
data class Classs (
    @PrimaryKey @ColumnInfo(name = "classId") val classId: String,
    val className: String,
    val description: String,
    val identity: String,
    val weapon: String,
    val classImageUrl: String,
    val classLogoUrl: String,
    val youtubeThumbUrl: String,
    val youtubeUrl: String
) {

}