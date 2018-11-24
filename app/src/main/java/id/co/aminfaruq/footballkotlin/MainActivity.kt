package id.co.aminfaruq.footballkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    val items : MutableList<Item> = mutableListOf()/*Gunanya untuk bisa mengubah ubah datanya*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nama = resources.getStringArray(R.array.club_name)
        val detail = resources.getStringArray(R.array.club_detail)
        val gambar = resources.obtainTypedArray(R.array.club_image)

        for (i in nama.indices){
            items.add(Item(nama[i], detail[i], gambar.getResourceId(i, 0)))
        }

        myRecycleview.layoutManager = LinearLayoutManager(this)
        myRecycleview.adapter = RecycleAdapter(this, items){
            //membuat perpindahan
            startActivity<DetailActivity>("namaClub" to it.nama, "detailClub" to it.detail,"gambarClub" to it.gambar )
        }
    }
}
