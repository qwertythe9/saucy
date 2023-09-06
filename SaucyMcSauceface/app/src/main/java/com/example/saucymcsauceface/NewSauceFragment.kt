package com.example.saucymcsauceface

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.saucymcsauceface.databinding.FragmentNewSauceBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NewSauceFragment(var sauceItem: SauceItem?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewSauceBinding
    private lateinit var sauceViewModel: SauceViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (sauceItem != null) {
            binding.sauceTitle.text = "Edit sauce"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(sauceItem!!.name)
        }
        else {
            binding.sauceTitle.text = "Add sauce"
        }

        sauceViewModel = ViewModelProvider(activity).get(SauceViewModel::class.java)
        binding.saveButton.setOnClickListener{
            saveAction()
        }
    }

    private fun saveAction() {
        val name = binding.name.text.toString()
        val source = binding.site.text.toString()
        if (sauceItem == null) {
            val newSauce = SauceItem(
                name = name,
                source = source,
                authors = listOf<String>(),
                tags = listOf<String>(),
                code = 0,
                group = "",
                complete = false)
            sauceViewModel.addSauceItem(newSauce)
        }
        else {
            sauceViewModel.updateSauceItem(
                sauceItem!!.id,
                name = name,
                source = source,
                authors = listOf<String>(),
                tags = listOf<String>(),
                code = 0,
                group = "")
        }
        binding.name.setText("")
        binding.site.setText("")
        dismiss()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewSauceBinding.inflate(inflater, container, false)
        return binding.root
    }

}