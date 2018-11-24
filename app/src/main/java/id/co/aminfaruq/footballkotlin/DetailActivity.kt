package id.co.aminfaruq.footballkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_club.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // membuat get dan post

        //TODO membuat get intent
        val namaClub = intent.getStringExtra("namaClub")
        val detailClub = intent.getStringExtra("detailClub")
        val gambarClub = intent.getIntExtra("gambarClub",0)

        //TODO menampilkan datanya
        txtxJudul.text = namaClub
        txtxDetail.text = detailClub
        Glide.with(this).load(gambarClub).into(imgGambarDetail)
    }
}
