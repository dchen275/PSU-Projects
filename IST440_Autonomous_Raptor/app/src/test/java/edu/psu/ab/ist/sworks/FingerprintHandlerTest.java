package edu.psu.ab.ist.sworks;

import android.content.Context;
import android.widget.TextView;

import androidx.test.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;

import edu.psu.ab.ist.sworks.pojo.Fingerprint;

import static junit.framework.TestCase.assertEquals;

public class FingerprintHandlerTest {
    @Rule
    /*ActivityTestRule<FingerprintHandler> activityTestRule =
            new ActivityTestRule<>(FingerprintHandler.class);*/
    @Test
    public void onAuthenticationError() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        FingerprintHandler test = new FingerprintHandler(appContext);
    }

    @Test
    public void onAuthenticationFailed() {
        /*FingerprintHandler activity = activityTestRule.getActivity();
        onView(withText(R.string.toast_text)).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
        onView(withText("Authentication failed")).inRoot(withDecorView(not(is(getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));*/
    }

    @Test
    public void onAuthenticationHelp() {
    }

    @Test
    public void onAuthenticationSucceeded() {

        /*TextView toastTextView = solo.getText(0);
        if(toastTextView != null){
            String toastText = toastTextView.getText().toString();
            assertEquals(toastText, "Your expected text here");
        }
        //wait for Toast to close
        solo.waitForDialogToClose(5000);*/
    }
}