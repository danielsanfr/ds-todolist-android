package br.com.danielsan.dstodolist

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatDelegate
import br.com.danielsan.dstodolist.models.DaoMaster
import br.com.danielsan.dstodolist.models.DaoSession
import org.greenrobot.greendao.database.Database

/**
 * Created by daniel on 25/03/16.
 */
class Application : android.app.Application() {

    val daoSession: DaoSession by lazy {
        DaoMaster(DaoMaster.DevOpenHelper(this, "tasks-db").writableDb).newSession()
    }

    override fun onCreate() {
        super.onCreate()
        FragmentManager.enableDebugLogging(BuildConfig.DEBUG)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
    }

}
