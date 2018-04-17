package com.jesperqvarfordt.listn.common.view.miniplayer.di

import com.jesperqvarfordt.listn.common.view.miniplayer.MiniPlayerContract
import com.jesperqvarfordt.listn.common.view.miniplayer.MiniPlayerPresenter
import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.domain.interactor.PauseInteractor
import com.jesperqvarfordt.listn.domain.interactor.PlayInteractor
import com.jesperqvarfordt.listn.domain.interactor.ObserveToCombinedInfoInteractor
import dagger.Module
import dagger.Provides

@Module
class MiniPlayerModule {

    @Provides
    @ViewScope
    fun presenter(play: PlayInteractor,
                  pause: PauseInteractor,
                  observeToPlayer: ObserveToCombinedInfoInteractor): MiniPlayerContract.Presenter {
        return MiniPlayerPresenter(play, pause, observeToPlayer)
    }
}