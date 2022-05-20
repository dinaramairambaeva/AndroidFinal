package com.example.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentCountriesBinding

import com.example.finalproject.viewmodel.CountriesViewModel

class CountriesFragment : Fragment() {

    private val viewModel: CountriesViewModel by viewModels()
    private lateinit var adapter: CountriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCountriesBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        adapter = CountriesAdapter(CountriesClickListener { countryEntry ->
            val bundle = Bundle().apply {
                putSerializable("slug", countryEntry)
            }
            findNavController().navigate(
                R.id.action_countriesFragment_to_countryFragment,
                bundle
                )
        })

        viewModel.countriesList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.apply {

            binding.recyclerView.adapter = adapter

        }

        // Inflate the layout for this fragment
        return binding.root
    }

}