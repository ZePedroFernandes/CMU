package pt.ipp.estg.tourpediaexample

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlacesAdapter(private val dataSet: List<Place>) :
    RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView = view.findViewById<TextView>(R.id.tvName)
        val idView = view.findViewById<TextView>(R.id.tvID)
        val addressView = view.findViewById<TextView>(R.id.tvAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.place_details, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place: Place = this.dataSet[position]

        holder.apply {
            nameView.text = place.name
            idView.text = place.id.toString()
            addressView.text = place.address
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}
