package com.gb_materialdesign.ui.main.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.gb_materialdesign.R
import com.gb_materialdesign.databinding.FragmentEarthTodayBinding

class EarthTodayFragment : Fragment() {

    private var _binding: FragmentEarthTodayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEarthTodayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.earthImageToday.setImageDrawable(context?.let{
            ContextCompat.getDrawable(it, R.drawable.jupiter)
        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}