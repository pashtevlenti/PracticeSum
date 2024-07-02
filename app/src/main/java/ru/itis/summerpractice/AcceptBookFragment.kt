package ru.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.summerpractice.databinding.FragmentAcceptBookBinding
import ru.itis.summerpractice.databinding.FragmentAcceptMessageBinding
import ru.itis.summerpractice.databinding.FragmentHomeBinding

class AcceptBookFragment : Fragment(R.layout.fragment_accept_book){
    private var binding : FragmentAcceptBookBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAcceptBookBinding.bind(view)

        val book = BookRepository.books.find {
            it.id == (arguments?.getInt(ARG_ID) ?: -1)
        }


        binding?.run {
            button.setOnClickListener{
                findNavController().navigate(
                    resId = R.id.action_acceptBookFragment_to_shopFragment
                )
            }
            if (book != null){
                acceptBookFragment.text = book.description
                Glide.with(imageView.context)
                    .load(book.url)
                    .into(imageView)
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding =  null
    }
    companion object {

        private const val ARG_ID = "ARG_AD"

        fun bundle(id : Int): Bundle = Bundle().apply {
            putInt(ARG_ID, id)

        }
    }
}

