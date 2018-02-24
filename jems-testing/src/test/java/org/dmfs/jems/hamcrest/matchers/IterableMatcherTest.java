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

import org.dmfs.iterables.elementary.Seq;
import org.junit.Test;

import static org.dmfs.jems.hamcrest.matchers.IterableMatcher.iteratesTo;
import static org.dmfs.jems.hamcrest.matchers.IterableMatcher.iteratesUnordered;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Marten Gajda
 */
public final class IterableMatcherTest
{
    @Test
    public void testIteratesTo() throws Exception
    {
        assertThat(iteratesTo("a", "b", "c").matches(new Seq<>("a", "b", "c")), is(true));
        assertThat(iteratesTo("a", "b", "c").matches(new Seq<>("a", "b")), is(false));
        assertThat(iteratesTo("a", "b", "c").matches(new Seq<>("a", "b", "d")), is(false));
        assertThat(iteratesTo("a", "b", "c").matches(new Seq<>("a", "b", "c", "d")), is(false));
    }


    @Test
    public void testIteratesUnordered() throws Exception
    {
        assertThat(iteratesUnordered("a", "b", "c").matches(new Seq<>("a", "b", "c")), is(true));
        assertThat(iteratesUnordered("a", "b", "c").matches(new Seq<>("a", "c", "b")), is(true));
        assertThat(iteratesUnordered("a", "b", "c").matches(new Seq<>("b", "a", "c")), is(true));
        assertThat(iteratesUnordered("a", "b", "c").matches(new Seq<>("b", "c", "a")), is(true));
        assertThat(iteratesUnordered("a", "b", "c").matches(new Seq<>("c", "b", "a")), is(true));
        assertThat(iteratesUnordered("a", "b", "c").matches(new Seq<>("c", "a", "b")), is(true));

        assertThat(iteratesUnordered("a", "b", "c").matches(new Seq<>("a", "c")), is(false));
        assertThat(iteratesUnordered("a", "b", "c").matches(new Seq<>("a", "c", "d")), is(false));
        assertThat(iteratesUnordered("a", "b", "c").matches(new Seq<>("a", "c", "b", "d")), is(false));
    }

}