package com.example.workwithfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.workwithfragments.R
import com.example.workwithfragments.extensions.navigate
import kotlinx.android.synthetic.main.fragment_oh_shit.*

class OhShit : Fragment() {

    companion object {
        var number : Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_oh_shit, container, false)
        // Inflate the layout for this fragment
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val count = OhShitArgs.fromBundle(requireArguments()).count
        number = count
        countOhShit.text = count.toString()
        view.setOnClickListener {
            navigate(OhShitDirections.actionOhShitSelf(count + 1))
        }
    }
}