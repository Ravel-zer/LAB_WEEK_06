package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender


private val FEMALE_SYMBOL = "\u2640"
private val MALE_SYMBOL = "\u2642"
private const val UNKNOWN_SYMBOL = "?"


class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener
) : RecyclerView.ViewHolder(containerView) {

    private val catPhotoView: ImageView by lazy { containerView.findViewById(R.id.cat_image) }
    private val catNameView: TextView by lazy { containerView.findViewById(R.id.cat_name) }
    private val catBreedView: TextView by lazy { containerView.findViewById(R.id.cat_breed) }
    private val catBiographyView: TextView by lazy { containerView.findViewById(R.id.cat_bio) }

    fun bindData(cat: CatModel) {

        containerView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }

        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name

        catBreedView.text = when (cat.breed) {
            CatBreed.AMERICAN_CURL -> "American Curl"
            CatBreed.BALINESE_JAVANESE -> "Balinese-Javanese"
            CatBreed.EXOTIC_SHORTHAIR -> "Exotic Shorthair"
            CatBreed.BIRMAN -> "Birman"
            CatBreed.ABYSSINIAN -> "Abyssinian"
            CatBreed.AMERICAN_BOBTAIL -> "American Bobtail"
            CatBreed.BENGAL -> "Bengal"
            CatBreed.CHARTEUX -> "Charteux"
            CatBreed.CYM -> "Cymric"
            CatBreed.MAINE_COON -> "Maine Coon"
            else -> "Unknown"
        }

        catBiographyView.text = cat.biography
    }
}
