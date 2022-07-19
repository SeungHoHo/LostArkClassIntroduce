package com.seungho.android.myapplication.lostarkclass.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SaveClassDao {
    @Query("SELECT * FROM save_class")
    fun getSaveClasss(): LiveData<List<SaveClass>>

    @Query("SELECT EXISTS(SELECT 1 FROM save_class WHERE classs_id = :classId LIMIT 1)")
    fun isClassed(classId: String): LiveData<Boolean>

    @Transaction
    @Query("SELECT * FROM classes WHERE classId IN (SELECT DISTINCT(classs_id) FROM save_class)")
    fun getSavedClasss(): LiveData<List<ClassAndSaveClasss>>

    @Insert
    suspend fun insertSaveClass(saveClass: SaveClass): Long

    @Delete
    suspend fun deleteSaveClass(saveClass: SaveClass)
}