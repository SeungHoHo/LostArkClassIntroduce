package com.seungho.android.myapplication.lostarkclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.seungho.android.myapplication.lostarkclass.adapter.CLASS_LIST_PAGE_INDEX
import com.seungho.android.myapplication.lostarkclass.adapter.ClassPagerAdapter
import com.seungho.android.myapplication.lostarkclass.adapter.SAVE_CLASS_PAGE_INDEX
import com.seungho.android.myapplication.lostarkclass.databinding.FragmentViewPagerBinding

class HomeViewPagerFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = ClassPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            SAVE_CLASS_PAGE_INDEX -> R.drawable.ic_baseline_home_24
            CLASS_LIST_PAGE_INDEX -> R.drawable.ic_baseline_format_list_bulleted_24
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            SAVE_CLASS_PAGE_INDEX -> "Save Class"
            CLASS_LIST_PAGE_INDEX -> "Class List"
            else -> null
        }
    }
}