package com.example.notetakingapp

// In your activity (e.g., MainActivity.kt)
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {

    private lateinit var sensorManager: SensorManager
    private lateinit var lightSensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the SensorManager
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        // Get the light sensor
        lightSensor
        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        abstract class SensorEventListener1() : SensorEventListener, Parcelable {
            constructor(parcel: Parcel) : this() {
            }

            override fun onSensorChanged(event: SensorEvent) {
                val lightLevel = event.values[0]
                // Store or display lightLevel
            }

            // ...
            override fun writeToParcel(parcel: Parcel, flags: Int) {

            }

            override fun describeContents(): Int {
                return 0
            }

            object CREATOR : Parcelable.Creator<SensorEventListener1> {
                override fun createFromParcel(parcel: Parcel): SensorEventListener1 {
                    return SensorEventListener1(parcel)
                }

                override fun newArray(size: Int): Array<SensorEventListener1?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }
}


    // ... (other methods)
