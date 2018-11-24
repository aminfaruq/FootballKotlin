package id.co.aminfaruq.footballkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_club.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class RecycleAdapter(val context : Context, val items: List<Item>,/*Tambahkan konstruktor untuk detainya */ val listener: (Item)-> Unit) : RecyclerView.Adapter<RecycleAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder /*Klik alt enter -> constructor invocation*/{
        val view = LayoutInflater.from(context).inflate(R.layout.list_club,viewGroup,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(/*ganti variablenya agar tidak bingung*/viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(items [position], listener) /*<- panggil variable listener yang di buat di atas tadi*/
    }

    class ViewHolder (view:View): RecyclerView.ViewHolder (view){
        /*buat variable dan panggil widget yang mau di tampilkan di main activitynya*/
        val textTitle = view.txtNamaClub
        val gambar = view.imgGambarClub

        fun bindItem(item: Item, listener: (Item) -> Unit){/*tambahkan listener yang tadi sudah di buat*/
            textTitle.text=item.nama
            Glide.with(itemView.context).load(item.gambar).into(gambar)
            //membuat onclick
            itemView.onClick {
                listener(item)
            }
        }
    }

}
