package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable list untuk menyimpan semua data kucing
    private val cats = mutableListOf<CatModel>()

    // Fungsi untuk mengganti isi list dengan data baru
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        // Beri tahu adapter bahwa datanya berubah
        notifyDataSetChanged()
    }

    // Buat ViewHolder (inflate layout untuk tiap item list)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view, imageLoader, onClickListener)
    }

    // Jumlah item dalam list
    override fun getItemCount(): Int = cats.size

    // Binding data ke tiap item tampilan
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindData(cats[position])
    }

    // 👇 Interface untuk klik item
    interface OnClickListener {
        fun onItemClick(cat: CatModel)
    }
}
