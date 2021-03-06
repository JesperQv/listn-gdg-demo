package com.jesperqvarfordt.listn.common.view.playerseekbar

import com.jesperqvarfordt.listn.domain.model.player.CombinedInfo
import com.jesperqvarfordt.listn.domain.model.player.MediaInfo
import com.jesperqvarfordt.listn.domain.model.player.PlayerInfo
import com.jesperqvarfordt.listn.domain.interactor.SeekToInteractor
import com.jesperqvarfordt.listn.domain.interactor.ObserveToCombinedInfoInteractor
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PlayerSeekBarPresenterTest {

    private lateinit var presenter: PlayerSeekBarPresenter

    @Mock
    private lateinit var observeToPlayer: ObserveToCombinedInfoInteractor

    @Mock
    private lateinit var seekTo: SeekToInteractor

    @Mock
    private lateinit var view: PlayerSeekBarContract.View

    private val testPlayerInfo = PlayerInfo(true, 1)
    private val testMediaInfo = MediaInfo("title", "artist", "url", 10)
    private val testCombinedInfo = CombinedInfo(testPlayerInfo, testMediaInfo)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = PlayerSeekBarPresenter(seekTo, observeToPlayer)
    }

    @Test
    @Throws(Exception::class)
    fun `subscribe works with data`() {
        Mockito.`when`(observeToPlayer.execute()).thenReturn(getTestData())

        presenter.subscribe(view)

        Mockito.verify(observeToPlayer, Mockito.times(1)).execute()
        Mockito.verify(view, Mockito.times(1)).animateProgress(testCombinedInfo.isPlaying,
                testCombinedInfo.elapsedTimeInMs,
                testCombinedInfo.durationInMs)
        Mockito.verifyNoMoreInteractions(observeToPlayer)
        Mockito.verifyNoMoreInteractions(view)
    }

    @Test
    @Throws(Exception::class)
    fun `subscribe works when throwing exception`() {
        val throwable = Throwable("test fail")
        Mockito.`when`(observeToPlayer.execute()).thenReturn(Observable.error(throwable))

        presenter.subscribe(view)

        Mockito.verify(observeToPlayer, Mockito.times(1)).execute()
        Mockito.verify(view, Mockito.times(0)).animateProgress(Mockito.anyBoolean(), Mockito.anyInt(), Mockito.anyInt())
        Mockito.verifyNoMoreInteractions(observeToPlayer)
        Mockito.verifyNoMoreInteractions(view)
    }

    @Test
    @Throws(Exception::class)
    fun `updates view when view animation is done`() {
        Mockito.`when`(observeToPlayer.execute()).thenReturn(getTestData())

        presenter.subscribe(view)

        presenter.progressAnimationUpdated(1)

        Mockito.verify(view, Mockito.times(1)).seekTo(1)
    }

    @Test
    @Throws(Exception::class)
    fun `stop scrubbing works`() {
        Mockito.`when`(observeToPlayer.execute()).thenReturn(getTestData())

        presenter.subscribe(view)

        presenter.stopScrubbing(1)

        Mockito.verify(seekTo, Mockito.times(1)).execute(1)
        Mockito.verifyNoMoreInteractions(seekTo)
    }

    private fun getTestData(): Observable<CombinedInfo> {
        return Observable.fromIterable(mutableListOf(testCombinedInfo))
    }
}