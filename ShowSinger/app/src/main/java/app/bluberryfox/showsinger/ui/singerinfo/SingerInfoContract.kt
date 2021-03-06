package app.bluberryfox.showsinger.ui.singerinfo

import app.bluberryfox.showsinger.BasePresenter
import app.bluberryfox.showsinger.BaseView
import app.bluberryfox.showsinger.data.SingerInfo

/**
 * Created by user on 27.03.2018.
 */
interface SingerInfoContract{
    interface View:BaseView<Presenter>{
        fun showSingerInfo(singer: SingerInfo)
        fun getId():Int

    }
    interface Presenter:BasePresenter<View>{
        fun loadSingerInfo()
        fun saveToFavorite(id:Int)

    }
}
