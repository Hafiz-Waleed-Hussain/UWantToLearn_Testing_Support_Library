package com.testingsupportlibrary;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Hafiz Waleed Hussain on 7/11/2015.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void finalResultTest() {
        Matcher<View> twoValueButton = ViewMatchers.withText("2");
        Matcher<View> addOperationButton = ViewMatchers.withText("+");
        Matcher<View> equalOperationButton = ViewMatchers.withText("=");

        Espresso.onView(twoValueButton).perform(ViewActions.click()); wait(500);
        Espresso.onView(addOperationButton).perform(ViewActions.click()); wait(500);
        Espresso.onView(twoValueButton).perform(ViewActions.click()); wait(500);
        Espresso.onView(equalOperationButton).perform(ViewActions.click(), ViewActions.closeSoftKeyboard()); wait(500);

        Matcher<View> totalTextView = ViewMatchers.withId(R.id.totalTextView);
        final String expectedResult = "Answer: "+4;
        Espresso.onView(totalTextView).check(ViewAssertions.matches(ViewMatchers.withText(expectedResult))); wait(2000);
    }
    private void wait(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}