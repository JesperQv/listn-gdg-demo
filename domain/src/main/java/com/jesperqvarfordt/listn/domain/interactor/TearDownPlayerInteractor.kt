package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.player.MusicPlayer

open class TearDownPlayerInteractor(private val player: MusicPlayer) {

    open fun execute() = player.tearDown()
}