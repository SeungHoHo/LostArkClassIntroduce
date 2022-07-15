package com.seungho.android.myapplication.lostarkclass.utills

import android.content.Context
import androidx.fragment.app.Fragment
import com.seungho.android.myapplication.lostarkclass.data.AppDatabase
import com.seungho.android.myapplication.lostarkclass.data.ClassRepository
import com.seungho.android.myapplication.lostarkclass.viewmodels.ClassDetailViewModelFactory
import com.seungho.android.myapplication.lostarkclass.viewmodels.ClassListViewModelFactory

object InjectorUtils {

    private fun getClassRepository(context: Context): ClassRepository {
        return ClassRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).classDao()
        )
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
            TODO("repository연결하기")
        )
    }



}