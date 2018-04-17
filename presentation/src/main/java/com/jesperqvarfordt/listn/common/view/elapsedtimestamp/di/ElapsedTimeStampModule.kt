package com.jesperqvarfordt.listn.common.view.elapsedtimestamp.di

import com.jesperqvarfordt.listn.common.view.elapsedtimestamp.ElapsedTimeStampContract
import com.jesperqvarfordt.listn.common.view.elapsedtimestamp.ElapsedTimeStampPresenter
import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.domain.interactor.ObserveToPlayerInfoInteractor
import dagger.Module
import dagger.Provides

@Module
class ElapsedTimeStampModule {

    @Provides
    @ViewScope
    fun presenter(observeToPlayer: ObserveToPlayerInfoInteractor):
            ElapsedTimeStampContract.Presenter {
        return ElapsedTimeStampPresenter(observeToPlayer)
    }
}