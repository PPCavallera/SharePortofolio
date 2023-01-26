/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
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
