package com.seungho.android.myapplication.lostarkclass.data

class ClassRepository private constructor(private val classDao: ClassDao) {

    fun getClasses() =classDao.getClasses()

    fun getClass(classId: String) = classDao.getClass(classId)

    companion object {

        @Volatile private var instance: ClassRepository? = null

        fun getInstance(classDao: ClassDao) =
            instance ?: synchronized(this) {
                instance ?: ClassRepository(classDao).also { instance = it }
            }
    }
}