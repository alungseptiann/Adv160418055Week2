package id.ac.ubaya.informatika.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments!=null)
        {
            var playerScore = ResultFragmentArgs.fromBundle(requireArguments()).playerScore
            txtTurn.text = "$playerName's turn"
        }
        
        btnBackToMain.setOnClickListener {
            val playerScore = txtScore.text.toString()
            val action =
        }
    }
}