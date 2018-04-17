package com.jesperqvarfordt.listn.musicplayer.di

import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.domain.interactor.*
import com.jesperqvarfordt.listn.musicplayer.PlayerContract
import com.jesperqvarfordt.listn.musicplayer.PlayerPresenter
import dagger.Module
import dagger.Provides

@Module
class PlayerModule {

    @Provides
    @ViewScope
    fun presenter(play: PlayInteractor,
                  pause: PauseInteractor,
                  skipForward: SkipForwardInteractor,
                  skipBackwards: SkipBackwardsInteractor,
                  observeToPlayer: ObserveToCombinedInfoInteractor): PlayerContract.Presenter {
        return PlayerPresenter(play, pause, skipForward, skipBackwards, observeToPlayer)
    }

}