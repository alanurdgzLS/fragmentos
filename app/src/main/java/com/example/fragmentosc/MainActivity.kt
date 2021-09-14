package com.example.fragmentosc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container, inicioFragment()).commit()
        findViewById<Button>(R.id.btnInfo).setOnClickListener{
            replaceFragment(fragmentA())
        }
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
}