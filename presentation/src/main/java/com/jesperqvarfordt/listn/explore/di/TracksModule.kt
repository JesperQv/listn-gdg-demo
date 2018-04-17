package com.jesperqvarfordt.listn.explore.di

import com.jesperqvarfordt.listn.device.imagecache.ImageCache
import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.domain.interactor.GetChartsInteractor
import com.jesperqvarfordt.listn.domain.interactor.GetTracksOnChartInteractor
import com.jesperqvarfordt.listn.domain.interactor.SearchTracksInteractor
import com.jesperqvarfordt.listn.domain.interactor.SetPlaylistAndPlayInteractor
import com.jesperqvarfordt.listn.explore.ExploreContract
import com.jesperqvarfordt.listn.explore.ExplorePresenter
import dagger.Module
import dagger.Provides

@Module
class TracksModule {

    @Provides
    @ViewScope
    fun presenter(search: SearchTracksInteractor,
                  setPlaylistAndPlay: SetPlaylistAndPlayInteractor,
                  getChartsUseCase: GetChartsInteractor,
                  getTracksOnChartUseCase: GetTracksOnChartInteractor,
                  imageCache: ImageCache): ExploreContract.Presenter {
        return ExplorePresenter(search, setPlaylistAndPlay, getChartsUseCase, getTracksOnChartUseCase, imageCache)
    }

}