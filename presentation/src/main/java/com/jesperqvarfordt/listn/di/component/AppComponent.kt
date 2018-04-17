package com.jesperqvarfordt.listn.di.component

import com.jesperqvarfordt.listn.device.imagecache.ImageCache
import com.jesperqvarfordt.listn.di.module.*
import com.jesperqvarfordt.listn.domain.player.MusicPlayer
import com.jesperqvarfordt.listn.domain.interactor.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    MusicPlayerModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    SCModule::class])
interface AppComponent {

    fun musicPlayer(): MusicPlayer
    fun imageCache(): ImageCache
    fun searchTracksUseCase(): SearchTracksInteractor
    fun playUseCase(): PlayInteractor
    fun pauseUseCase(): PauseInteractor
    fun skipForwardUseCase(): SkipForwardInteractor
    fun skipBackwardsUseCase(): SkipBackwardsInteractor
    fun seekToUseCase(): SeekToInteractor
    fun setPlaylistAndPlayUseCase(): SetPlaylistAndPlayInteractor
    fun subscribeToPlayerInfoUseCase(): ObserveToPlayerInfoInteractor
    fun subscribeToMediaInfoUseCase(): ObservceToMediaInfoInteractor
    fun subscribeToCombinedInfoUseCase(): ObserveToCombinedInfoInteractor
    fun tearDownPlayerUseCase(): TearDownPlayerInteractor
    fun getTracksOnChartUseCase(): GetTracksOnChartInteractor
    fun getChartsUseCase(): GetChartsInteractor

}