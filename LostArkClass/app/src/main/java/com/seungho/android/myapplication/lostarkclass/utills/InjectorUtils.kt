package com.seungho.android.myapplication.lostarkclass.utills

import android.content.Context
import androidx.fragment.app.Fragment
import com.seungho.android.myapplication.lostarkclass.data.AppDatabase
import com.seungho.android.myapplication.lostarkclass.data.ClassRepository
import com.seungho.android.myapplication.lostarkclass.data.Classs
import com.seungho.android.myapplication.lostarkclass.data.SaveClassRepository
import com.seungho.android.myapplication.lostarkclass.viewmodels.ClassDetailViewModelFactory
import com.seungho.android.myapplication.lostarkclass.viewmodels.ClassListViewModelFactory
import com.seungho.android.myapplication.lostarkclass.viewmodels.SaveClassListViewModelFactory

object InjectorUtils {

    private fun getClassRepository(context: Context): ClassRepository {
        return ClassRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).classDao()
        )
    }

    private fun getSaveClassRepository(context: Context): SaveClassRepository {
        return SaveClassRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).saveClassDao()
        )
    }

    fun provideSaveClassListViewModelFactory(
        context: Context
    ): SaveClassListViewModelFactory {
        return SaveClassListViewModelFactory(getSaveClassRepository(context))
    }

    fun provideClassListViewModelFactory(fragment: Fragment): ClassListViewModelFactory {
        return ClassListViewModelFactory(getClassRepository(fragment.requireContext()), fragment)
    }

    fun provideClassDetailViewModelFactory(
        context: Context,
        classId: String
    ): ClassDetailViewModelFactory {
        return ClassDetailViewModelFactory(
            getClassRepository(context),
            getSaveClassRepository(context), classId
        )
    }



}