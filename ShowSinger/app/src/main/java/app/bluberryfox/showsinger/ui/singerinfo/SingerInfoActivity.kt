package app.bluberryfox.showsinger.ui.singerinfo

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.models.SingerInfo
import org.jetbrains.anko.backgroundColor

/**
 * Created by user on 08.03.2018.
 */
class SingerInfoActivity: AppCompatActivity(), SingerInfoContract.View{
    override fun getId():Int {
        return intent.getIntExtra("id", 0)
    }
    override fun showSingerInfo(singer: SingerInfo) {
        var song = findViewById<TextView>(R.id.popularSong)
        val desc  = findViewById<TextView>(R.id.description)
        song.text = singer.song
        desc.text  = singer.description
    }
    private var singerInfoPresenter = SingerInfoPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singer_info)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.backgroundColor = Color.TRANSPARENT
        var img = findViewById<ImageView>(R.id.imageView)
        img.setImageResource(R.drawable.fox)
        val singer = intent.getStringExtra("singer_name")
        toolbar.title = singer
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onResume() {
        super.onResume()
        singerInfoPresenter.attachView(this)
    }

    override fun onDestroy() {
        singerInfoPresenter.detachView()
        super.onDestroy()
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}