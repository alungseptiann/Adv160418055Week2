package id.ac.ubaya.informatika.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_game.view.*
import kotlin.random.Random


class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var playerName = ""

        if(arguments!=null)
        {
            playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's turn"
        }

            var rands = (0..1000).random()
            var randss = (0..1000).random()
            txtMath.text = "$rands + $randss"

            var playerScore = 0

        btnSubmit.setOnClickListener {
            var res = txtJawaban.text.toString()
            var jawab = rands + randss
            if (jawab.toString() == res)
            {
                rands = (0..1000).random()
                randss = (0..1000).random()
                txtMath.text = "$rands + $randss"
                playerScore++
//                Log.d("jawaban", res)
                Toast.makeText(context, "CONGRATS!! Jawaban Anda Benar, Score Bertambah 1", Toast.LENGTH_LONG).show()
                txtJawaban.setText("")
            }
            else if (jawab.toString() != res)
            {
                Toast.makeText(context, "YAHHH:( Jawaban Salah, Semoga Beruntung Lain Waktu!:)", Toast.LENGTH_LONG).show()
                val action = GameFragmentDirections.actionResultFragment(playerScore, playerName)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}