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

import org.dmfs.jems.iterator.adapters.Unmodifiable;
import org.dmfs.jems.set.Set;

import java.util.HashSet;
import java.util.Iterator;


/**
 * A {@link Set} which contains the elements of a {@link java.util.Set}.
 *
 * @author Marten Gajda
 */
public final class JdkSetSet<T> implements Set<T>
{
    private final java.util.Set<T> mSet;


    public JdkSetSet(java.util.Set<T> set)
    {
        mSet = new HashSet<>(set);
    }


    @Override
    public boolean isEmpty()
    {
        return mSet.isEmpty();
    }


    @Override
    public boolean contains(T element)
    {
        return mSet.contains(element);
    }


    @Override
    public Iterator<T> iterator()
    {
        return new Unmodifiable<>(mSet.iterator());
    }
}
