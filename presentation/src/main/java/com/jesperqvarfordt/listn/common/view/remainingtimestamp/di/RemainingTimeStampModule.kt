package com.jesperqvarfordt.listn.common.view.remainingtimestamp.di

import com.jesperqvarfordt.listn.common.view.remainingtimestamp.RemainingTimeStampContract
import com.jesperqvarfordt.listn.common.view.remainingtimestamp.RemainingTimeStampPresenter
import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.domain.interactor.ObserveToCombinedInfoInteractor
import dagger.Module
import dagger.Provides

@Module
class RemainingTimeStampModule {

    @Provides
    @ViewScope
    fun presenter(observeToPlayer: ObserveToCombinedInfoInteractor):
            RemainingTimeStampContract.Presenter {
        return RemainingTimeStampPresenter(observeToPlayer)
    }
}