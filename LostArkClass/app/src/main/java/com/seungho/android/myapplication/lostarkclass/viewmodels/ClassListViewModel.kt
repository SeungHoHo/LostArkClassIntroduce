package com.seungho.android.myapplication.lostarkclass.viewmodels

import androidx.lifecycle.*
import com.seungho.android.myapplication.lostarkclass.data.Classs
import com.seungho.android.myapplication.lostarkclass.data.ClassRepository

class ClassListViewModel internal constructor(
    classRepository: ClassRepository,
    private val savedStateHandle : SavedStateHandle
) : ViewModel() {

    val classes: LiveData<List<Classs>> = getSavedClassZoneNumber().switchMap {
        if (it == NO_CLASS_ZONE) {
            classRepository.getClasses()
        } else {
            classRepository.getClasses()
        }
    }

    private fun getSavedClassZoneNumber(): MutableLiveData<Int> {
        return savedStateHandle.getLiveData(CLASS_ZONE_SAVED_STATE_KEY, NO_CLASS_ZONE)
    }

    companion object {
        private const val NO_CLASS_ZONE = -1
        private const val CLASS_ZONE_SAVED_STATE_KEY = "CLASS_ZONE_SAVED_STATE_KEY"
    }
}