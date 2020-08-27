package com.example.tiktokclone.ui.horizontal.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tiktokclone.R
import com.example.tiktokclone.data.Movie
import com.example.tiktokclone.ui.vertical.VerticalViewModel

class PlayerFragment : Fragment() {

    private val viewModel: VerticalViewModel by activityViewModels()

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
        return inflater.inflate(R.layout.player_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.title).apply {
            text = movie?.title ?: return
        }
        view.findViewById<TextView>(R.id.movie_id).apply {
            text = movie?.movieId ?: return
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.setCanVerticalScroll(true)
    }

    override fun onPause() {
        super.onPause()
        viewModel.setCanVerticalScroll(false)
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