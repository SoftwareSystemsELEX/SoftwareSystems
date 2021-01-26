package com.example.photogalleryapp;

import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void ensureTextChangesWork() throws InterruptedException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date1 = format.parse("2021-01-25 16:52:00");
        String from = new SimpleDateFormat(
                "yyyy‐MM‐dd HH:mm:ss", Locale.getDefault()).format(date1);
        Date date2 = format.parse("2021-01-25 16:53:00");
        String to = new SimpleDateFormat(
                "yyyy‐MM‐dd HH:mm:ss", Locale.getDefault()).format(date2);


        onView(withId(R.id.Filter)).perform(click());
        onView(withId(R.id.etFromDateTime)).perform(ViewActions.replaceText(from),closeSoftKeyboard());

        //onView(withId(R.id.etFromDateTime)).perform(typeText(x), closeSoftKeyboard());
        onView(withId(R.id.etToDateTime)).perform(ViewActions.replaceText(to), closeSoftKeyboard());
        onView(withId(R.id.etKeywords)).perform(typeText("DOG"), closeSoftKeyboard());
        onView(withId(R.id.OK)).perform(click());
        onView(withId(R.id.Caption)).check(matches(withText("DOG")));

        onView(withId(R.id.Filter)).perform(click());
        onView(withId(R.id.etFromDateTime)).perform(ViewActions.replaceText(""),closeSoftKeyboard());
        onView(withId(R.id.etToDateTime)).perform(ViewActions.replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.etKeywords)).perform(typeText("TV"), closeSoftKeyboard());
        onView(withId(R.id.OK)).perform(click());
        onView(withId(R.id.Caption)).check(matches(withText("TV")));
        onView(withId(R.id.Left)).perform(click());
        onView(withId(R.id.Right)).perform(click());

    }


}


