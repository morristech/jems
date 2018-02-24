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

import static org.dmfs.jems.hamcrest.matchers.SetLacksMatcher.lacks;
import static org.dmfs.jems.mockito.doubles.TestDoubles.failingMock;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;


/**
 * @author Marten Gajda
 */
public final class SetLacksMatcherTest
{
    @Test
    public void test1() throws Exception
    {
        Set mock = failingMock(Set.class);
        doReturn(true).when(mock).contains("a");
        doReturn(true).when(mock).contains("b");
        assertThat(lacks("a", "b").matches(mock), is(false));
    }


    @Test
    public void test2() throws Exception
    {
        Set mock = failingMock(Set.class);
        doReturn(false).when(mock).contains("a");
        doReturn(true).when(mock).contains("b");
        assertThat(lacks("a", "b").matches(mock), is(false));
    }


    @Test
    public void test3() throws Exception
    {
        Set mock = failingMock(Set.class);
        doReturn(true).when(mock).contains("a");
        doReturn(false).when(mock).contains("b");
        assertThat(lacks("a", "b").matches(mock), is(false));
    }


    @Test
    public void test4() throws Exception
    {
        Set mock = failingMock(Set.class);
        doReturn(false).when(mock).contains("a");
        doReturn(false).when(mock).contains("b");
        assertThat(lacks("a", "b").matches(mock), is(true));
    }


    @Test
    public void testMismatchDescription1() throws Exception
    {
        Set mock = failingMock(Set.class);
        doReturn(false).when(mock).contains("a");
        doReturn(true).when(mock).contains("b");
        Description description = new StringDescription();
        lacks("a", "b").describeMismatch(mock, description);
        assertThat(description.toString(), is("did contain b"));
    }


    @Test
    public void testMismatchDescription2() throws Exception
    {
        Set mock = failingMock(Set.class);
        doReturn(true).when(mock).contains("a");
        doReturn(true).when(mock).contains("b");
        Description description = new StringDescription();
        lacks("a", "b").describeMismatch(mock, description);
        assertThat(description.toString(), is("did contain a"));
    }


    @Test
    public void testDescription()
    {
        Description description = new StringDescription();
        lacks("a", "b", "c").describeTo(description);
        assertThat(description.toString(), is("contains none of a, b, c"));
    }
}