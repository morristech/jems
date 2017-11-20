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

package org.dmfs.jems.text.decorators;

import org.dmfs.jems.text.Text;
import org.dmfs.jems.text.elementary.EmptyText;


/**
 * @author Marten Gajda
 */
public final class Repeated implements Text
{
    private final int mCount;
    private final Text mDelegate;


    public Repeated(int count, Text delegate)
    {
        mCount = count;
        mDelegate = delegate;
    }


    @Override
    public char[] value()
    {
        char[] delegate = mDelegate.value();
        if (mCount == 0)
        {
            return EmptyText.INSTANCE.value();
        }
        if (mCount == 1)
        {
            return delegate;
        }
        int len = delegate.length;
        char[] result = new char[len * mCount];
        for (int i = 0; i < mCount; ++i)
        {
            System.arraycopy(delegate, 0, result, len * i, len);
        }
        return result;
    }
}