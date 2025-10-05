package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {

        CatAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatAdapter.OnClickListener {
                override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🛠️ Setup RecyclerView
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(
                    gender = Gender.MALE,
                    breed = CatBreed.BALINESE_JAVANESE,
                    name = "Fred",
                    biography = "Silent and deadly",
                    imageUrl = "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    gender = Gender.FEMALE,
                    breed = CatBreed.EXOTIC_SHORTHAIR,
                    name = "Wilma",
                    biography = "Cuddly assassin",
                    imageUrl = "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    gender = Gender.UNKNOWN,
                    breed = CatBreed.AMERICAN_CURL,
                    name = "Curious George",
                    biography = "Award winning investigator",
                    imageUrl = "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    gender = Gender.MALE,
                    breed = CatBreed.BIRMAN,
                    name = "Snowy",
                    biography = "Loves warm blankets",
                    imageUrl = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"
                ),
                CatModel(
                    gender = Gender.FEMALE,
                    breed = CatBreed.ABYSSINIAN,
                    name = "Mimi",
                    biography = "Always curious",
                    imageUrl = "https://cdn2.thecatapi.com/images/0XYvRd7oD.png"
                ),
                CatModel(
                    gender = Gender.MALE,
                    breed = CatBreed.AMERICAN_BOBTAIL,
                    name = "Leo",
                    biography = "Tiny lion of the house",
                    imageUrl = "https://cdn2.thecatapi.com/images/hBXicehMA.jpg"
                ),
                CatModel(
                    gender = Gender.UNKNOWN,
                    breed = CatBreed.BENGAL,
                    name = "Tiger",
                    biography = "Fast and playful",
                    imageUrl = "https://cdn2.thecatapi.com/images/O3btzLlsO.jpg"
                ),
                CatModel(
                    gender = Gender.FEMALE,
                    breed = CatBreed.CHARTEUX,
                    name = "Luna",
                    biography = "Loves moonlight naps",
                    imageUrl = "https://cdn2.thecatapi.com/images/j5cVSqLer.jpg"
                ),
                CatModel(
                    gender = Gender.MALE,
                    breed = CatBreed.CYM,
                    name = "Rocky",
                    biography = "Rocks the house",
                    imageUrl = "https://cdn2.thecatapi.com/images/3bkZAjRhj.jpg"
                ),
                CatModel(
                    gender = Gender.UNKNOWN,
                    breed = CatBreed.MAINE_COON,
                    name = "Fluffy",
                    biography = "King of floof",
                    imageUrl = "https://cdn2.thecatapi.com/images/OOF09xL4N.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}
