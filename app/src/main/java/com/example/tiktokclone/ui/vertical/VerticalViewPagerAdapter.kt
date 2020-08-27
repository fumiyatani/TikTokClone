package com.example.tiktokclone.ui.vertical

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tiktokclone.data.DummyData
import com.example.tiktokclone.ui.horizontal.HorizontalFragment

class VerticalViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return  DummyData.dummyDataSize
    }

    override fun createFragment(position: Int): Fragment {
        return HorizontalFragment.newInstance(
            DummyData.userData[position]
        )
    }
}