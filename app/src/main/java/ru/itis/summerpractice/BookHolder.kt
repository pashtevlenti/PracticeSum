package ru.itis.summerpractice

import android.content.Context
import androidx.core.widget.doOnTextChanged
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice.databinding.ItemBookBinding


class BookHolder(
    private val binding: ItemBookBinding,
    private val glide: RequestManager,
    private val onClick: (Book) -> Unit,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(book: Book) {
        binding.run {
            nameBook.text = book.name
            nameAuthor.text = book.author + ", " + book.year + " год издания"

            glide
                .load(book.url)
//                .error(R.drawable.img_not_found)
//                .placeholder(R.drawable.img_cat) //              .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(book)
            }


            nameBook.setTextColor(context.getColor(book.getTitleColor()))
        }
    }

    private fun Book.getTitleColor(): Int = if (url.length > 120) {
        R.color.purple
    } else {
        R.color.blue
    }
}
