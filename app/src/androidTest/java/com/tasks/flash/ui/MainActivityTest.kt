package com.tasks.flash.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.tasks.flash.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun before() {
    }

    @Test
    @Throws(Exception::class)
    fun checkProgressBarIsShown() {
        Espresso.onView(withId(R.id.pbLoading)).check(ViewAssertions.matches(isDisplayed()))
        Thread.sleep(5000)
    }

    @Test
    @Throws(Exception::class)
    fun checkMapIsShown() {
        Espresso.onView(withId(R.id.map)).check(ViewAssertions.matches(isDisplayed()))
    }

    @After
    fun after() {
    }
}
