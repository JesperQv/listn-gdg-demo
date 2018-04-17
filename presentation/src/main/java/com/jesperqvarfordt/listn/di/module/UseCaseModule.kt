package com.jesperqvarfordt.listn.di.module

import com.jesperqvarfordt.listn.domain.player.MusicPlayer
import com.jesperqvarfordt.listn.domain.repository.ChartRepository
import com.jesperqvarfordt.listn.domain.repository.TrackRepository
import com.jesperqvarfordt.listn.domain.interactor.*
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun searchTracksUseCase(repo: TrackRepository): SearchTracksInteractor {
        return SearchTracksInteractor(repo, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun playUseCase(player: MusicPlayer): PlayInteractor {
        return PlayInteractor(player, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun pauseUseCase(player: MusicPlayer): PauseInteractor {
        return PauseInteractor(player, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun skipForwardUseCase(player: MusicPlayer): SkipForwardInteractor {
        return SkipForwardInteractor(player, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun skipBackwardsUseCase(player: MusicPlayer): SkipBackwardsInteractor {
        return SkipBackwardsInteractor(player, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun seekToUseCase(player: MusicPlayer): SeekToInteractor {
        return SeekToInteractor(player, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun setPlaylistAndPlayUseCase(player: MusicPlayer): SetPlaylistAndPlayInteractor {
        return SetPlaylistAndPlayInteractor(player, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun subscribeToPlayerInfoUseCase(player: MusicPlayer): ObserveToPlayerInfoInteractor {
        return ObserveToPlayerInfoInteractor(player, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun subscribeToMediaInfoUseCase(player: MusicPlayer): ObservceToMediaInfoInteractor {
        return ObservceToMediaInfoInteractor(player, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun subscribeToCombinedInfoUseCase(player: MusicPlayer): ObserveToCombinedInfoInteractor {
        return ObserveToCombinedInfoInteractor(player, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun tearDownPlayerUseCase(player: MusicPlayer): TearDownPlayerInteractor {
        return TearDownPlayerInteractor(player)
    }

    @Provides
    @Singleton
    fun getTracksOnChartUseCase(trackRepository: TrackRepository): GetTracksOnChartInteractor {
        return GetTracksOnChartInteractor(trackRepository, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun getChartsUseCase(chartRepository: ChartRepository): GetChartsInteractor {
        return GetChartsInteractor(chartRepository, Schedulers.io(), AndroidSchedulers.mainThread())
    }

}