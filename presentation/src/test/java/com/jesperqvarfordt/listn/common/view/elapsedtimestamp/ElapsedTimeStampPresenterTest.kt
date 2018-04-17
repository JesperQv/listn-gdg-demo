package com.jesperqvarfordt.listn.common.view.elapsedtimestamp

import com.jesperqvarfordt.listn.common.extensions.msToTimeStamp
import com.jesperqvarfordt.listn.domain.model.player.PlayerInfo
import com.jesperqvarfordt.listn.domain.interactor.ObserveToPlayerInfoInteractor
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class ElapsedTimeStampPresenterTest {

    private lateinit var presenter: ElapsedTimeStampPresenter

    @Mock
    private lateinit var observeToPlayerInfo: ObserveToPlayerInfoInteractor

    @Mock
    private lateinit var view: ElapsedTimeStampContract.View

    private val testTime = 100

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = ElapsedTimeStampPresenter(observeToPlayerInfo)
    }

    @Test
    @Throws(Exception::class)
    fun `subscribe works with data`() {
        Mockito.`when`(observeToPlayerInfo.execute()).thenReturn(getTestData())

        presenter.subscribe(view)

        verify(observeToPlayerInfo, times(1)).execute()
        verify(view, times(1)).updateText(testTime.toLong().msToTimeStamp())
        verifyNoMoreInteractions(observeToPlayerInfo)
        verifyNoMoreInteractions(view)
    }

    @Test
    @Throws(Exception::class)
    fun `subscribe works when throwing exception`() {
        val throwable = Throwable("test fail")
        `when`(observeToPlayerInfo.execute()).thenReturn(Observable.error(throwable))

        presenter.subscribe(view)

        verify(observeToPlayerInfo, times(1)).execute()
        verify(view, times(0)).updateText(anyString())
        verifyNoMoreInteractions(observeToPlayerInfo)
        verifyNoMoreInteractions(view)
    }

    private fun getTestData(): Observable<PlayerInfo> {
        val info = PlayerInfo(true, testTime)
        return Observable.fromIterable(mutableListOf(info))
    }
}