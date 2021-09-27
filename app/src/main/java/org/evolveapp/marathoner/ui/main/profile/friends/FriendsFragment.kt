package org.evolveapp.marathoner.ui.main.profile.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.evolveapp.marathoner.R
import org.evolveapp.marathoner.databinding.FragmentFriendsBinding
import org.evolveapp.marathoner.utils.simulateLoadingData


class FriendsFragment : Fragment() {

    private var binding: FragmentFriendsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_friends, container, false)


        simulateLoadingData(
            shimmerLayout = binding?.shimmer,
            content = binding?.layoutFriends
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.back?.setOnClickListener { findNavController().navigateUp() }
        binding?.requests?.setOnClickListener { findNavController().navigate(R.id.friendsRequestsFragment) }
        binding?.cardSearch?.setOnClickListener { findNavController().navigate(R.id.searchFriendsFragment) }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}