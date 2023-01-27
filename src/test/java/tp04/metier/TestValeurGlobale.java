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

/**
 *
 * @author PPC
 */
public class TestValeurGlobale {

    @Test
    public void testRecupValeurGlobalePlsrsJours() {
        final Portefeuille po = new Portefeuille();
        final ActionSimple as1 = new ActionSimple("Toto");
        final ActionSimple as2 = new ActionSimple("Tata");
        final Jour j1 = new Jour(2023, 1);
        final Jour j2 = new Jour(2023, 2);

        as1.enrgCours(j1, 1.);
        as2.enrgCours(j1, 2.);
        as1.enrgCours(j2, 4.);
        as2.enrgCours(j2, 5.);

        po.acheter(as1, 2);
        po.acheter(as2, 3);

        Assertions.assertEquals(8, po.getGlobalValue(j1));
        Assertions.assertEquals(23, po.getGlobalValue(j2));
    }

    @Test
    public void testRecupValeurGlobale() {
        final Portefeuille po = new Portefeuille();
        final ActionSimple as = new ActionSimple("Toto");
        final ActionSimple as2 = new ActionSimple("Tata");
        final Jour j = new Jour(2023, 1);
        as.enrgCours(j, 1.);
        as2.enrgCours(j, 2.);
        po.acheter(as, 1);
        po.acheter(as2, 1);

        Assertions.assertEquals(3, po.getGlobalValue(j));
    }

    @Test
    public void testRecupValeurGlobaleJourAbsent() {
        final Portefeuille po = new Portefeuille();
        final ActionSimple as1 = new ActionSimple("Toto");
        final ActionSimple as2 = new ActionSimple("Tata");
        final Jour j1 = new Jour(2023, 1);
        final Jour j3 = new Jour(2023, 2);

        as1.enrgCours(j1, 1.);
        as2.enrgCours(j1, 2.);

        po.acheter(as1, 2);
        po.acheter(as2, 3);

        Assertions.assertEquals(0, po.getGlobalValue(j3));
    }

    @Test
    public void testRecupValeurGlobaleJourNull() {
        final Portefeuille po = new Portefeuille();

        Assertions.assertEquals(0, po.getGlobalValue(null));
    }
}
