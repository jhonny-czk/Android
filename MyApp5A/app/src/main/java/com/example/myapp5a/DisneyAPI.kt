import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DisneyAPI {
    @GET("character")
    fun getCharacters(
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): Call<CharacterResponse>
}

data class Character(
    val name: String,
    val imageUrl: String,
    // Outros campos necessários
)

data class CharacterResponse(
    val characters: List<Character>
)

