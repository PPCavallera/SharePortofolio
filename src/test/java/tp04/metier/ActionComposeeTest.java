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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PPC
 */
public class ActionComposeeTest {

    public ActionComposeeTest() {
    }

    @Test
    public void testCreationACFctnmntNormal() {
        ActionComposee ac = new ActionComposee("ac");
        ActionSimple as1, as2;
        as1 = new ActionSimple("as1");
        as2 = new ActionSimple("as2");
        ac.enrgComposition(as1, 2);
        ac.enrgComposition(as2, 3);
        Assertions.assertTrue(ac.containsAction(as1));
        Assertions.assertTrue(ac.containsAction(as1));
    }

    @Test
    public void testCreationACAbsente() {
        ActionComposee ac = new ActionComposee("ac");
        ActionSimple as1, as2;
        as1 = new ActionSimple("as1");
        as2 = new ActionSimple("as2");
        ac.enrgComposition(as1, 2);
        Assertions.assertFalse(ac.containsAction(as2));
    }

    @Test
    public void testCreationACNull() {
        ActionComposee ac = new ActionComposee("ac");
        Assertions.assertNull(ac.enrgComposition(null, 2));

    }
    
    @Test
    public void testCreationPourcInf() {
        ActionComposee ac = new ActionComposee("ac");
        Assertions.assertNull(ac.enrgComposition(new ActionSimple("toto"), -2));
        Assertions.assertNull(ac.enrgComposition(new ActionSimple("titi"), 0));

    }

}
