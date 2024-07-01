package ru.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.itis.summerpractice.databinding.FragmentSettingsPhoneBinding
import ru.itis.summerpractice.databinding.FragmentShopBinding

class ShopFragment : Fragment(R.layout.fragment_shop) {

    private var binding : FragmentShopBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopBinding.bind(view)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding =  null
    }

}