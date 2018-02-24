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
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;


/**
 * A {@link Matcher} to test if a {@link Set} reports itself as empty.
 *
 * @author Marten Gajda
 */
public final class EmptySetMatcher<T> extends TypeSafeDiagnosingMatcher<Set<T>>
{
    public static <T> Matcher<Set<T>> emptySet()
    {
        return new EmptySetMatcher<>();
    }


    @Override
    protected boolean matchesSafely(Set<T> item, Description mismatchDescription)
    {
        if (!item.isEmpty())
        {
            mismatchDescription.appendText("was not empty");
            return false;
        }
        return true;
    }


    @Override
    public void describeTo(Description description)
    {
        description.appendText("empty set");
    }
}
