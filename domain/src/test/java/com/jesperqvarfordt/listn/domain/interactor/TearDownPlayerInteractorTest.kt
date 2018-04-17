package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.player.MusicPlayer
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TearDownPlayerInteractorTest {
    private lateinit var interactor: TearDownPlayerInteractor

    @Mock
    private lateinit var musicPlayer: MusicPlayer


    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        interactor = TearDownPlayerInteractor(musicPlayer)
    }

    @Test
    @Throws(Exception::class)
    fun `test use case`() {
        interactor.execute()

        Mockito.verify(musicPlayer, Mockito.times(1)).tearDown()
        Mockito.verifyNoMoreInteractions(musicPlayer)
    }
}