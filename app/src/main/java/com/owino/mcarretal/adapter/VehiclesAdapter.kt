package com.owino.mcarretal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.owino.mcarretal.R
import com.owino.mcarretal.database.Vehicle
import java.util.*

class VehiclesAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<VehiclesAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var vehicles = emptyList<Vehicle>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = inflater.inflate(R.layout.item_vehicle_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = vehicles[position]
        holder.nameTextView.setText(current.name)
        holder.priceTextView.setText(String.format(Locale.ENGLISH, "Ksh %.2f Per Day", current.price))
    }

    internal fun setVehicles(words: List<Vehicle>) {
        this.vehicles = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = vehicles.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.item_vehicle_name_text_view)
        val imageView: TextView = itemView.findViewById(R.id.item_vehicle_image_view)
        val priceTextView: TextView = itemView.findViewById(R.id.item_vehicle_price_text_view)
    }
}