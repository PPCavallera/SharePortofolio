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

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 *
 * @author perussel
 * @author Camilo De La Torre
 * @author Thibaut Denis
 */

public class ActionComposee extends Action {

    // Storage for shares that make the composed share.
    Map<ActionSimple, Double> mapPanier;

    /**
     * Action composee constructor
     * 
     * @param libelle : Le nom de l'action.
     */
    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap<ActionSimple, Double>();
    }

    /**
     * Compose a share with the simple actions in liAs.
     * 
     * For each action, a percentage has to be provided.
     * 
     * Overall, the sum o the given percentages has to sum to 1.
     * 
     * A call to this function always clears the stored actions (if any) in the
     * instance.
     * 
     * @param liAs         List of actions that compose the action compose
     * @param pourcentages : Double indicating the pct of the share with respect to
     *                     the total percentage (100%)
     * @return true if shares where correctly saved. False if not.
     */
    public boolean enrgComposition(List<ActionSimple> liAs, List<Double> pourcentages) {

        // handle null.
        if (liAs == null || pourcentages == null) {
            return false;
        }

        // confirm that the two lists are of equal size.
        if (liAs.size() != pourcentages.size()) {
            return false;
        }

        // confirm that the percentages sum to one.
        double sum = 0.0;
        for (double f : pourcentages) {
            if (f <= 0) {
                return false;
            }
            sum += f;
        }
        final double one = 1.0;
        if (sum != one) {
            return false;
        }

        // clear the precedent map.
        this.mapPanier.clear();

        // Fill the map with the simple shares.
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

    /**
     * Check if the map of the instance contains a given simple share.
     * 
     * @param a : A simple share.
     * @return true if a in map, else false
     */
    public boolean containsAction(ActionSimple a) {
        return this.mapPanier.containsKey(a);
    }

    /**
     * Get global value for one day
     * 
     * @param j : A day
     * @return the value for the day j
     */
    @Override
    public Double valeur(Jour j) {
        double valeur;

        valeur = 0;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }

        return valeur;
    }

}
