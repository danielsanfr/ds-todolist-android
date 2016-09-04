package br.com.danielsan.dstodolist.features.main

import android.support.annotation.StringRes
import br.com.danielsan.dstodolist.models.TaskList

/**
 * Created by daniel on 04/09/16.
 */
interface MainView {

    fun showLists(lists: List<TaskList>)

    fun showLoading()

    fun dismissLoading()

    fun showMessage(@StringRes messageRes: Int)

}