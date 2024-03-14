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
import androidx.lifecycle.lifecycleScope


class FirstFragment : Fragment() {

    // Access the ViewModel associated with the activity
    private val sharedViewModel: SharedViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val etFirst: EditText = view.findViewById(R.id.etFirst)
        val bTFirst: Button = view.findViewById(R.id.bTFirst)

        sharedViewModel.name.observe(viewLifecycleOwner, Observer { name ->
            etFirst.text = Editable.Factory.getInstance().newEditable(name)

        })

        bTFirst.setOnClickListener {
            sharedViewModel.saveName(etFirst.text.toString())

            // Step 3: Create an instance of the class
            val obj = (activity as MainActivity)

            // Step 4: Call the interface method through the instance
            obj.switchFragment(SecondFragment())

        }

        return view
    }


}