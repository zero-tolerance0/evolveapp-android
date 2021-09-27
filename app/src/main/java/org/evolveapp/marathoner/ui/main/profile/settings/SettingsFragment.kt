package org.evolveapp.marathoner.ui.main.profile.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.evolveapp.marathoner.R
import org.evolveapp.marathoner.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {


    private var binding: FragmentSettingsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.close?.setOnClickListener { findNavController().navigateUp() }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }


}