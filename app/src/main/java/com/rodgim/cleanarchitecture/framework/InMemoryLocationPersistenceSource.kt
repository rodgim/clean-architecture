package com.rodgim.cleanarchitecture.framework

import com.rodgim.data.LocationPersistenceSource
import com.rodgim.domain.Location

class InMemoryLocationPersistenceSource : LocationPersistenceSource {

    private var locations: List<Location> = emptyList()

    override fun getPersistedLocations(): List<Location> = locations

    override fun saveNewLocation(location: Location) {
        locations += location
    }
}