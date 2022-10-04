package com.rodgim.data

import com.rodgim.domain.Location

interface LocationPersistenceSource {

    fun getPersistedLocations(): List<Location>
    fun saveNewLocation(location: Location)

}
