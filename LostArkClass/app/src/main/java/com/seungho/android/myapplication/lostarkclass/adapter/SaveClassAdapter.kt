package com.seungho.android.myapplication.lostarkclass.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.seungho.android.myapplication.lostarkclass.HomeViewPagerFragmentDirections
import com.seungho.android.myapplication.lostarkclass.R
import com.seungho.android.myapplication.lostarkclass.data.ClassAndSaveClasss
import com.seungho.android.myapplication.lostarkclass.databinding.ListItemSaveClassBinding
import com.seungho.android.myapplication.lostarkclass.viewmodels.ClassAndSaveClassViewModel

class SaveClassAdapter: ListAdapter<ClassAndSaveClasss, SaveClassAdapter.ViewHolder>(
        SaveClassDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_save_class, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ListItemSaveClassBinding
    ): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.viewModel?.classId?.let { classId ->
                    navigateToClass(classId, view)
                }
            }
        }

        private fun navigateToClass(classId: String, view: View) {
            val direction = HomeViewPagerFragmentDirections
                .actionViewPagerFragmentToPlantDetailFragment(classId)
            view.findNavController().navigate(direction)
        }

        fun bind(saving: ClassAndSaveClasss) {
            with(binding) {
                viewModel = ClassAndSaveClassViewModel(saving)
                executePendingBindings()
            }
        }
    }
}

private class SaveClassDiffCallback : DiffUtil.ItemCallback<ClassAndSaveClasss>() {
    override fun areItemsTheSame(
        oldItem: ClassAndSaveClasss,
        newItem: ClassAndSaveClasss
    ): Boolean {
        return oldItem.classs.classId == newItem.classs.classId
    }

    override fun areContentsTheSame(
        oldItem: ClassAndSaveClasss,
        newItem: ClassAndSaveClasss
    ): Boolean {
        return oldItem.classs == newItem.classs
    }

}