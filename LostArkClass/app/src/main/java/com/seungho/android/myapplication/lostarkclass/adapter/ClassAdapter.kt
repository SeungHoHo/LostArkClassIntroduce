package com.seungho.android.myapplication.lostarkclass.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.seungho.android.myapplication.lostarkclass.HomeViewPagerFragment
import com.seungho.android.myapplication.lostarkclass.HomeViewPagerFragmentDirections
import com.seungho.android.myapplication.lostarkclass.data.Classs
import com.seungho.android.myapplication.lostarkclass.databinding.ListItemClassBinding

class ClassAdapter : ListAdapter<Classs, RecyclerView.ViewHolder>(ClassDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ClassViewHolder(
            ListItemClassBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val classs = getItem(position)
        (holder as ClassViewHolder).bind(classs)
    }

    class ClassViewHolder(
        private val binding: ListItemClassBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.classs?.let { classs ->
                    navigateToClass(classs, it)
                }
            }
        }

        private fun navigateToClass(
            classs: Classs,
            view: View
        ) {
            val direction =
                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(
                    classs.classId
                )
            view.findNavController().navigate(direction)
        }

        fun bind(item: Classs) {
            binding.apply {
                classs = item
                executePendingBindings()
            }
        }
    }

}

private class ClassDiffCallback : DiffUtil.ItemCallback<Classs>() {
    override fun areItemsTheSame(oldItem: Classs, newItem: Classs): Boolean {
        return oldItem.classId == newItem.classId
    }

    override fun areContentsTheSame(oldItem: Classs, newItem: Classs): Boolean {
        return oldItem == newItem
    }

}