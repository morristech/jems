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
import static org.dmfs.jems.hamcrest.matchers.SetLacksMatcher.lacks;
import static org.hamcrest.Matchers.emptyIterable;
import static org.junit.Assert.assertThat;


/**
 * @author Marten Gajda
 */
public final class EmptySetTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new EmptySet<>(), emptySet());
        assertThat(new EmptySet<>(), emptyIterable());
        assertThat(new EmptySet<String>(), lacks("a", "b", "c"));
    }

}