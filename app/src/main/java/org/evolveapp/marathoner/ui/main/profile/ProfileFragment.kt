package org.evolveapp.marathoner.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.evolveapp.marathoner.R
import org.evolveapp.marathoner.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.settings?.setOnClickListener { findNavController().navigate(R.id.settingsFragment) }
        binding?.marathonsInvitations?.setOnClickListener { findNavController().navigate(R.id.marathonsInvitationsFragment) }
        binding?.friends?.setOnClickListener { findNavController().navigate(R.id.friendsFragment) }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}