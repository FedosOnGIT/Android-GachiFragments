package com.example.workwithfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.workwithfragments.R
import com.example.workwithfragments.extensions.navigate
import kotlinx.android.synthetic.main.fragment_lets_celebrate.*

class LetsCelebrate : Fragment() {
    val args: LetsCelebrateArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_lets_celebrate, container, false)
        val countCelebrate = inflate.findViewById<TextView>(R.id.countCelebrate)
        countCelebrate.text = args.count.toString()
        inflate.setOnClickListener {
            val action = LetsCelebrateDirections.actionLetsCelebrateSelf(args.count + 1)
            it.findNavController().navigate(action)
        }
        return inflate
    }

 /*   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val count = LetsCelebrateArgs.fromBundle(requireArguments()).count
        countCelebrate.text = count.toString()
        navigate(LetsCelebrateDirections.actionLetsCelebrateSelf(count + 1))
    }*/
}