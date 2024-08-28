package com.example.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class BookAdapter(val books: List<book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {


        class BookViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
            val image: ImageView = row.findViewById(R.id.bookImage)
            val bk_name:TextView = row.findViewById(R.id.book_name)
            val bk_author:TextView = row.findViewById(R.id.author_name)
            val ratingBar: RatingBar = row.findViewById(R.id.ratingbar)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
            val layout =
                LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
            return BookViewHolder(layout)
        }

        override fun getItemCount(): Int {
            return books.size
        }

        override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
            val book = books[position]
            holder.image.setImageResource(book.image)
            holder.bk_name.text = book.name
            holder.bk_author.text = book.author
            holder.ratingBar.rating = book.rating
        }
    }

