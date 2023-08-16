package com.example.mytalkingshrek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private val frag1 = PetFragment()
private val frag2 = StatFragment()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFrag(frag1)
        val bottomNav = findViewById<BottomNavigationView>(R.id.NavBar)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.ic_pet->replaceFrag(frag1)
                R.id.ic_stats->replaceFrag(frag2)
            }
            true
        }

    }

    private fun replaceFrag(fragment : Fragment){
        if (fragment!=null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout,fragment)
            transaction.commit()

        }
    }
    }
