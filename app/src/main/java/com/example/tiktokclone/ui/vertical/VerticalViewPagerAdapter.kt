package com.example.tiktokclone.ui.vertical

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tiktokclone.data.DummyMovieData
import com.example.tiktokclone.ui.horizontal.HorizontalFragment

class VerticalViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return  DummyMovieData.dummyDataSize
    }

    override fun createFragment(position: Int): Fragment {
        return HorizontalFragment.newInstance(
            DummyMovieData.movieData[position]
        )
    }
}