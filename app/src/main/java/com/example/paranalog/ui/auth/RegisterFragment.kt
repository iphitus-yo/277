package com.example.paranalog.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.paranalog.R
import com.example.paranalog.databinding.FragmentRegisterBinding
import com.example.paranalog.ui.ViewModelFactory
import com.example.paranalog.util.CpfInputMask

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    // Corrected: Use ViewModelFactory with Application context
    private val registerViewModel: RegisterViewModel by viewModels {
        ViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Apply CPF mask - Corrected ID: cpfEditText
        binding.cpfEditText.addTextChangedListener(CpfInputMask(binding.cpfEditText))

        registerViewModel.registrationResult.observe(viewLifecycleOwner) { result ->
            // TODO: Handle loading state (show/hide progress bar)
            result.fold(
                onSuccess = {
                    Toast.makeText(requireContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    // Navigate back to login screen after successful registration
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                },
                onFailure = { error ->
                    Toast.makeText(requireContext(), "Falha no cadastro: ${error.message}", Toast.LENGTH_LONG).show()
                }
            )
        }

        // Corrected ID: registerButton
        binding.registerButton.setOnClickListener {
            // Corrected IDs for input fields
            val name = binding.nameEditText.text.toString()
            val cpf = binding.cpfEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString() // Added confirm password
            val plateCavalo = binding.plateCavaloEditText.text.toString()
            val plateCarreta = binding.plateCarretaEditText.text.toString()

            // Basic validation for password confirmation
            if (password != confirmPassword) {
                binding.confirmPasswordLayout.error = "As senhas não coincidem"
                return@setOnClickListener
            } else {
                binding.confirmPasswordLayout.error = null // Clear error
            }

            // Call register with named parameters as corrected by user
            registerViewModel.register(
                name = name,
                cpf = cpf,
                pass = password,
                confirmPass = confirmPassword, // Assuming ViewModel expects confirmPass
                plateCavalo = plateCavalo,
                plateCarreta = plateCarreta
            )
        }

        // Removed listener for non-existent buttonGoToLogin
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

