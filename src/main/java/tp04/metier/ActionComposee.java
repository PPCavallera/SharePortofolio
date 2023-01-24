/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;

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

    public ActionSimple enrgComposition(ActionSimple as, float pourcentage) {
        ActionSimple returnedAction = null;
        if (pourcentage > 0 & as != null) {
            this.mapPanier.put(as, pourcentage);
            returnedAction = as;
        }
        return returnedAction;
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
