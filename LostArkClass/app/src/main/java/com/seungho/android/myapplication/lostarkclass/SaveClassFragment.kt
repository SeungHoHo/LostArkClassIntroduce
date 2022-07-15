package com.seungho.android.myapplication.lostarkclass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.seungho.android.myapplication.lostarkclass.adapter.CLASS_LIST_PAGE_INDEX
import com.seungho.android.myapplication.lostarkclass.databinding.FragmentSaveclassBinding


class SaveClassFragment : Fragment() {

    private lateinit var binding: FragmentSaveclassBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_saveclass, container, false)

    binding.btnAddClass.setOnClickListener {
        navigateToClassListPage()
    }
//      TODO: 나중에 뷰모델 사용해서 직업 있는지 없는지 확인하는 클래스 만들기

        return binding.root
    }

    private fun navigateToClassListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            CLASS_LIST_PAGE_INDEX
    }
}