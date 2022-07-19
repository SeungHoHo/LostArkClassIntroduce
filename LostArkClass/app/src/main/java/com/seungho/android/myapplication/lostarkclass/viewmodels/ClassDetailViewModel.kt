package com.seungho.android.myapplication.lostarkclass.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seungho.android.myapplication.lostarkclass.data.ClassRepository
import com.seungho.android.myapplication.lostarkclass.data.Classs
import com.seungho.android.myapplication.lostarkclass.data.SaveClassRepository
import kotlinx.coroutines.launch

class ClassDetailViewModel(
    classRepository: ClassRepository,
    private val saveClassRepository: SaveClassRepository,
    private val classId: String
) : ViewModel() {

    val isClassed = saveClassRepository.isClassed(classId)
    val classs = classRepository.getClass(classId)

    fun addClassToSave() {
        viewModelScope.launch {
            saveClassRepository.createSaveClass(classId)
        }
    }
}