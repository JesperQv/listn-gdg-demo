package com.jesperqvarfordt.listn.common.view.playerseekbar.di

import com.jesperqvarfordt.listn.common.view.playerseekbar.PlayerSeekBarContract
import com.jesperqvarfordt.listn.common.view.playerseekbar.PlayerSeekBarPresenter
import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.domain.interactor.SeekToInteractor
import com.jesperqvarfordt.listn.domain.interactor.ObserveToCombinedInfoInteractor
import dagger.Module
import dagger.Provides

@Module
class PlayerSeekBarModule {

    @Provides
    @ViewScope
    fun presenter(seekTo: SeekToInteractor,
                  observeToPlayer: ObserveToCombinedInfoInteractor) : PlayerSeekBarContract.Presenter {
        return PlayerSeekBarPresenter(seekTo, observeToPlayer)
    }

}