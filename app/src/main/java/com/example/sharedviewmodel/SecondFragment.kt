package com.example.sharedviewmodel

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer


class SecondFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val etSecond: EditText = view.findViewById(R.id.etSecond)
        val bTSecond: Button = view.findViewById(R.id.bTSecond)


        sharedViewModel.name.observe(viewLifecycleOwner, Observer { name ->
            etSecond.text = Editable.Factory.getInstance().newEditable(name)
        })

        bTSecond.setOnClickListener {
            sharedViewModel.saveName(etSecond.text.toString())

            // Step 3: Create an instance of the class
            val obj = (activity as MainActivity)

            // Step 4: Call the interface method through the instance
            obj.switchFragment(FirstFragment())

        }


        return view
    }


}