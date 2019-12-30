package com.sha.bulletin

import org.junit.Before
import org.junit.Test

class BulletinTest {
    lateinit var bulletin: FakeBulletin

    @Before
    fun setup() {
        bulletin = FakeBulletin()
        BulletinManager.bulletins = mutableSetOf(bulletin)
    }

    @Test
    fun isBulletinDisplayedWithInstance_returnsTrue() {
        assert(isDisplayed(bulletin))
    }

    @Test
    fun isBulletinDisplayedWithName_returnsTrue() {
        assert(isDisplayed(bulletin.name))
    }

    @Test
    fun isBulletinDisplayedWithContent_returnsTrue() {
        assert(isDisplayed(bulletin.name))
    }

    @Test
    fun isBulletinDisplayedWithNameAndContent_returnsTrue() {
        assert(isDisplayed(bulletin.name, bulletin.content))
    }

    @Test
    fun dismissAllBulletins_dismissShouldBeCalled() {
        dismissAll()
        assert(bulletin.isDismissed)
    }

    @Test
    fun dismissBulletinWithName_dismissShouldBeCalled() {
        dismissWithName(bulletin.name)
        assert(bulletin.isDismissed)
    }

    @Test
    fun dismissBulletinWithContent_dismissShouldBeCalled() {
        dismissWithContent(bulletin.content)
        assert(bulletin.isDismissed)
    }

    @Test
    fun dismissBulletinWithNameAndContent_dismissShouldBeCalled() {
        dismiss(bulletin.name, bulletin.content)
        assert(bulletin.isDismissed)
    }
}

class FakeBulletin: Bulletin {
    override val name: String = javaClass.name
    override val content: String = "content"

    var isDismissed = false
    override fun dismiss() { isDismissed = true }
}