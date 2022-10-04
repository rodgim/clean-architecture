package com.rodgim.usecases

import com.rodgim.data.LocationsRepository
import com.rodgim.domain.Location

class GetLocations(
    private val locationsRepository: LocationsRepository
) {

    operator fun invoke(): List<Location> = locationsRepository.getSavedLocations()

}