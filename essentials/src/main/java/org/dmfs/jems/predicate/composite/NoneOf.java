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

package org.dmfs.jems.predicate.composite;

import org.dmfs.jems.predicate.Predicate;
import org.dmfs.jems.predicate.elementary.DelegatingPredicate;


/**
 * A {@link Predicate} which matches if none of another sequence of predicates matches. This is equivalent to the boolean "NOR" operation.
 *
 * @author Marten Gajda
 */
public final class NoneOf<T> extends DelegatingPredicate<T>
{
    public NoneOf(Iterable<Predicate<T>> delegate)
    {
        super(new Not<>(new AnyOf<>(delegate)));
    }
}
