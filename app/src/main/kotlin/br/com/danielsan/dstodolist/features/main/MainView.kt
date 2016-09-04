package br.com.danielsan.dstodolist.features.main

import android.support.annotation.StringRes

/**
 * Created by daniel on 04/09/16.
 */
interface MainView {

    fun showLoading()

    fun dismissLoading()

    fun showMessage(@StringRes messageRes: Int)

}