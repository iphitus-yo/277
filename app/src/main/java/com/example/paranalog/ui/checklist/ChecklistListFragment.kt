package com.example.paranalog.ui.checklist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log // Added import for Log
import android.view.* // Import Menu related classes
import android.widget.Toast
import androidx.appcompat.widget.SearchView // Import SearchView
import androidx.core.content.FileProvider
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider // Import MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle // Import Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paranalog.R
import com.example.paranalog.data.Checklist
import com.example.paranalog.databinding.FragmentChecklistListBinding
import com.example.paranalog.ui.ViewModelFactory
import java.io.File

class ChecklistListFragment : Fragment() {

    private var _binding: FragmentChecklistListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ChecklistListViewModel by viewModels {
        ViewModelFactory(requireActivity().application)
    }

    private lateinit var adapter: ChecklistAdapter
    private var currentList: List<Checklist> = emptyList() // Store the full list

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChecklistListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        setupClickListeners()
        setupSearch() // Changed from setupMenu to setupSearch for clarity
    }

    private fun setupRecyclerView() {
        adapter = ChecklistAdapter(
            onItemClicked = { checklist ->
                // Handle item click - maybe navigate to a detail view later?
                // For now, maybe just show a toast or log
                Log.d("ChecklistList", "Clicked on checklist ID: ${checklist.id}")
            },
            onPdfClicked = { checklist ->
                openPdf(checklist)
            }
        )
        // Corrected RecyclerView ID
        binding.checklistRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.checklistRecyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.checklists.observe(viewLifecycleOwner) { checklists ->
            currentList = checklists ?: emptyList() // Store the full list
            // Use correct binding ID for SearchView
            filterList(binding.searchView.query.toString()) // Apply current filter

            if (currentList.isEmpty()) {
                binding.emptyListMessage.visibility = View.VISIBLE
                binding.checklistRecyclerView.visibility = View.GONE
            } else {
                binding.emptyListMessage.visibility = View.GONE
                binding.checklistRecyclerView.visibility = View.VISIBLE
            }
        }
    }

    private fun setupClickListeners() {
        val navigateToFormAction = R.id.action_checklistListFragment_to_checklistFormFragment

        binding.fabAddChecklist.setOnClickListener {
            findNavController().navigate(navigateToFormAction)
        }

        binding.buttonCreateChecklist.setOnClickListener {
            findNavController().navigate(navigateToFormAction)
        }
    }

    // Function to setup the search view listener
    private fun setupSearch() {
        // Use correct binding ID for SearchView
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterList(query)
                return false // Let the SearchView handle submit if needed
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    // Function to filter the list based on query
    private fun filterList(query: String?) {
        val filteredList = if (query.isNullOrBlank()) {
            currentList
        } else {
            val lowerCaseQuery = query.lowercase()
            currentList.filter {
                it.placaCavalo?.lowercase()?.contains(lowerCaseQuery) == true ||
                it.placaCarreta?.lowercase()?.contains(lowerCaseQuery) == true ||
                it.diDueCrtMicDta?.lowercase()?.contains(lowerCaseQuery) == true
            }
        }
        adapter.submitList(filteredList)
        // Show/hide empty message based on filtered list
        binding.emptyListMessage.visibility = if (filteredList.isEmpty() && currentList.isNotEmpty()) View.VISIBLE else View.GONE
        binding.checklistRecyclerView.visibility = if (filteredList.isEmpty()) View.GONE else View.VISIBLE

    }


    private fun openPdf(checklist: Checklist) {
        val pdfPath = checklist.pdfPath
        if (pdfPath.isNullOrBlank()) {
            Toast.makeText(requireContext(), "PDF ainda não gerado ou caminho inválido.", Toast.LENGTH_SHORT).show()
            return
        }

        val file = File(pdfPath)
        if (!file.exists()) {
            Toast.makeText(requireContext(), "Arquivo PDF não encontrado.", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val uri: Uri = FileProvider.getUriForFile(
                requireContext(),
                "${requireContext().packageName}.provider",
                file
            )

            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, "application/pdf")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY) // Optional: don't keep PDF viewer in back stack
            }

            val chooser = Intent.createChooser(intent, "Abrir PDF com...")
            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(chooser)
            } else {
                Toast.makeText(requireContext(), "Nenhum aplicativo encontrado para abrir PDF.", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Log.e("ChecklistListFragment", "Erro ao abrir PDF: ${e.message}", e)
            Toast.makeText(requireContext(), "Erro ao abrir PDF: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

