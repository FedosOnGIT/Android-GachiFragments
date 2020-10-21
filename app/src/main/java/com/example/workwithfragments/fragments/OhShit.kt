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
import kotlinx.android.synthetic.main.fragment_oh_shit.*

class OhShit : Fragment() {
    val args: OhShitArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_oh_shit, container, false)
        val countOhShit = inflate.findViewById<TextView>(R.id.countOhShit)
        countOhShit.text = args.count.toString()
        inflate.setOnClickListener {
            val action = OhShitDirections.actionOhShitSelf(args.count + 1)
            it.findNavController().navigate(action)
        }
        return inflate
        // Inflate the layout for this fragment
    }

  /*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val count = OhShitArgs.fromBundle(requireArguments()).count
        countOhShit.text = count.toString()
        navigate(OhShitDirections.actionOhShitSelf(count + 1))
    }
*/
}