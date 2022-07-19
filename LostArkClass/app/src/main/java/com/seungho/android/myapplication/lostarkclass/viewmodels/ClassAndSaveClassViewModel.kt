package com.seungho.android.myapplication.lostarkclass.viewmodels

import com.seungho.android.myapplication.lostarkclass.data.ClassAndSaveClasss

class ClassAndSaveClassViewModel(saving: ClassAndSaveClasss) {
    private val classs = checkNotNull(saving.classs)
    private val saveClasss = saving.saveClasss[0]

    val youtubeUrl
        get() = classs.youtubeUrl
    val youtubeThumbUrl
        get() = classs.youtubeThumbUrl
    val identity
        get() = classs.identity
    val weapon
        get() = classs.weapon
    val description
        get() =  classs.description
    val imageUrl
        get() = classs.classImageUrl
    val className
        get() = classs.className
    val classId
        get() = classs.classId
}