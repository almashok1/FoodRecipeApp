package kz.adamant.foodrecipeapp.bindingAdapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import kz.adamant.foodrecipeapp.R

class RecipesRowBinding {
    companion object {


        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
            imageView.load(imageUrl) {
                crossfade(600)
                error(R.drawable.ic_round_image_24)
            }
        }

        @BindingAdapter("textFromInt")
        @JvmStatic
        fun setTextFromInt(textView: TextView, number: Int) {
            textView.text = number.toString()
        }

        @BindingAdapter("isVegan")
        @JvmStatic
        fun isVegan(view: View, vegan: Boolean) {
            if (vegan) {
                when(view) {
                    is TextView -> view.setTextColor(
                        ContextCompat.getColor(
                            view.context,
                            R.color.green
                        )
                    )
                    is ImageView -> view.setColorFilter(
                        ContextCompat.getColor(
                            view.context,
                            R.color.green
                        )
                    )
                }
            }
        }
    }
}