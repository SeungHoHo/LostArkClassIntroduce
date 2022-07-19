package com.seungho.android.myapplication.lostarkclass.data

import androidx.room.Embedded
import androidx.room.Relation

data class ClassAndSaveClasss (
    @Embedded
    val classs: Classs,

    @Relation(parentColumn = "classId", entityColumn = "classs_id")
    val saveClasss: List<SaveClass> = emptyList()
)