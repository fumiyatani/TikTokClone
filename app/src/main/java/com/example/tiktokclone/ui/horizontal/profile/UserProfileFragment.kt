package com.example.tiktokclone.ui.horizontal.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tiktokclone.R
import com.example.tiktokclone.data.UserProfile
import com.example.tiktokclone.ui.VerticalScrollViewModel

class UserProfileFragment : Fragment() {

    private val verticalScrollViewModel: VerticalScrollViewModel by activityViewModels()

    private var profile: UserProfile? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            profile = it.getSerializable(KEY_PROFILE) as? UserProfile
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.name).apply {
            text = profile?.name ?: "タイトルなし"
        }
        view.findViewById<TextView>(R.id.introduction).apply {
            text = profile?.introduction ?: "紹介文なし"
        }
    }

    /*
     * ユーザープロフィール画面が開かれた際は縦方向へのスクロールをさせないようにするために、
     * 以下のライフサイクルメソッド内でスクロール制御を行うようにする
     */
    override fun onResume() {
        super.onResume()
        verticalScrollViewModel.setCanVerticalScroll(false)
    }

    override fun onPause() {
        super.onPause()
        verticalScrollViewModel.setCanVerticalScroll(true)
    }

    companion object {
        private const val KEY_PROFILE = "key_profile"

        @JvmStatic
        fun newInstance(profile: UserProfile) =
            UserProfileFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_PROFILE, profile)
                }
            }
    }
}