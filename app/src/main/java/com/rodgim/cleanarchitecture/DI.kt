package com.rodgim.cleanarchitecture

import com.rodgim.cleanarchitecture.framework.FakeLocationSource
import com.rodgim.cleanarchitecture.framework.InMemoryLocationPersistenceSource
import com.rodgim.cleanarchitecture.ui.MainViewModel
import com.rodgim.data.DeviceLocationSource
import com.rodgim.data.LocationPersistenceSource
import com.rodgim.data.LocationsRepository
import com.rodgim.usecases.GetLocations
import com.rodgim.usecases.RequestNewLocation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    factory { LocationsRepository(get(), get()) }
}

val useCaseModule = module {
    factory { GetLocations(get()) }
    factory { RequestNewLocation(get()) }
}

val appModule = module {
    single<LocationPersistenceSource> { InMemoryLocationPersistenceSource() }
    single<DeviceLocationSource> { FakeLocationSource() }
}

val viewModelsModule = module {
    viewModel { MainViewModel(get(), get()) }
}