package com.tasks.flash.model

import com.google.gson.Gson
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VehiclesTest {
    private lateinit var json: String
    private lateinit var obj: Vehicle

    @Before
    fun setup() {
        json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"000011\",\n" +
                "  \"description\": \"Electric Scooter\",\n" +
                "  \"latitude\": 52.529077,\n" +
                "  \"longitude\": 13.416351,\n" +
                "  \"batteryLevel\": 98,\n" +
                "  \"timestamp\": \"2019-03-10T09:31:56Z\",\n" +
                "  \"price\": 15,\n" +
                "  \"priceTime\": 60,\n" +
                "  \"currency\": \"€\"\n" +
                "}"
        obj = Gson().fromJson<Vehicle>(json, Vehicle::class.java)
    }

    @Test
    fun checkNameNotEmpty() {
        Assert.assertTrue(!obj.name.isBlank())
    }

    @Test
    fun checkDescriptionNotEmpty() {
        Assert.assertTrue(!obj.description.isBlank())
    }

    @Test
    fun checkCurrencyNotEmpty() {
        Assert.assertTrue(!obj.currency.isBlank())
    }
}
