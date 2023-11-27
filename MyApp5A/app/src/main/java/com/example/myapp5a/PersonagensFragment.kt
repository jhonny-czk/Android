package com.example.myapp5a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp5a.RecyclerView.CharactersAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PersonagensFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personagens, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerCharacters)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val charactersAdapter = CharactersAdapter(getCharactersList()) // Substitua isso pela lista real de personagens
        recyclerView.adapter = charactersAdapter

        return view
    }

    private fun getCharactersList(): List<Character> {
        // Implemente a lógica para obter a lista de personagens da API
        // Retorne uma lista de objetos Character
        // Esta é uma função de exemplo, substitua com sua lógica real
        return listOf(
            Character("Mickey Mouse", R.drawable.mickey),
            Character("Minnie Mouse", R.drawable.minnie),
            Character("Donald Duck", R.drawable.donald)
            // Adicione mais personagens conforme necessário
        )
    }

    private fun Character(s: String, donald: Int): Character {
      
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PersonagensFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
