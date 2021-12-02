package com.example.cmu_room

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cmu_room.databinding.FragmentGasStationListItemBinding
import com.example.cmu_room.models.GasStation

class GasStationRecyclerViewAdapter(
    private val values: List<GasStation>,
    private val context: GasStationFragment.GasStationListComunication,
) : RecyclerView.Adapter<GasStationRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = FragmentGasStationListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.name.text = item.name
        holder.itemLine.setOnClickListener {
            context.goToDetails(position)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentGasStationListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.name
        val itemLine = binding.itemLine

        override fun toString(): String {
            return super.toString() + " '" + name.text + "'"
        }
    }

}