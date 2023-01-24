/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
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
