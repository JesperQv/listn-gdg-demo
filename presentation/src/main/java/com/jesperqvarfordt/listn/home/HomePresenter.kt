package com.jesperqvarfordt.listn.home

import com.jesperqvarfordt.listn.domain.interactor.TearDownPlayerInteractor

class HomePresenter(private val tearDownPlayer: TearDownPlayerInteractor): HomeContract.Presenter {

    private var view: HomeContract.View? = null

    override fun subscribe(view: HomeContract.View) {
        this.view = view
    }

    override fun unsubscribe() {
        view = null
    }

    override fun viewDestroyed() {
        tearDownPlayer.execute()
    }
}