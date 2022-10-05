package com.rodgim.cleanarchitecture.framework

import com.rodgim.data.DeviceLocationSource
import com.rodgim.domain.Location
import java.util.Date
import kotlin.random.Random

class FakeLocationSource : DeviceLocationSource {

    private val random = Random(System.currentTimeMillis())

    override fun getDeviceLocation(): Location =
        Location(random.nextDouble() * 180 - 90, random.nextDouble() * 36- - 180, Date())
}