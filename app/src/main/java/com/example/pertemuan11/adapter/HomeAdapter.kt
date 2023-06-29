package com.example.pertemuan11.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan11.R
import com.example.pertemuan11.model.Mahasiswa
import com.example.pertemuan11.databinding.UserListBinding
import com.google.firebase.database.FirebaseDatabase

class HomeAdapter (private val dataMahasiswa : ArrayList<Mahasiswa>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder (val binding : UserListBinding) : RecyclerView.ViewHolder(binding.root)
    private val databaseRef = FirebaseDatabase.getInstance().getReference("mahasiswa")
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

        holder.binding.cardView.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("id", dataMahasiswa[position].id)
            bundle.putString("nama", dataMahasiswa[position].nama)
            bundle.putString("nim", dataMahasiswa[position].nim)
            bundle.putString("telepon", dataMahasiswa[position].telepon)

            findNavController(it).navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
        holder.binding.btnDellete.setOnClickListener {
            val mhsId = dataMahasiswa[position].id
            databaseRef.child(mhsId).removeValue()
            Toast.makeText(it.context, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
        }
        holder.binding.btnEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("id", dataMahasiswa[position].id)
            bundle.putString("nim", dataMahasiswa[position].nim)
            bundle.putString("nama", dataMahasiswa[position].nama)
            bundle.putString("telepon", dataMahasiswa[position].telepon)
            findNavController(it).navigate(R.id.action_homeFragment_to_updateFragment, bundle)
        }
    }

    fun setData(newData: ArrayList<Mahasiswa>) {
        dataMahasiswa.clear()
        dataMahasiswa.addAll(newData)
        notifyDataSetChanged()
    }
}