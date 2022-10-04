package com.rodgim.data

import com.rodgim.domain.Location

class LocationsRepository(
    private val locationPersistenceSource: LocationPersistenceSource,
    private val deviceLocationSource: DeviceLocationSource
) {

    fun getSavedLocations(): List<Location> = locationPersistenceSource.getPersistedLocations()

    fun requestNewLocation(): List<Location> {
        val newLocation = deviceLocationSource.getDeviceLocation()
        locationPersistenceSource.saveNewLocation(newLocation)
        return getSavedLocations()
    }
}