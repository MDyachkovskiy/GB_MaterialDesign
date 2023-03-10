package com.gb_materialdesign.ui.main.mars

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.gb_materialdesign.R
import com.gb_materialdesign.databinding.FragmentMarsPictureBinding
import com.gb_materialdesign.model.marsPicture.Photo

class MarsPictureFragment : Fragment() {

    private var _binding: FragmentMarsPictureBinding? = null
    private val binding get() = _binding!!

    private lateinit var marsPicture: Photo

    companion object {
        fun newInstance (marsPicture: Photo) : MarsPictureFragment {
            val fragment = MarsPictureFragment()
            fragment.arguments = Bundle().apply{
                putParcelable("marsPicture", marsPicture)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        marsPicture = arguments?.getParcelable("marsPicture")?: Photo()
        displayPicture(marsPicture)
    }

    private fun displayPicture (marsPicture: Photo) {

        with(binding) {

            roverName.text = marsPicture.rover.name
            roverCamera.text = marsPicture.camera.fullName
            earthDate.text = marsPicture.earthDate
            marsDate.text = marsPicture.sol.toString()

            val options = RequestOptions()
                .error(R.drawable.ic_load_error_vector)
                .placeholder(R.drawable.ic_no_photo_vector)

            activity?.let{
                Glide.with(it)
                    .load(marsPicture.imgSrc)
                    .apply(options)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            progressBar.visibility = View.GONE
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            progressBar.visibility = View.GONE
                            return false
                        }
                    })
                    .into(binding.marsPicture)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}