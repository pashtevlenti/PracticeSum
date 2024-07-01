package ru.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.itis.summerpractice.databinding.FragmentSettingsPhoneBinding

class SettingsPhoneFragment : Fragment(R.layout.fragment_settings_phone) {

    private var binding : FragmentSettingsPhoneBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsPhoneBinding.bind(view)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding =  null
    }

}