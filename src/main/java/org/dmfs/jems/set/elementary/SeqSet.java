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

import org.dmfs.iterables.decorators.Sieved;
import org.dmfs.iterables.elementary.Seq;
import org.dmfs.iterators.decorators.Filtered;
import org.dmfs.iterators.filters.Distinct;
import org.dmfs.jems.set.Set;

import java.util.Iterator;


/**
 * A {@link Set} of the elements of a sequence.
 *
 * @author Marten Gajda
 */
public final class SeqSet<T> implements Set<T>
{
    private final Iterable<T> mElements;


    @SafeVarargs
    public SeqSet(T... elements)
    {
        this(new Seq<>(elements));
    }


    public SeqSet(Iterable<T> elements)
    {
        mElements = elements;
    }


    @Override
    public boolean isEmpty()
    {
        return !mElements.iterator().hasNext();
    }


    @Override
    public boolean contains(T element)
    {
        return new Sieved<>(e -> e.equals(element), mElements).iterator().hasNext();
    }


    @Override
    public Iterator<T> iterator()
    {
        return new Filtered<>(mElements.iterator(), new Distinct<>());
    }
}
