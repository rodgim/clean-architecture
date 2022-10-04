package com.rodgim.data

import com.rodgim.domain.Location

interface DeviceLocationSource {

    fun getDeviceLocation(): Location

}