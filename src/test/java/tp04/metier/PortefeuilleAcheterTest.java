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

public class PortefeuilleAcheterTest {
    
    public PortefeuilleAcheterTest() {
    }

    @Test
    public void testAcheter() {
        final Portefeuille p = new Portefeuille();
        final Action act = new ActionSimple("edf");
        final int nb = 5;
        final int actExpected = p.getQteAction(act) + nb;
        p.acheter(act, nb);
        Assertions.assertEquals(actExpected,p.getQteAction(act));
    }
    @Test
    public void testAcheter2() {
        final Portefeuille p = new Portefeuille();
        final Action act = new ActionSimple("edf");
        final int nb = 5;
        final Action a = p.acheter(act, nb);
        Assertions.assertEquals(act,a);
    }


    @Test
    public void testAcheterANouveau() {
        // init un portefeuille avec l'action
        final Portefeuille p = new Portefeuille();
        final Action act = new ActionSimple("edf");
        final int nb1 = 5;
        final int nb2 = 5;
        final int initial_qte = p.getQteAction(act);

        p.acheter(act, nb1);
        
        // rajouter qte pr cette action
        p.acheter(act, nb2);
        final int actExpected = initial_qte + nb1 + nb2;
        Assertions.assertEquals(actExpected,p.getQteAction(act));
    }
    
    @Test
    public void testAcheterNegatif() {
        // init un portefeuille avec l'action
        final Portefeuille p = new Portefeuille();
        final Action act = new ActionSimple("edf");
        final Action new_act = p.acheter(act, -1);
        Assertions.assertNull(new_act);
    }


    @Test
    public void testAcheterZero() {
        // init un portefeuille avec l'action
        final Portefeuille p = new Portefeuille();
        final Action act = new ActionSimple("edf");
        final Action new_act = p.acheter(act, 0);
        Assertions.assertNull(new_act);
    }
    
    @Test
    public void testAcheterNull() {
        // init un portefeuille avec l'action
        final Portefeuille p = new Portefeuille();
        final Action new_act = p.acheter(null, 10);
        p.acheter(null,5);
        Assertions.assertNull(new_act);
    }
}
