package id.ac.ubaya.informatika.myapplication

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.coroutines.coroutineContext


class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnStart.setOnClickListener {
            val playerName = txtName.text.toString()
            if (playerName != ""){
                val action = MainFragmentDirections.actionGameFragment(playerName)
                Navigation.findNavController(it).navigate(action)
                txtName.setText("")
                Toast.makeText(context, "Wellcome to the game '$playerName', Good Luck!!!", Toast.LENGTH_LONG).show()
            }
            else if (playerName == "")
            {
                alertClick(view)
            }
        }
    }
    fun alertClick(view: View)
    {
        AlertDialog.Builder(context)
            .setTitle("KESALAHAN!")
            .setMessage("Nama Player Tidak Boleh Kosong!")
            .setPositiveButton("OK", DialogInterface.OnClickListener{ dialogInterface, i ->
                Toast.makeText(context, "SILAHKAN ISI NAMA PLAYER!", Toast.LENGTH_LONG).show()
            })
            .show()
    }
}