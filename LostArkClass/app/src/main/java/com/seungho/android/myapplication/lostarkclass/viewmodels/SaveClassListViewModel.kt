package com.seungho.android.myapplication.lostarkclass.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seungho.android.myapplication.lostarkclass.data.ClassAndSaveClasss
import com.seungho.android.myapplication.lostarkclass.data.SaveClassRepository
import kotlinx.coroutines.launch

class SaveClassListViewModel internal  constructor(
    saveClassRepository: SaveClassRepository
) : ViewModel() {
    val classAndSaveClasss: LiveData<List<ClassAndSaveClasss>> =
        saveClassRepository.getSavedClasss()
}