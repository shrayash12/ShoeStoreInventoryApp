package com.udacity.shoestore.views.login

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginfragmentBinding
import com.udacity.shoestore.util.UserManager

class LogInFragment : Fragment() {
    private val logInViewModel: LogInViewModel by activityViewModels()
    lateinit var binding: LoginfragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

         binding = LoginfragmentBinding.inflate(layoutInflater, container, false)
            .apply {
                if (UserManager.getUserLogin(requireContext()).first.isNotEmpty()) {
                    val pair = UserManager.getUserLogin(requireContext())
                    user = User(pair.first, pair.second)
                } else {
                    user = User(logInViewModel.email, logInViewModel.password)
                }
            }
        binding.buttonLogIn.setOnClickListener { view: View ->
            if (etEmailId.text.toString().isEmpty()) {
                return@setOnClickListener
            }
            if (editTextPassword.text.toString().isEmpty()) {
                return@setOnClickListener
            }
            UserManager.saveUserLogin(
                requireActivity(),
                etEmailId.text.toString(),
                editTextPassword.text.toString()
            )
            if (UserManager.isOnBoardingCompleted(requireContext())) {
                // Navigate to welcome screen
                Navigation.findNavController(view)
                    .navigate(R.id.action_logInFragment_to_shoeListingFragment)
            } else {
                // Navigate to welcome screen
                Navigation.findNavController(view)
                    .navigate(R.id.action_logInFragment_to_welcomeFragment)
            }

        }
        return binding.root
    }

    private lateinit var etEmailId: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogIn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etEmailId = view.findViewById(R.id.etEmailId)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        buttonLogIn = view.findViewById(R.id.buttonLogIn)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            })

        binding.etEmailId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                logInViewModel.email = s.toString()

            }

        })

        binding.editTextPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                logInViewModel.password = s.toString()
            }

        })

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.log_in)
    }

    fun Activity.hideSoftKeyboard() {
        currentFocus?.let {
            val inputMethodManager =
                ContextCompat.getSystemService(this, InputMethodManager::class.java)!!
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}