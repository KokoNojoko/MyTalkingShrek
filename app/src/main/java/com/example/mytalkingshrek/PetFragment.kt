package com.example.mytalkingshrek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView

class PetFragment : Fragment() {

    private lateinit var frameLayout: FrameLayout
    private lateinit var button: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_pet, container, false)
        frameLayout = layout.findViewById(R.id.frameLayout)
        button = layout.findViewById(R.id.Food)
        button.setOnClickListener{
            val imageView = ImageView(requireContext())
            imageView.setImageResource(R.drawable.shrek_eating)

            val layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            imageView.layoutParams = layoutParams

            frameLayout.addView(imageView)
        }
        return layout
    }
}