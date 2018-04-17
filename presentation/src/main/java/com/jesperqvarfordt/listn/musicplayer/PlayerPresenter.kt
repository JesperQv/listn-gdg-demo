package com.jesperqvarfordt.listn.musicplayer

import com.jesperqvarfordt.listn.domain.interactor.*
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PlayerPresenter
@Inject
constructor(private val play: PlayInteractor,
            private val pause: PauseInteractor,
            private val skipForward: SkipForwardInteractor,
            private val skipBackwards: SkipBackwardsInteractor,
            private val observeToPlayer: ObserveToCombinedInfoInteractor) : PlayerContract.Presenter {

    private var view: PlayerContract.View? = null
    private val disposables = CompositeDisposable()
    private var playing = false

    override fun subscribe(view: PlayerContract.View) {
        this.view = view
        disposables.add(observeToPlayer.execute()
                .subscribe({ data ->
                    playing = data.isPlaying
                    view.updateUi(data)
                }))
    }

    override fun unsubscribe() {
        view = null
        disposables.clear()
    }

    override fun playPauseClicked() {
        if (playing) {
            pause.execute()
        } else {
            play.execute()
        }
    }

    override fun skipForwardClicked() {
        skipForward.execute()
    }

    override fun skipBackwardsClicked() {
        skipBackwards.execute()
    }
}