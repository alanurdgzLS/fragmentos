package com.example.fragmentosc

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val KEY = "STATE_KEY"
    private var addDetalleFragment: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addDetalleFragment = savedInstanceState?.getBoolean(KEY, true) ?: true
        if (addDetalleFragment){
            supportFragmentManager.beginTransaction().add(R.id.container, inicioFragment()).commit()
        }
        findViewById<Button>(R.id.btnInfo).setOnClickListener{
            replaceFragment(fragmentA().apply {
                arguments = Bundle().apply {
                    putString("key", "Ventana de información")
                }
            })
            //sonido(R.raw.iphone)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putBoolean(KEY, false)
        }
        super.onSaveInstanceState(outState)
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_right,
                R.anim.slide_out_left,
                R.anim.slide_left,
                R.anim.slide_out_right)
            replace(R.id.container, fragment)
            commit()
        }
    }

    //private fun sonido(sound: Int) = MediaPlayer.create(this, sound).start()
}