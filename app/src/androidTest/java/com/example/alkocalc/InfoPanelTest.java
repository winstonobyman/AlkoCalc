package com.example.alkocalc;

import android.view.View;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class InfoPanelTest {

    @Rule
    public ActivityTestRule<InfoPanel> infoPanelActivityTestRule =
            new ActivityTestRule<InfoPanel>(InfoPanel.class);

    public InfoPanel infoPanel = null;

    @Before
    public void setUp() throws Exception {
        infoPanel = infoPanelActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = infoPanel.findViewById(R.id.drink_info);
        Assert.assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        infoPanel = null;
    }
}
