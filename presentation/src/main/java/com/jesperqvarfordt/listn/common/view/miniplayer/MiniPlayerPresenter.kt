package com.jesperqvarfordt.listn.common.view.miniplayer

import com.jesperqvarfordt.listn.domain.interactor.PauseInteractor
import com.jesperqvarfordt.listn.domain.interactor.PlayInteractor
import com.jesperqvarfordt.listn.domain.interactor.ObserveToCombinedInfoInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MiniPlayerPresenter
@Inject
constructor(private val play: PlayInteractor,
            private val pause: PauseInteractor,
            private val observeToPlayer: ObserveToCombinedInfoInteractor) : MiniPlayerContract.Presenter {

    private var view: MiniPlayerContract.View? = null
    private val disposables = CompositeDisposable()
    private var playing = false

    override fun subscribe(view: MiniPlayerContract.View) {
        this.view = view
        disposables.add(observeToPlayer.execute()
                .subscribe({ data ->
                    playing = data.isPlaying
                    this@MiniPlayerPresenter.view?.updateUi(data)
                }, {
                    // TODO implementation needed? maybe do nothing
                }))
    }

    override fun unsubscribe() {
        view = null
        disposables.clear()
    }

    override fun playPausedClicked() {
        if (playing) {
            pause.execute()
        } else {
            play.execute()
        }
    }

    override fun miniPlayerClicked() {
        view?.openMusicPlayer()
    }
}