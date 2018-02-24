/*
 * Copyright 2018 dmfs GmbH
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dmfs.jems.hamcrest.matchers;

import org.dmfs.jems.set.Set;
import org.hamcrest.Description;
import org.hamcrest.StringDescription;
import org.junit.Test;

import static org.dmfs.jems.hamcrest.matchers.EmptySetMatcher.emptySet;
import static org.dmfs.jems.mockito.doubles.TestDoubles.failingMock;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;


/**
 * @author Marten Gajda
 */
public final class EmptySetMatcherTest
{
    @Test
    public void testEmptySet() throws Exception
    {
        Set mock = failingMock(Set.class);
        doReturn(true).when(mock).isEmpty();
        assertThat(emptySet().matches(mock), is(true));
    }


    @Test
    public void testNonEmptySet() throws Exception
    {
        Set mock = failingMock(Set.class);
        doReturn(false).when(mock).isEmpty();
        assertThat(emptySet().matches(mock), is(false));
    }


    @Test
    public void testNonEmptySetDescription() throws Exception
    {
        Set mock = failingMock(Set.class);
        doReturn(false).when(mock).isEmpty();
        Description description = new StringDescription();
        emptySet().describeMismatch(mock, description);
        assertThat(description.toString(), is("was not empty"));
    }


    @Test
    public void testDescription()
    {
        Description description = new StringDescription();
        emptySet().describeTo(description);
        assertThat(description.toString(), is("empty set"));
    }
}