package com.example.tiktokclone.ui.horizontal.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tiktokclone.R
import com.example.tiktokclone.data.UserRepository
import com.example.tiktokclone.ui.VerticalScrollViewModel

class UserProfileFragment : Fragment() {

    private val verticalScrollViewModel: VerticalScrollViewModel by activityViewModels()

    private val userProfileViewModel: UserProfileViewModel by viewModels {
        UserProfileViewModelFactory(UserRepository)
    }

    private var userId: String = ""

    private lateinit var userNameTextView: TextView

    private lateinit var userIntroductionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userId = it.getString(KEY_USER_ID, "")
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
        userNameTextView = view.findViewById(R.id.name)
        userIntroductionTextView = view.findViewById(R.id.introduction)

        bindViewModel()
    }

    private fun bindViewModel() {
        userProfileViewModel.userProfile.observe(viewLifecycleOwner) {
            userNameTextView.text = it.userName
            userIntroductionTextView.text = it.userIntroduction
        }
    }

    override fun onStart() {
        super.onStart()

        userProfileViewModel.getUserProfile(userId)
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
        private const val KEY_USER_ID = "key_user_id"

        @JvmStatic
        fun newInstance(userId: String) =
            UserProfileFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_USER_ID, userId)
                }
            }
    }
}