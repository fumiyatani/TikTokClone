package com.example.tiktokclone.ui.player

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tiktokclone.R
import com.example.tiktokclone.data.MovieData
import com.example.tiktokclone.ui.horizontal.PlayerType
import com.example.tiktokclone.ui.vertical.VerticalViewModel

class PlayerFragment : Fragment() {

    private val viewModel: VerticalViewModel by activityViewModels()

    private var playerType: PlayerType = PlayerType.BACK
    private var movieData: MovieData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            playerType = it.getSerializable(KEY_PLAYER_TYPE) as PlayerType
            movieData = it.getSerializable(KEY_MOVIE_DATA) as? MovieData
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
        Log.d(TAG, "PlayerType : $playerType")
        view.findViewById<TextView>(R.id.title).apply {
            Log.d(TAG, "title : ${movieData?.title}")
            text = movieData?.title ?: return
        }
        view.findViewById<TextView>(R.id.movie_id).apply {
            Log.d(TAG, "movieId : ${movieData?.movieId}")
            text = movieData?.movieId ?: return
        }
    }

    override fun onResume() {
        super.onResume()
        when (playerType) {
            PlayerType.FRONT -> {
                viewModel.setCanVerticalScroll(true)
            }
            PlayerType.BACK -> {
                viewModel.setCanVerticalScroll(false)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        when (playerType) {
            PlayerType.FRONT -> {
                viewModel.setCanVerticalScroll(false)
            }
            PlayerType.BACK -> {
                viewModel.setCanVerticalScroll(true)
            }
        }
    }

    companion object {
        private const val TAG = "PlayerFragment"

        private const val KEY_PLAYER_TYPE = "key_player_type"
        private const val KEY_MOVIE_DATA = "key_movie_data"

        fun newInstance(playerType: PlayerType, movieData: MovieData) =
            PlayerFragment().apply {
                Log.d(TAG, "playerType : $playerType , title : ${movieData.title} , movieId : ${movieData.movieId}")
                arguments = Bundle().apply {
                    putSerializable(KEY_PLAYER_TYPE, playerType)
                    putSerializable(KEY_MOVIE_DATA, movieData)
                }
            }
    }
}