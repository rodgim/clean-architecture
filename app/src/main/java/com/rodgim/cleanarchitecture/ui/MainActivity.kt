package com.rodgim.cleanarchitecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.rodgim.cleanarchitecture.R
import com.rodgim.cleanarchitecture.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val locationsAdapter = LocationsAdapter()
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = locationsAdapter
        binding.btnNewLocation.setOnClickListener {
            viewModel.newLocationClicked()
        }
        viewModel.onCreate()
        initObservers()
    }

    private fun initObservers() {
        viewModel.locations.observe(this) {
            renderLocations(it)
        }
    }

    private fun renderLocations(locations: List<Location>) {
        locationsAdapter.items = locations
    }
}