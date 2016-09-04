package br.com.danielsan.dstodolist.features.main

import br.com.danielsan.dstodolist.models.TaskListDao
import br.com.danielsan.dstodolist.shared.Presenter

/**
 * Created by daniel on 04/09/16.
 */
class MainPresenter(val taskListDao: TaskListDao) : Presenter<MainView>() {

    override fun attachView(view: MainView) {
        super.attachView(view)
        view.showLists(taskListDao.queryBuilder().list())
    }

}