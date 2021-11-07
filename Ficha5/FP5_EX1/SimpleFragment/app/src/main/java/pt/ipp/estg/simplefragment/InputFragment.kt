package pt.ipp.estg.simplefragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [InputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputFragment : Fragment(R.layout.fragment_input) {

    private lateinit var parentContext: CommunicationProtocol

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentContext = requireContext() as CommunicationProtocol
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnClick = view.findViewById<Button>(R.id.btnClick)
        btnClick.setOnClickListener {
            val userInput = view.findViewById<EditText>(R.id.etInput).text.toString()
            parentContext.sendText(userInput)
        }
    }

}