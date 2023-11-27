package com.example.myapp5a

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val disneyAPI = RetrofitClient.instance
        val call = disneyAPI.getCharacters(pageSize = 10, page = 1)

        call.enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                if (response.isSuccessful) {
                    val characterResponse = response.body()
                    // Faça o processamento dos dados recebidos (characterResponse.characters)
                } else {
                    // Trate o erro da chamada à API
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                // Trate a falha na chamada à API
            }
        })
    }
}
