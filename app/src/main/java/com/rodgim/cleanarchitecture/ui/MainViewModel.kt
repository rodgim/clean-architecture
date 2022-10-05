package com.rodgim.cleanarchitecture.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodgim.usecases.GetLocations
import com.rodgim.usecases.RequestNewLocation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.rodgim.domain.Location as DomainLocation

class MainViewModel(
    private val getLocations: GetLocations,
    private val requestNewLocation: RequestNewLocation
) : ViewModel() {
    private var _locations: MutableLiveData<List<Location>> = MutableLiveData()
    val locations: LiveData<List<Location>> get() = _locations

    fun onCreate() {
        viewModelScope.launch {
            val locations = withContext(Dispatchers.IO){ getLocations() }
            _locations.value = locations.map(DomainLocation::toPresentationModel)
        }
    }

    fun newLocationClicked() {
        viewModelScope.launch {
            val locations = withContext(Dispatchers.IO){ requestNewLocation() }
            _locations.value = locations.map(DomainLocation::toPresentationModel)
        }
    }
}