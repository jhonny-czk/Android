import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapp5a.FilmesFragment
import com.example.myapp5a.PerfilFragment
import com.example.myapp5a.PersonagensFragment
import com.example.myapp5a.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_personagens -> {
                    loadFragment(PersonagensFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_filmes -> {
                    loadFragment(FilmesFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_perfil -> {
                    loadFragment(PerfilFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
        // Carregar o fragmento inicial (por exemplo, PersonagensFragment)
        loadFragment(PersonagensFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
