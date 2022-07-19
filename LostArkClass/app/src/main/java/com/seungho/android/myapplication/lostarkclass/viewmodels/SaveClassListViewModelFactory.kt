package com.seungho.android.myapplication.lostarkclass.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seungho.android.myapplication.lostarkclass.data.SaveClassRepository

class SaveClassListViewModelFactory(
    private val repository: SaveClassRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SaveClassListViewModel(repository) as T
    }
}