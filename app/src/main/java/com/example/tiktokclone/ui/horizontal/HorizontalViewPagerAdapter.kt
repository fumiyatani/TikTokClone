package com.example.tiktokclone.ui.horizontal

import android.util.Log
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
        Log.d("crateFragment", "position : $position")
        Log.d("crateFragment", "position : ${PlayerType.values()[position]}")
        Log.d("crateFragment", "movie : ${movie?.aMovie?.title}")
        return movie?.run {
            when(PlayerType.values()[position]) {
                PlayerType.FRONT -> {
                    Log.d("Front", "PlayerFragment newInstance : FRONT, aMovie : $aMovie")
                    PlayerFragment.newInstance(PlayerType.FRONT, aMovie)
                }
                PlayerType.BACK -> PlayerFragment.newInstance(PlayerType.BACK, bMovie)
            }
        } ?: Fragment()
    }

    fun setMovie(movie: Movie) {
        this.movie = movie
        notifyDataSetChanged()
    }
}