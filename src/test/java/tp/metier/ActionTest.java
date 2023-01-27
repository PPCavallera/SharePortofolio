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
package tp.metier;

import tp.metier.ActionSimple;
import tp.metier.Action;
import tp.metier.ActionComposee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PPC
 */
public class ActionTest {

    public ActionTest() {
    }

    @Test
    public void test_equal_simple() {
        Action a1 = new ActionSimple("same_text");
        Action a2 = new ActionSimple("same_text");
        assertTrue(a1.equals(a2));
    }

    @Test
    public void test_equal_complexe() {
        Action a1 = new ActionComposee("same_text");
        Action a2 = new ActionComposee("same_text");
        assertTrue(a1.equals(a2));
    }
}
