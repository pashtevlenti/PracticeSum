package ru.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice.databinding.FragmentSettingsPhoneBinding
import ru.itis.summerpractice.databinding.FragmentShopBinding

class ShopFragment : Fragment(R.layout.fragment_shop) {

    private var binding : FragmentShopBinding? = null

    private var adapter: BookAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopBinding.bind(view)

        initAdapter()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding =  null
    }
    private fun initAdapter() {
        binding?.run {
            adapter = BookAdapter(
                list = BookRepository.books,
                glide = Glide.with(this@ShopFragment),
                onClick = {
                    findNavController().navigate(
                        resId = R.id.action_shopFragment_to_acceptBookFragment,
                        args = AcceptBookFragment.bundle(id = it.id)
                    )
                }
            )

            rvBook.adapter = adapter

//          по-умолчанию линерлайоутманагер строит вертикальный список
            rvBook.layoutManager = LinearLayoutManager(requireContext())


        }
    }

}