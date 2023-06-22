package com.example.pertemuan11.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan11.model.Mahasiswa
import com.example.pertemuan11.databinding.UserListBinding

class HomeAdapter (private val dataMahasiswa : ArrayList<Mahasiswa>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder (val binding : UserListBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = UserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataMahasiswa.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNama.text = dataMahasiswa[position].nama
        holder.binding.txtNim.text = dataMahasiswa[position].nim
        holder.binding.txtTelepon.text = dataMahasiswa[position].telepon
    }

    fun setData(newData: ArrayList<Mahasiswa>) {
        dataMahasiswa.clear()
        dataMahasiswa.addAll(newData)
        notifyDataSetChanged()
    }
}