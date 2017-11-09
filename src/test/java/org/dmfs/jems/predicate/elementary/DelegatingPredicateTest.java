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

package org.dmfs.jems.predicate.elementary;

import org.dmfs.jems.predicate.Predicate;
import org.junit.Test;

import static org.dmfs.jems.mockito.doubles.TestDoubles.dummy;
import static org.dmfs.jems.mockito.doubles.TestDoubles.failingMock;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


/**
 * @author marten
 */
public class DelegatingPredicateTest
{
    @Test
    public void testSatisfiedBy() throws Exception
    {
        Object testDummy = dummy(Object.class);
        Predicate<Object> mockPredicate = failingMock(Predicate.class);
        doReturn(false).when(mockPredicate).satisfiedBy(any());
        doReturn(true).when(mockPredicate).satisfiedBy(testDummy);

        assertThat(new TestPredicate<>(mockPredicate).satisfiedBy(new Object()), is(false));
        assertThat(new TestPredicate<>(mockPredicate).satisfiedBy(testDummy), is(true));
    }


    private final static class TestPredicate<T> extends DelegatingPredicate<T>
    {
        public TestPredicate(Predicate<T> delegate)
        {
            super(delegate);
        }
    }
}