package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CatViewHolder>() {

    // 🟡 Delete Callback Instantiation (✨ ini bagian yang kamu maksud)
    val swipeToDeleteCallback = SwipeToDeleteCallback()

    // 🐱 Mutable list untuk menyimpan semua data kucing
    private val cats = mutableListOf<CatModel>()

    // Fungsi untuk mengganti isi list dengan data baru
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        notifyDataSetChanged()
    }

    // Fungsi untuk menghapus item saat swipe
    fun removeItem(position: Int) {
        if (position in cats.indices) {
            cats.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    // Inflate layout tiap item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view, imageLoader, onClickListener)
    }

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindData(cats[position])
    }

    // Interface klik item
    interface OnClickListener {
        fun onItemClick(cat: CatModel)
    }

    // 👇 Inner class swipe to delete
    inner class SwipeToDeleteCallback :
        ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = false

        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return if (viewHolder is CatViewHolder) {
                makeMovementFlags(
                    ItemTouchHelper.ACTION_STATE_IDLE,
                    ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
                ) or makeMovementFlags(
                    ItemTouchHelper.ACTION_STATE_SWIPE,
                    ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
                )
            } else 0
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            removeItem(position)
        }
    }
}
