package com.example.fragmentosc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class fragmentA : Fragment(R.layout.fragment_a) {

    private val DETAIL_KEY = "DETAIL_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(
            context,
            savedInstanceState?.getString(DETAIL_KEY, ""),
            Toast.LENGTH_LONG
        ).show()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString(DETAIL_KEY, "La pantalla giro")
        }
        super.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(context, requireArguments().getString("key", ""), Toast.LENGTH_SHORT).show()

    }

}