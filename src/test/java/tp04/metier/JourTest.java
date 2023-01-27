/*
 * Copyright 2023 PPC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tp04.metier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PPC
 */
public class JourTest {

    public JourTest() {
    }

    @Test
    public void test_compare_eq() {
        // x==y
        Jour j1 = new Jour(2022, 22);
        Jour j2 = new Jour(2022, 22);

        int result = j1.compareTo(j2);
        assertEquals(result, 0);
    }

    @Test
    public void test_compare_bigger1() {
        // x<y
        Jour j1 = new Jour(2022, 22);
        Jour j2 = new Jour(2023, 22);

        int result = j1.compareTo(j2);
        assertEquals(result, -1);
    }

    @Test
    public void test_compare_bigger2() {
        // x<y
        Jour j1 = new Jour(2022, 22);
        Jour j2 = new Jour(2022, 23);

        int result = j1.compareTo(j2);
        assertEquals(result, -1);
    }

    @Test
    public void test_compare_smaller1() {
        // x>y
        Jour j1 = new Jour(2023, 22);
        Jour j2 = new Jour(2022, 22);

        int result = j1.compareTo(j2);
        assertEquals(result, 1);
    }

    @Test
    public void test_compare_smaller() {
        // x>y
        Jour j1 = new Jour(2022, 23);
        Jour j2 = new Jour(2022, 22);

        int result = j1.compareTo(j2);
        assertEquals(result, 1);
    }

}
