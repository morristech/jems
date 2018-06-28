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

package org.dmfs.optional.adapters;

import org.dmfs.iterables.elementary.Seq;
import org.dmfs.optional.First;
import org.dmfs.optional.Optional;
import org.dmfs.optional.decorators.DelegatingOptional;
import org.dmfs.optional.iterable.PresentValues;


/**
 * The first present value of an {@link Iterable} of {@link Optional}s.
 *
 * @author Gabor Keszthelyi
 * @deprecated in favour of {@link org.dmfs.jems.optional.adapters.FirstPresent}.
 */
@Deprecated
public final class FirstPresent<T> extends DelegatingOptional<T>
{
    @SafeVarargs
    public FirstPresent(Optional<T>... optionals)
    {
        this(new Seq<>(optionals));
    }


    public FirstPresent(Iterable<Optional<T>> optionals)
    {
        super(new First<T>(new PresentValues<T>(optionals)));
    }
}
