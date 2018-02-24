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

package org.dmfs.jems.set.elementary;

import org.junit.Test;

import static org.dmfs.jems.hamcrest.matchers.EmptySetMatcher.emptySet;
import static org.dmfs.jems.hamcrest.matchers.IterableMatcher.iteratesUnordered;
import static org.dmfs.jems.hamcrest.matchers.SetLacksMatcher.lacks;
import static org.dmfs.jems.hamcrest.matchers.SetMatcher.setOf;
import static org.hamcrest.Matchers.emptyIterable;
import static org.junit.Assert.assertThat;


/**
 * @author Marten Gajda
 */
public final class SeqSetTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new SeqSet<>(), emptySet());
        assertThat(new SeqSet<>(), emptyIterable());
        assertThat(new SeqSet<String>(), lacks("a", "b", "c"));
        assertThat(new SeqSet<>("a", "b"), setOf("a", "b"));
        assertThat(new SeqSet<>("a", "b"), lacks("c", "d"));
        assertThat(new SeqSet<>("a", "b"), iteratesUnordered("a", "b"));
        assertThat(new SeqSet<>("a", "b", "a", "b"), setOf("a", "b"));
        assertThat(new SeqSet<>("a", "b", "a", "b"), lacks("c", "d"));
        assertThat(new SeqSet<>("a", "b", "a", "b"), iteratesUnordered("a", "b"));
    }
}