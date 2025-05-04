package com.example.paranalog.ui.auth

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.paranalog.R
import com.example.paranalog.databinding.FragmentLoginBinding
import com.example.paranalog.ui.ViewModelFactory
import com.example.paranalog.util.CpfInputMask

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    // Corrected: Use ViewModelFactory with Application context
    private val loginViewModel: LoginViewModel by viewModels {
        ViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Apply CPF mask - Corrected ID: cpfEditText
        binding.cpfEditText.addTextChangedListener(CpfInputMask(binding.cpfEditText))

        loginViewModel.loginResult.observe(viewLifecycleOwner) { result ->
            result.fold(
                onSuccess = {
                    Toast.makeText(requireContext(), "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                    // Navigate to the next screen (e.g., checklist list)
                    findNavController().navigate(R.id.action_loginFragment_to_checklistListFragment)
                },
                onFailure = { error ->
                    Toast.makeText(requireContext(), "Falha no login: ${error.message}", Toast.LENGTH_LONG).show()
                }
            )
        }

        // Corrected ID: loginButton
        binding.loginButton.setOnClickListener {
            // Corrected ID: cpfEditText
            val cpf = binding.cpfEditText.text.toString()
            // Corrected ID: passwordEditText
            val password = binding.passwordEditText.text.toString()
            loginViewModel.login(cpf, password)
        }

        // Corrected ID: registerLinkText
        binding.registerLinkText.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

