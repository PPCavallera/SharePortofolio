/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 *
 * @author perussel
 */
public class ActionComposee extends Action {

    // attribut lien
    Map<ActionSimple, Float> mapPanier;

    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }

    public boolean enrgComposition(List<ActionSimple> liAs, List<Float> pourcentages) {

        if (liAs == null || pourcentages == null) {
            return false;
        }
        if (liAs.size() != pourcentages.size()) {
            return false;
        }
        float sum = 0;
        for (float f : pourcentages) {
            if (f <= 0) {
                return false;
            }
            sum += f;
        }
        if (sum != 1) {
            return false;
        }
        this.mapPanier.clear();
        for (int i = 0; i < liAs.size(); i++) {
            ActionSimple currentAction = liAs.get(i);
            if (currentAction != null) {
                this.mapPanier.put(currentAction, pourcentages.get(i));
            } else {
                this.mapPanier.clear();
                return false;
            }
        }
        return true;
    }

    public boolean containsAction(ActionSimple a) {
        return this.mapPanier.containsKey(a);
    }

    @Override
    public float valeur(Jour j) {
        float valeur;

        valeur = 0;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }

        return valeur;
    }

}
