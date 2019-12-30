package com.sha.bulletin.sheet

import com.sha.bulletin.DefaultDuplicateStrategy
import com.sha.bulletin.IconSetup
import org.junit.Before
import org.junit.Test

class RetrySheetTest {
    lateinit var options: RetrySheet.Options.Builder

    @Before
    fun setup() {
        options = RetrySheet.Options.Builder()
    }

    @Test
    fun title() {
        options.title("title")
        assert(options.build().title == "title")
    }

    @Test
    fun content() {
        options.content("content")
        assert(options.build().content == "content")
    }

    @Test
    fun retryCallback() {
        options.retryCallback {}
        assert(options.build().retryCallback != null)
    }

    @Test
    fun dismissCallback() {
        options.dismissCallback {}
        assert(options.build().dismissCallback != null)
    }

    @Test
    fun isCancellable() {
        options.isCancellable(false)
        assert(!options.build().isCancellable)
    }

    @Test
    fun ignoreIfSameContentDisplayed() {
        val strategy = DefaultDuplicateStrategy()
        options.duplicateStrategy(strategy)
        assert(options.build().duplicateStrategy == strategy)
    }

    @Test
    fun iconSetup() {
        options.iconSetup(IconSetup.create {
            iconDrawableRes = 2
            containerColorRes = 3
        })
        assert(options.build().iconSetup.iconDrawableRes == 2)
        assert(options.build().iconSetup.containerColorRes == 3)
    }
}