package com.example.pertemuan11.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pertemuan11.R
import com.example.pertemuan11.databinding.FragmentDetailBinding
import com.example.pertemuan11.databinding.FragmentHomeBinding


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nim = arguments?.getString("nim")
        val nama = arguments?.getString("nama")
        val telepon = arguments?.getString("telepon")
        binding.txtNim.text = nim
        binding.txtNama.text = nama
        binding.txtTelepon.text = telepon
    }

}