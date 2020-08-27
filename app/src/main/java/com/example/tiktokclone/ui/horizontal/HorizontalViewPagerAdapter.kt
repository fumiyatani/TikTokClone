package com.example.tiktokclone.ui.horizontal

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tiktokclone.data.Movie
import com.example.tiktokclone.ui.player.PlayerFragment

class HorizontalViewPagerAdapter(
    fragment: Fragment,
    private var movie: Movie? = null)
    : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return  PlayerType.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return movie?.run {
            when(PlayerType.values()[position]) {
                PlayerType.FRONT -> PlayerFragment.newInstance(PlayerType.FRONT, aMovie)
                PlayerType.BACK -> PlayerFragment.newInstance(PlayerType.BACK, bMovie)
            }
        } ?: Fragment()
    }

    fun setMovie(movie: Movie) {
        this.movie = movie
        notifyDataSetChanged()
    }
}