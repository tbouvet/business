/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.internal.event.test;

import com.google.inject.Injector;
import org.mockito.internal.util.reflection.Whitebox;
import org.seedstack.business.api.Event;
import org.seedstack.business.fixtures.event.MyEvent;
import org.seedstack.business.fixtures.event.MyHandler;
import org.seedstack.business.fixtures.event.MyHandler2;
import org.seedstack.business.fixtures.event.MyService;
import org.seedstack.business.test.event.EventFixture;
import org.seedstack.business.api.EventHandler;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.seedstack.seed.core.api.SeedException;

import java.util.HashMap;

import static org.mockito.Mockito.mock;

/**
 * @author pierre.thirouin@ext.mpsa.com
 */
public class ServiceFixtureTest {

    public static final String SOME_PARAM = "someParam";

    private ContextLink contextLink = mock(ContextLink.class);

    private EventFixture underTest;

    private MyEvent event = new MyEvent(SOME_PARAM);


    @Before
    public void setUp() {
        underTest = new EventFixtureInternal();
        Injector injector = mock(Injector.class);
        Mockito.when(injector.getInstance(MyService.class)).thenReturn(mock(MyService.class));
        Whitebox.setInternalState(underTest, "contextLink", contextLink);
        Whitebox.setInternalState(underTest, "injector", injector);

        HashMap<Class<? extends EventHandler>, Event> value = new HashMap<Class<? extends EventHandler>, Event>();
        value.put(MyHandler.class, event);
        value.put(MyHandler2.class, event);
        Mockito.when(contextLink.peek()).thenReturn(value);
    }

    @Test
    public void expect_handler_was_called_with_event() throws Exception {
        underTest.given(MyService.class)
                .whenCalled("callBusinessStuff", SOME_PARAM)
                .eventWasHandledBy(event, MyHandler.class);
    }

    @Test(expected = SeedException.class)
    public void failed_method_was_not_equal() throws Exception {
        underTest.given(MyService.class)
                .whenCalled("unknownMethod", SOME_PARAM)
                .eventWasHandledBy(new MyEvent("foobar"), MyHandler.class);
    }

    @Test(expected = SeedException.class)
    public void failed_method_was_not_found() throws Exception {
        underTest.given(MyService.class)
                .whenCalled("unknownMethod", SOME_PARAM)
                .eventWasHandledBy(event, MyHandler.class);
    }

    @Test(expected = SeedException.class)
    public void failed_event_was_null() throws Exception {
        underTest.given(MyService.class)
                .whenCalled("callBusinessStuff", SOME_PARAM)
                .eventWasHandledBy(null, MyHandler.class);
    }

    @Test(expected = SeedException.class)
    public void failed_event_was_not_fired() throws Exception {
        HashMap<Class<? extends EventHandler>, Event> value = new HashMap<Class<? extends EventHandler>, Event>();
        Mockito.when(contextLink.peek()).thenReturn(value);
        underTest.given(MyService.class)
                .whenCalled("doNothing")
                .eventWasHandledBy(event, MyHandler.class);
    }
}
