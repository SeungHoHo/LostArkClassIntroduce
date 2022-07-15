package com.seungho.android.myapplication.lostarkclass.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.seungho.android.myapplication.lostarkclass.utills.DATABASE_NAME
import com.seungho.android.myapplication.lostarkclass.worker.ClassDatabaseWorker


@Database(entities = [Classs::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun classDao(): ClassDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<ClassDatabaseWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)

                    }
                })
                .build()
        }
    }
}