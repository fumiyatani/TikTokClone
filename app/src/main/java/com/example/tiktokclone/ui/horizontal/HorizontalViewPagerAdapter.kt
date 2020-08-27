package com.example.tiktokclone.ui.horizontal

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tiktokclone.data.DummyMovieData
import com.example.tiktokclone.data.Movie
import com.example.tiktokclone.ui.horizontal.HorizontalFragment
import com.example.tiktokclone.ui.player.PlayerFragment

class HorizontalViewPagerAdapter(
    fragment: Fragment,
    private var movie: Movie? = null)
    : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return  movie?.run { 2 } ?: 0
    }

    override fun createFragment(position: Int): Fragment {
        return movie?.run {
            when(position) {
                0 -> PlayerFragment.newInstance(aMovie.title, aMovie.movieId)
                else -> PlayerFragment.newInstance(bMovie.title, bMovie.movieId)
            }
        } ?: Fragment()
    }

    fun setMovie(movie: Movie) {
        this.movie = movie
        notifyDataSetChanged()
    }
}