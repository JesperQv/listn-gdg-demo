package com.jesperqvarfordt.listn.home.di

import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.domain.interactor.TearDownPlayerInteractor
import com.jesperqvarfordt.listn.home.HomeContract
import com.jesperqvarfordt.listn.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    @ViewScope
    fun providePresenter(tearDownPlayer: TearDownPlayerInteractor): HomeContract.Presenter {
        return HomePresenter(tearDownPlayer)
    }
}