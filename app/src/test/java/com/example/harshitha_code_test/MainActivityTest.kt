package com.example.harshitha_code_test

// MainActivityTest.kt
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.harshitha_code_test.MainActivity
import com.example.harshitha_code_test.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRecyclerViewDisplayed() {
        // Check if RecyclerView is displayed
        onView(withId(R.id.recyclerView))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testToastShownOnError() {
        // Simulate a network error and check if the correct Toast message is displayed
        // (This might need to be triggered through mock data or network error simulation)
        onView(withText("Network error. Please try again."))
            .inRoot(withDecorView(not(activityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))
    }
}
