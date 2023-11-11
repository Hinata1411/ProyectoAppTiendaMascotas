package com.aristidevs.PetParadiseTheme.ui.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.PetParadiseTheme.ui.objetos.Mascota
import com.aristidevs.darkmodeexample.R
import com.bumptech.glide.Glide


class MascotaAdapter(private val mascotas: List<Mascota>, private val onAddtoCartClickListener: (Mascota) -> Unit) :
    RecyclerView.Adapter<MascotaAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.textNombre)
        val razaTextView: TextView = itemView.findViewById(R.id.textRaza)
        val precioTextView: TextView = itemView.findViewById(R.id.textPrecio)
        val imagenImageView: ImageView = itemView.findViewById(R.id.imageView)
        val addToCartButton: ImageView = itemView.findViewById(R.id.addToCartButton)

        init {
            addToCartButton.setOnClickListener {
                val posicion = adapterPosition
                if (posicion != RecyclerView.NO_POSITION) {
                    onAddtoCartClickListener(mascotas[posicion])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mascota, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mascota = mascotas[position]
        holder.nombreTextView.text = mascota.nombre
        holder.razaTextView.text = mascota.raza
        holder.precioTextView.text = "$${mascota.precio}"
        Glide.with(holder.itemView.context)
            .load(mascota.imagen)
            .into(holder.imagenImageView)
    }

    override fun getItemCount(): Int {
        return mascotas.size
    }
}