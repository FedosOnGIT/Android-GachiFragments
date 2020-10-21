package com.example.workwithfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.workwithfragments.R
import com.example.workwithfragments.extensions.navigate
import kotlinx.android.synthetic.main.fragment_deep_dark.*

class DeepDark : Fragment() {
    val args: DeepDarkArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_deep_dark, container, false)
        val countDark = inflate.findViewById<TextView>(R.id.count_dark)
        countDark.text = args.count.toString()
        inflate.setOnClickListener {
            val action = DeepDarkDirections.actionDeepDarkSelf(args.count + 1)
            it.findNavController().navigate(action)
        }
        return inflate
    }

}