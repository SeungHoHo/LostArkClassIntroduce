package com.seungho.android.myapplication.lostarkclass.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.seungho.android.myapplication.lostarkclass.data.ClassAndSaveClasss
import com.seungho.android.myapplication.lostarkclass.data.SaveClassRepository

class SaveClassListViewModel internal  constructor(
    saveClassRepository: SaveClassRepository,
) : ViewModel() {
    val classAndSaveClasss: LiveData<List<ClassAndSaveClasss>> =
        saveClassRepository.getSavedClasss()
}
