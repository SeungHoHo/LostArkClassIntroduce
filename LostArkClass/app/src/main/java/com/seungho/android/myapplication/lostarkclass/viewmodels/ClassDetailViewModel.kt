package com.seungho.android.myapplication.lostarkclass.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seungho.android.myapplication.lostarkclass.data.ClassRepository
import kotlinx.coroutines.launch

class ClassDetailViewModel(
    classRepository: ClassRepository,
    private val classId: String
) : ViewModel() {

//    val isFavoriteClass = TODO("관심있는 클래스(classs) Repository 등록하기")
    val classs = classRepository.getClass(classId)

    fun addClassToFavorite() {
        viewModelScope.launch {
//            TODO("관심있는 클래스(classs) Repository에서 classId를 기준으로 생성하기")
        }
    }

}