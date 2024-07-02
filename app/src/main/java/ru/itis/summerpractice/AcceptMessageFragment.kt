package ru.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.RequestManager
import ru.itis.summerpractice.databinding.FragmentAcceptMessageBinding
import ru.itis.summerpractice.databinding.FragmentHomeBinding

class AcceptMessageFragment : Fragment(R.layout.fragment_accept_message){
    private var binding : FragmentAcceptMessageBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAcceptMessageBinding.bind(view)

        val email = arguments?.getString(ARG_EMAIL) ?: "ERROR"

        binding?.run {
            acceptMessageFragment.text = email
            acceptMessageFragment.textSize = 100F
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding =  null
    }
    companion object {

        private const val ARG_EMAIL = "ARG_EMAIL"

        fun bundle(email: String): Bundle = Bundle().apply {
            putString(ARG_EMAIL, email)
        }
    }
}

