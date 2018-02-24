/*
 * Copyright 2017 dmfs GmbH
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
import org.dmfs.jems.iterable.decorators.Mapped;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;

import java.util.ArrayList;
import java.util.List;


/**
 * Factory methods for {@link Iterable} matchers.
 *
 * @author Gabor Keszthelyi
 */
public final class IterableMatcher
{

    private IterableMatcher()
    {
    }


    /**
     * {@link Matcher} that matches when the provided matchers match with the actual {@link Iterable}s elements in the same order.
     */
    @Factory
    public static <E> Matcher<Iterable<? extends E>> iteratesTo(Iterable<Matcher<E>> itemMatchers)
    {
        List<Matcher<? super E>> matchers = new ArrayList<>();
        for (Matcher<E> itemMatcher : itemMatchers)
        {
            matchers.add(itemMatcher);
        }
        return new IsIterableContainingInOrder<E>(matchers);
    }


    /**
     * {@link Matcher} that matches when the actual {@link Iterable} has equal to elements in same order as the provided items.
     */
    @SafeVarargs
    @Factory
    public static <E> Matcher<Iterable<? extends E>> iteratesTo(E... items)
    {
        return IsIterableContainingInOrder.contains(items);
    }


    /**
     * {@link Matcher} that matches when the provided item matchers match the actual {@link Iterable}s elements in the same order.
     */
    @SafeVarargs
    @Factory
    public static <E> Matcher<Iterable<? extends E>> iteratesTo(Matcher<E>... itemMatchers)
    {
        return IsIterableContainingInOrder.contains(itemMatchers);
    }


    /**
     * {@link Matcher} that matches when the provided matchers match with the actual {@link Iterable}s elements in any order.
     */
    @Factory
    public static <E> Matcher<Iterable<? extends E>> iteratesUnordered(Iterable<Matcher<E>> itemMatchers)
    {
        List<Matcher<? super E>> matchers = new ArrayList<>();
        for (Matcher<E> itemMatcher : itemMatchers)
        {
            matchers.add(itemMatcher);
        }
        return new IsIterableContainingInAnyOrder<E>(matchers);
    }


    /**
     * {@link Matcher} that matches when the actual {@link Iterable} iterates the provided items in any order.
     */
    @SafeVarargs
    @Factory
    public static <E> Matcher<Iterable<? extends E>> iteratesUnordered(E... items)
    {
        return iteratesUnordered(new Mapped<>(CoreMatchers::is, new Seq<>(items)));
    }


    /**
     * {@link Matcher} that matches when the provided item matchers match the actual {@link Iterable}s elements in any order.
     */
    @SafeVarargs
    @Factory
    public static <E> Matcher<Iterable<? extends E>> iteratesUnordered(Matcher<E>... itemMatchers)
    {
        return iteratesUnordered(new Seq<>(itemMatchers));
    }
}
