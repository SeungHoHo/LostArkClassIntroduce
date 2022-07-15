package com.seungho.android.myapplication.lostarkclass.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.seungho.android.myapplication.lostarkclass.utills.CLASS_DATA_FILE
import com.seungho.android.myapplication.lostarkclass.data.AppDatabase
import com.seungho.android.myapplication.lostarkclass.data.Classs
import kotlinx.coroutines.coroutineScope

class ClassDatabaseWorker(
    context : Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(CLASS_DATA_FILE).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val classType = object : TypeToken<List<Classs>>() {}.type
                    val classList: List<Classs> = Gson().fromJson(jsonReader, classType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.classDao().insertAll(classList)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error classing database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "ClassDatabaseWorker"
    }
}