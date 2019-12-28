package com.sha.bulletin

import org.junit.Before
import org.junit.Test

class IconSetupTest {
    lateinit var setup: IconSetup.Builder

    @Before
    fun setup() {
        setup = IconSetup.Builder()
    }

    @Test
    fun iconRes() {
        setup.iconRes(1)
        assert(setup.build().iconRes == 1)
    }

    @Test
    fun containerColorRes() {
        setup.containerColorRes(1)
        assert(setup.build().containerColorRes == 1)
    }
}