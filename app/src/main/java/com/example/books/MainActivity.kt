package com.example.books

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.books.ui.theme.BooksTheme
import androidx.databinding.DataBindingUtil
import com.example.books.databinding.ActavityMainBinding


lateinit var binding: ActavityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActavityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        val books = mutableListOf<book>(
            book(R.drawable.solitude, "One Hundred Years of Solitude", "by Gabriel Garcia", 3.5f),
            book(R.drawable.nostra, "Tera Nostra", "by carlos Fuentes", 3f),
            book(R.drawable.angels, "Angels & Demons", "by Dan Brown", 4f),
            book(R.drawable.sword, "The Sword Thief", "by Peter", 2f),
            book(R.drawable.spirits, "Inforno", "by Dan Brown", 4.5f),
            book(R.drawable.blood, "Bloodling", "by James Rollins", 2f),
            book(R.drawable.spirits, "The House of the Spirits", "by Isabel Allende", 3f),
            book(R.drawable.humming, "The Humming", "by Luis Alberto", 3.5f),

            )
        val bookAdapter = BookAdapter(books)
        binding.rvBooks.adapter = bookAdapter

        binding.toolbar.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.notification -> {
                    Toast.makeText(this, R.string.notificationClick, Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_star -> {
                    Toast.makeText(this, R.string.reviews, Toast.LENGTH_SHORT).show()
                    binding.drawer.close()
                    true
                }
                R.id.nav_favorite -> {
                    Toast.makeText(this, R.string.favorite, Toast.LENGTH_SHORT).show()
                    binding.drawer.close()
                    true
                }
                R.id.nav_search -> {
                    Toast.makeText(this, R.string.search, Toast.LENGTH_SHORT).show()
                    binding.drawer.close()
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, R.string.profile, Toast.LENGTH_SHORT).show()
                    binding.drawer.close()
                    true
                }
                R.id.nav_setting -> {
                    Toast.makeText(this, R.string.setting, Toast.LENGTH_SHORT).show()
                    binding.drawer.close()
                    true
                }
                else->{false}

            }


        }
        binding.toolbar.topAppBar.setNavigationOnClickListener(){
            binding.drawer.open()
        }
    }
}
