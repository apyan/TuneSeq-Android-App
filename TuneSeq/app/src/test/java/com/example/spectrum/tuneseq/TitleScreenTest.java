package com.example.spectrum.tuneseq;

import org.junit.Test;

import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class TitleScreenTest {

    @Test
    public void TitleScreenValidation() {
        onView(withText(startsWith("ABC"))).perform(click());
    }

}
