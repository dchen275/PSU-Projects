package edu.psu.ab.ist.sworks;

import android.app.Activity;
import android.hardware.fingerprint.FingerprintManager;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.service.autofill.Validators.not;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class FingerprintHandlerTest<FingerprintHandler> {


    public FingerprintHandlerTest() {

    }

    @Rule
    /*public ActivityTestRule<activity> activityTestRule =
            new ActivityTestRule<>(FingerprintHandler.class);*/
    @Test
    public void onAuthenticationError() {

    }

    @Test
    public void onAuthenticationFailed() {
        /*FingerprintHandler activity = activityTestRule.getActivity();
        String failed = "auth failed";*/
       /* onView(withText(R.string.toast_text)).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
        onView(withText("Authentication failed")).inRoot(withDecorView(not(is(getActivity().getWindow().getDecorView())))).check(matches(isDisplayed())); */
       //onView(withText(failed));
            //.check(matches(isDisplayed()));





    }

    @Test
    public void onAuthenticationHelp() {

    }

    @Test
    public void onAuthenticationSucceeded() {
    }
}