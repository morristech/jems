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

package org.dmfs.jems.set;

/**
 * A simple immutable set.
 *
 * @author Marten Gajda
 */
public interface Set<T> extends Iterable<T>
{
    /**
     * Returns whether this set is empty or not.
     *
     * @return {@code true} if the set is empty, {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Returns whether this set contains the given element.
     *
     * @param element
     *         The element to test.
     *
     * @return {@code true} if the given element is an element of this set, {@code false} otherwise.
     */
    boolean contains(T element);
}
