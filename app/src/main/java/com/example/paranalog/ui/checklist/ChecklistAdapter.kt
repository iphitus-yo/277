package com.example.paranalog.ui.checklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.paranalog.R // Import R for string resources
import com.example.paranalog.data.Checklist
import com.example.paranalog.databinding.ChecklistItemBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Added onPdfClicked lambda parameter
class ChecklistAdapter(
    private val onItemClicked: (Checklist) -> Unit,
    private val onPdfClicked: (Checklist) -> Unit
) :
    ListAdapter<Checklist, ChecklistAdapter.ChecklistViewHolder>(ChecklistDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChecklistViewHolder {
        val binding = ChecklistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Pass the onPdfClicked lambda to the ViewHolder
        return ChecklistViewHolder(binding, onPdfClicked)
    }

    override fun onBindViewHolder(holder: ChecklistViewHolder, position: Int) {
        val checklist = getItem(position)
        holder.bind(checklist)
        holder.itemView.setOnClickListener {
            onItemClicked(checklist)
        }
    }

    // ViewHolder now takes onPdfClicked lambda
    class ChecklistViewHolder(
        private val binding: ChecklistItemBinding,
        private val onPdfClicked: (Checklist) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

        fun bind(checklist: Checklist) {
            val context = binding.root.context
            // Combine plates for display
            val plateInfo = "${checklist.placaCavalo ?: "-"} / ${checklist.placaCarreta ?: "-"}"
            // Get CRT info
            val crtInfo = checklist.diDueCrtMicDta ?: "-"

            // Bind data to views using correct IDs from checklist_item.xml
            binding.itemPlateTextView.text = context.getString(R.string.plate_label_format, plateInfo) // Use string resource for format
            binding.itemCrtTextView.text = context.getString(R.string.crt_label_format, crtInfo) // Use string resource for format
            binding.itemDateTimeTextView.text = dateFormat.format(Date(checklist.timestamp))

            // Set click listener for the PDF button
            binding.buttonViewPdf.setOnClickListener {
                onPdfClicked(checklist)
            }
        }
    }
}

// Add new string resources in strings.xml:
// <string name="plate_label_format">Placas: %s</string>
// <string name="crt_label_format">CRT/DI/DUE: %s</string>

class ChecklistDiffCallback : DiffUtil.ItemCallback<Checklist>() {
    override fun areItemsTheSame(oldItem: Checklist, newItem: Checklist): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Checklist, newItem: Checklist): Boolean {
        return oldItem == newItem
    }
}

