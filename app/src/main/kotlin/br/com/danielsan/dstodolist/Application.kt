package br.com.danielsan.dstodolist

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatDelegate
import br.com.danielsan.dstodolist.models.DaoMaster
import br.com.danielsan.dstodolist.models.DaoSession
import br.com.danielsan.dstodolist.models.TaskList
import br.com.danielsan.dstodolist.models.TaskListDao
import org.greenrobot.greendao.DaoException
import java.util.Date

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
        initializeLists()
    }

    private fun initializeLists() {
        try {
            daoSession.taskListDao.queryBuilder().where(TaskListDao.Properties.Id.eq(1)).uniqueOrThrow()
        } catch (e: DaoException) {
            val createAt = Date()
            val inboxList = TaskList()
            inboxList.title = "Inbox"
            inboxList.createdAt = createAt
            inboxList.updatedAt = createAt
            daoSession.taskListDao.save(inboxList)
        }
    }

}

fun android.app.Application.daoSession(): DaoSession {
    return (this as Application).daoSession
}