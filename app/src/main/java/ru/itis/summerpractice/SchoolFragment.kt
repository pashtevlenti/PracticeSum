package ru.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice.R
import ru.itis.summerpractice.databinding.FragmentSchoolBinding
import ru.itis.summerpractice.databinding.FragmentSettingsPhoneBinding
import ru.itis.summerpractice.databinding.FragmentShopBinding

class SchoolFragment : Fragment(R.layout.fragment_school) {

    private var binding : FragmentSchoolBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSchoolBinding.bind(view)

        binding?.run {
            var flag = false
            button.setOnClickListener {
                etEmail?.doOnTextChanged { t, start, before, count ->
                    t?.let {
                        flag = t.matches("^[A-Za-z0-9 ]+\$".toRegex())
                    }
                }
                if (flag) {
                    findNavController().navigate(
                        resId = R.id.action_schoolFragment_to_acceptMessageFragment,
                        args = AcceptMessageFragment.bundle(
                            email = etEmail.text.toString(),
                        )
                    )
                }
                else Snackbar.make(root, "Для отправки текста следует заполнить поле: ", Snackbar.LENGTH_LONG).show()

                // findNavController - получаем контроллер для работы с навигацией
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



}