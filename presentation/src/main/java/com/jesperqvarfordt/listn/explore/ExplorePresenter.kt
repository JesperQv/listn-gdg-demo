package com.jesperqvarfordt.listn.explore

import com.jesperqvarfordt.listn.device.imagecache.ImageCache
import com.jesperqvarfordt.listn.domain.model.Chart
import com.jesperqvarfordt.listn.domain.model.Track
import com.jesperqvarfordt.listn.domain.interactor.GetChartsInteractor
import com.jesperqvarfordt.listn.domain.interactor.GetTracksOnChartInteractor
import com.jesperqvarfordt.listn.domain.interactor.SearchTracksInteractor
import com.jesperqvarfordt.listn.domain.interactor.SetPlaylistAndPlayInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ExplorePresenter
@Inject
constructor(private val search: SearchTracksInteractor,
            private val startPlayingPlaylist: SetPlaylistAndPlayInteractor,
            private val getCharts: GetChartsInteractor,
            private val getTracksOnChart: GetTracksOnChartInteractor,
            private val imageCache: ImageCache) : ExploreContract.Presenter {

    private var view: ExploreContract.View? = null
    private val disposables = CompositeDisposable()

    override fun subscribe(view: ExploreContract.View) {
        this.view = view
        loadChartsAndShow()
    }

    private fun loadChartsAndShow() {
        disposables.add(getCharts.execute()
                .doOnSubscribe({
                    view?.toggleChartList()
                    view?.showSearchBar()
                })
                .subscribe({ charts ->
                    view?.updateCharts(charts)
                }, {
                    view?.showError()
                }))
    }

    override fun unsubscribe() {
        view = null
        disposables.clear()
    }

    override fun searchClicked(query: String) {
        view?.toggleTrackList()
        disposables.add(search.execute(query)
                .subscribe({ tracks ->
                    if (tracks.isEmpty()) {
                        view?.showEmpty()
                    } else {
                        view?.updateTracks(tracks)
                        imageCache.preloadImages(tracks)
                    }
                }, {
                    view?.showError()
                }))
    }

    override fun trackClicked(tracks: List<Track>) {
        disposables.add(startPlayingPlaylist.execute(tracks)
                .subscribe())
        view?.openMusicPlayer()
    }

    override fun chartClicked(chart: Chart) {
        view?.toggleTrackList()
        view?.showTitleBar(chart.name)
        disposables.add(getTracksOnChart.execute(chart)
                .subscribe({ tracks ->
                    view?.updateTracks(tracks)
                    imageCache.preloadImages(tracks)
                }, {
                    view?.showError()
                }))
    }

    override fun backClicked() {
        loadChartsAndShow()
    }

}