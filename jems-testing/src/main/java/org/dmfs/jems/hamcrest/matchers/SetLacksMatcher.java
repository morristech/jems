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
import org.dmfs.jems.set.Set;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;


/**
 * A {@link Matcher} which checks if a {@link Set} doesn't contain the given elements.
 *
 * @author Marten Gajda
 */
public final class SetLacksMatcher<T> extends TypeSafeDiagnosingMatcher<Set<T>>
{

    private final Iterable<T> mUnexpectedElements;


    public SetLacksMatcher(Iterable<T> expectedElements)
    {
        mUnexpectedElements = expectedElements;
    }


    @SafeVarargs
    public static <T> Matcher<? super Set<T>> lacks(T... unexpected)
    {
        return lacks(new Seq<>(unexpected));
    }


    public static <T> Matcher<? super Set<T>> lacks(Iterable<T> unexpected)
    {
        return new SetLacksMatcher<>(unexpected);
    }


    @Override
    protected boolean matchesSafely(Set<T> item, Description mismatchDescription)
    {
        for (T unexpected : mUnexpectedElements)
        {
            if (item.contains(unexpected))
            {
                mismatchDescription.appendText(String.format("did contain %s", unexpected));
                return false;
            }
        }
        return true;
    }


    @Override
    public void describeTo(Description description)
    {
        description.appendText("contains none of ");
        boolean first = true;
        for (T unexpected : mUnexpectedElements)
        {
            if (first)
            {
                first = false;
            }
            else
            {
                description.appendText(", ");
            }
            description.appendText(unexpected.toString());
        }
    }
}
