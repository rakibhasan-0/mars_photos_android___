package com.example.datafrominternet

import PhotosView
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.datafrominternet.R

class MainActivity : AppCompatActivity() {

    // Define the TAG constant for Logcat
    private val TAG = "Mello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate: started")

        setContentView(R.layout.activity_main)

        // If this is the first creation of the activity
        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate: first time creation. Adding fragment.")

            // Create a new instance of PhotosView fragment
            val fragment = PhotosView()

            // Use FragmentManager and FragmentTransaction to add the fragment to the 'fragment_container'
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.add(R.id.fragment_container, fragment)
            fragmentTransaction.commit()

            Log.d(TAG, "onCreate: fragment transaction committed")
        } else {
            Log.d(TAG, "onCreate: activity recreated from savedInstanceState.")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: called")
    }
}
