package com.example.tiktokclone.ui.horizontal.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tiktokclone.R
import com.example.tiktokclone.data.entity.Movie

class PlayerFragment : Fragment() {

    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            movie = it.getSerializable(KEY_MOVIE) as? Movie
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.title).apply {
            text = movie?.movieTitle ?: return
        }
        view.findViewById<TextView>(R.id.movie_id).apply {
            text = movie?.movieId ?: return
        }
    }

    companion object {
        @Suppress("unused")
        private const val TAG = "PlayerFragment"

        private const val KEY_MOVIE = "key_movie"

        fun newInstance(movie: Movie) =
            PlayerFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_MOVIE, movie)
                }
            }
    }
}