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

package org.dmfs.jems.set.adapter;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.dmfs.jems.hamcrest.matchers.IterableMatcher.iteratesUnordered;
import static org.dmfs.jems.hamcrest.matchers.SetLacksMatcher.lacks;
import static org.dmfs.jems.hamcrest.matchers.SetMatcher.setOf;
import static org.junit.Assert.assertThat;


/**
 * @author Marten Gajda
 */
public class JdkSetSetTest
{
    @Test
    public void test()
    {
        assertThat(new JdkSetSet<>(new HashSet<>(Arrays.asList("a", "b"))), setOf("a", "b"));
        assertThat(new JdkSetSet<>(new HashSet<>(Arrays.asList("a", "b"))), iteratesUnordered("a", "b"));
        assertThat(new JdkSetSet<>(new HashSet<>(Arrays.asList("a", "b"))), lacks("c", "d"));
    }
}