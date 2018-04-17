package com.jesperqvarfordt.listn.common.view.playerprogressbar.di

import com.jesperqvarfordt.listn.common.view.playerprogressbar.PlayerProgressBarContract
import com.jesperqvarfordt.listn.common.view.playerprogressbar.PlayerProgressBarPresenter
import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.domain.interactor.ObserveToCombinedInfoInteractor
import dagger.Module
import dagger.Provides

@Module
class PlayerProgressBarModule {

    @Provides
    @ViewScope
    fun presenter(observeToPlayer: ObserveToCombinedInfoInteractor) : PlayerProgressBarContract.Presenter {
        return PlayerProgressBarPresenter(observeToPlayer)
    }

}