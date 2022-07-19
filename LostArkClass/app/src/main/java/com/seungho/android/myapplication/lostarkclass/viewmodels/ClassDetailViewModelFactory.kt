package com.seungho.android.myapplication.lostarkclass.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seungho.android.myapplication.lostarkclass.data.ClassRepository
import com.seungho.android.myapplication.lostarkclass.data.Classs
import com.seungho.android.myapplication.lostarkclass.data.SaveClassRepository

class ClassDetailViewModelFactory(
    private val classRepository: ClassRepository,
    private val saveClassRepository: SaveClassRepository,
    private val classId: String
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ClassDetailViewModel(classRepository, saveClassRepository, classId) as T
    }

}