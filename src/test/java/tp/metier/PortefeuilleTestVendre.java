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
import tp.metier.Portefeuille;
import tp.metier.ActionComposee;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PPC
 */
public class PortefeuilleTestVendre {

    public PortefeuilleTestVendre() {
    }

    @Test
    public void testVendreAll() {
        final Portefeuille po = new Portefeuille();
        final ActionSimple as = new ActionSimple("Toto");
        po.acheter(as, 2);
        po.vendre(as, 2);
        Assertions.assertNull(po.getAction(as));

    }

    @Test
    public void testVendrePartial() {
        final Portefeuille po = new Portefeuille();
        final ActionSimple as = new ActionSimple("Toto");
        po.acheter(as, 2);
        po.vendre(as, 1);
        Assertions.assertEquals(1, po.getQuantite(as));
    }

    @Test
    public void testVendreNoPresence() {
        final Portefeuille po = new Portefeuille();
        final ActionSimple as = new ActionSimple("Toto");
        final ActionSimple as2 = new ActionSimple("Titi");
        po.acheter(as, 2);
        Assertions.assertNull(po.vendre(as2, 1));
    }

    @Test
    public void testVendreTROP() {
        final Portefeuille po = new Portefeuille();
        final ActionSimple as = new ActionSimple("Toto");
        po.acheter(as, 2);
        po.vendre(as, 3);
        Assertions.assertNull(po.vendre(as, 3));
    }

    @Test
    public void testVendreActionComposeeAll() {
        final Portefeuille po = new Portefeuille();

        ActionComposee ac = new ActionComposee("ac");
        ActionSimple as1, as2;
        as1 = new ActionSimple("as1");
        as2 = new ActionSimple("as2");
        List<ActionSimple> listeAs = new ArrayList<>();
        List<Double> listePourcentage = new ArrayList<>();
        listeAs.add(as1);
        listeAs.add(as2);
        listePourcentage.add(0.4);
        listePourcentage.add(0.6);

        ac.enrgComposition(listeAs, listePourcentage);
        po.acheter(ac, 4);
        Assertions.assertEquals(ac, po.getAction(ac));
        Assertions.assertEquals(4, po.getQuantite(ac));

    }

}
