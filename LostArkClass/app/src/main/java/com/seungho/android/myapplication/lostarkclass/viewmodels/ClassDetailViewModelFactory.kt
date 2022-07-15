package com.seungho.android.myapplication.lostarkclass.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seungho.android.myapplication.lostarkclass.data.ClassRepository

class ClassDetailViewModelFactory(
    private val classRepository: ClassRepository,
//    private val favoriteClassRepository: asasas,
    private val classId: String
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ClassDetailViewModel(classRepository, favoriteRepository, classId) as T
    }

}