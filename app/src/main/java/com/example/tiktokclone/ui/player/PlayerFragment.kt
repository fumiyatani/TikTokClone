package com.example.tiktokclone.ui.player

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tiktokclone.R

class PlayerFragment : Fragment() {

    private var title = ""
    private var movieId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            title = it.getString(KEY_TITLE, "")
            movieId = it.getString(KEY_MOVIE_ID, "")
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
            text = title
        }
        view.findViewById<TextView>(R.id.movie_id).apply {
            text = movieId
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: $title $movieId")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: $title $movieId")
    }

    companion object {
        private const val TAG = "PlayerFragment"

        private const val KEY_TITLE = "key_title"
        private const val KEY_MOVIE_ID = "key_movie_id"

        fun newInstance(title: String, movieId: String) =
            PlayerFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_TITLE, title)
                    putString(KEY_MOVIE_ID, movieId)
                }
            }
    }
}