package com.seungho.android.myapplication.lostarkclass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.seungho.android.myapplication.lostarkclass.adapter.CLASS_LIST_PAGE_INDEX
import com.seungho.android.myapplication.lostarkclass.adapter.SaveClassAdapter
import com.seungho.android.myapplication.lostarkclass.databinding.FragmentSaveclassBinding
import com.seungho.android.myapplication.lostarkclass.utills.InjectorUtils
import com.seungho.android.myapplication.lostarkclass.viewmodels.SaveClassListViewModel


class SaveClassFragment : Fragment() {

    private lateinit var binding: FragmentSaveclassBinding

    private val viewModel: SaveClassListViewModel by viewModels {
        InjectorUtils.provideSaveClassListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_saveclass, container, false)
        val adapter = SaveClassAdapter()
        binding.saveClassList.adapter = adapter

        binding.btnAddClass.setOnClickListener {
            navigateToClassListPage()
        }

        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: SaveClassAdapter, binding: FragmentSaveclassBinding) {
        viewModel.classAndSaveClasss.observe(viewLifecycleOwner) { result ->
            binding.hasClasss = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }


    private fun navigateToClassListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            CLASS_LIST_PAGE_INDEX
    }
}