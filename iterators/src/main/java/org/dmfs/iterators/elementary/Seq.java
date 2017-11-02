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

package org.dmfs.iterators.elementary;

import org.dmfs.iterators.AbstractBaseIterator;

import java.util.Iterator;


/**
 * An {@link Iterator} of a sequence of values.
 *
 * @param <E>
 *         The type of the values in the array.
 *
 * @author Marten Gajda
 */
public final class Seq<E> extends AbstractBaseIterator<E>
{
    private final E[] mValue;
    private int mNext;


    /**
     * Creates an {@link Iterator} which iterates all values in the given array.
     *
     * @param array
     *         The array.
     */
    @SafeVarargs
    public Seq(E... array)
    {
        mValue = array;
    }


    @Override
    public boolean hasNext()
    {
        return mNext < mValue.length;
    }


    @Override
    public E next()
    {
        return mValue[mNext++];
    }
}