package com.seungho.android.myapplication.lostarkclass.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.seungho.android.myapplication.lostarkclass.ClassListFragment
import com.seungho.android.myapplication.lostarkclass.SaveClassFragment

const val SAVE_CLASS_PAGE_INDEX = 0
const val CLASS_LIST_PAGE_INDEX = 1

class ClassPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        SAVE_CLASS_PAGE_INDEX to { SaveClassFragment() },
        CLASS_LIST_PAGE_INDEX to { ClassListFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}