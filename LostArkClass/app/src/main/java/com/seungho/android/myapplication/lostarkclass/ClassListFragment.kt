package com.seungho.android.myapplication.lostarkclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.seungho.android.myapplication.lostarkclass.adapter.ClassAdapter
import com.seungho.android.myapplication.lostarkclass.databinding.FragmentClasslistBinding
import com.seungho.android.myapplication.lostarkclass.utills.InjectorUtils
import com.seungho.android.myapplication.lostarkclass.viewmodels.ClassListViewModel

class ClassListFragment : Fragment() {

    private val viewModel: ClassListViewModel by viewModels {
        InjectorUtils.provideClassListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentClasslistBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = ClassAdapter()
        binding.classList.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: ClassAdapter) {
        viewModel.classes.observe(viewLifecycleOwner) { classes ->
            adapter.submitList(classes)
        }
    }
}