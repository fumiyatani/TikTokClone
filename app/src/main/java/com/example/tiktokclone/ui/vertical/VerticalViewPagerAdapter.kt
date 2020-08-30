package com.example.tiktokclone.ui.vertical

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tiktokclone.data.entity.Movie
import com.example.tiktokclone.ui.horizontal.HorizontalFragment

class VerticalViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private var movieList: List<Movie> = emptyList()

    override fun getItemCount(): Int {
        return  movieList.size
    }

    override fun createFragment(position: Int): Fragment {
        return HorizontalFragment.newInstance(
            movieList[position]
        )
    }

    fun setMovieList(movieList: List<Movie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }
}