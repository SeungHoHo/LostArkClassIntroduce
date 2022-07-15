package com.seungho.android.myapplication.lostarkclass.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ClassDao {
    @Query("SELECT * FROM classes ORDER BY classId")
    fun getClasses(): LiveData<List<Classs>>

    @Query("SELECT * FROM classes WHERE classId = :classId")
    fun getClass(classId: String): LiveData<Classs>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(classes: List<Classs>)
}