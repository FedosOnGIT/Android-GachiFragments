package com.example.workwithfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.workwithfragments.R
import com.example.workwithfragments.extensions.navigate
import kotlinx.android.synthetic.main.fragment_lets_celebrate.*

class LetsCelebrate : Fragment() {

    companion object {
        var number : Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lets_celebrate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val count = LetsCelebrateArgs.fromBundle(requireArguments()).count
        number = count
        countCelebrate.text = count.toString()
        view.setOnClickListener {
            navigate(LetsCelebrateDirections.actionLetsCelebrateSelf(count + 1))
        }
    }
}