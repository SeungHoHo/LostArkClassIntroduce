package com.seungho.android.myapplication.lostarkclass.data

class SaveClassRepository private constructor(
    private val saveClassDao: SaveClassDao
){

    suspend fun createSaveClass(classId: String) {
        val saveClass = SaveClass(classId)
        saveClassDao.insertSaveClass(saveClass)
    }

    suspend fun removeSaveClass(saveClass : SaveClass) {
        saveClassDao.deleteSaveClass(saveClass)
    }

    fun isClassed(classId: String) =
        saveClassDao.isClassed(classId)

    fun getSavedClasss() = saveClassDao.getSavedClasss()

    companion object {

        @Volatile private var instance: SaveClassRepository? = null

        fun getInstance(saveClassDao: SaveClassDao) =
            instance ?: synchronized(this) {
                instance ?: SaveClassRepository(saveClassDao).also { instance = it }
            }
    }

}