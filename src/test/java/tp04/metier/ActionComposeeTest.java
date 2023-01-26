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

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

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
        List<ActionSimple> listeAs = new ArrayList<>();
        List<Float> listePourcentage = new ArrayList<>();
        listeAs.add(as1);
        listeAs.add(as2);
        listePourcentage.add(0.4f);
        listePourcentage.add(0.6f);

        Assertions.assertTrue(ac.enrgComposition(listeAs, listePourcentage));
    }

    @Test
    public void testCreationACPourcentageIncorrect() {
        ActionComposee ac = new ActionComposee("ac");
        ActionSimple as1, as2;
        as1 = new ActionSimple("as1");
        as2 = new ActionSimple("as2");
        List<ActionSimple> listeAs = new ArrayList<>();
        List<Float> listePourcentage = new ArrayList<>();
        listeAs.add(as1);
        listePourcentage.add(0.6f);

        Assertions.assertFalse(ac.enrgComposition(listeAs, listePourcentage));
        listeAs.add(as2);
        listePourcentage.add(0.6f);
        Assertions.assertFalse(ac.enrgComposition(listeAs, listePourcentage));
    }

    @Test
    public void testCreationACPourcentageNegatif() {
        ActionComposee ac = new ActionComposee("ac");
        ActionSimple as1, as2;
        as1 = new ActionSimple("as1");
        as2 = new ActionSimple("as2");
        List<ActionSimple> listeAs = new ArrayList<>();
        List<Float> listePourcentage = new ArrayList<>();
        listeAs.add(as1);
        listeAs.add(as2);
        listePourcentage.add(1.6f);
        listePourcentage.add(-0.6f);

        Assertions.assertFalse(ac.enrgComposition(listeAs, listePourcentage));
    }

    @Test
    public void testCreationACListeNull() {
        ActionComposee ac = new ActionComposee("ac");
        ActionSimple as1, as2;
        as1 = new ActionSimple("as1");
        as2 = new ActionSimple("as2");
        List<ActionSimple> listeAs = new ArrayList<>();
        List<Float> listePourcentage = new ArrayList<>();
        listeAs.add(as1);
        listeAs.add(as2);
        listePourcentage.add(1.6f);
        listePourcentage.add(-0.6f);

        Assertions.assertFalse(ac.enrgComposition(null, listePourcentage));
        Assertions.assertFalse(ac.enrgComposition(listeAs, null));
    }
        @Test
    public void testCreationACListeTailleDifferente() {
        ActionComposee ac = new ActionComposee("ac");
        ActionSimple as1, as2;
        as1 = new ActionSimple("as1");
        as2 = new ActionSimple("as2");
        List<ActionSimple> listeAs = new ArrayList<>();
        List<Float> listePourcentage = new ArrayList<>();
        listeAs.add(as1);
        listeAs.add(as2);
        listePourcentage.add(1f);

        Assertions.assertFalse(ac.enrgComposition(listeAs, listePourcentage));
    }

}
