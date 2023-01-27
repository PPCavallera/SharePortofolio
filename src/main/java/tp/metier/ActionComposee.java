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

import java.math.BigDecimal;
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
        boolean pass_rules = this.verifyComposition(liAs, pourcentages);
        if (pass_rules) {
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
        } else {
            return false;
        }

    }

    public boolean verifyComposition(List<ActionSimple> liAs, List<Double> pourcentages) {

        boolean to_return = true;

        // handle null.
        if (liAs == null || pourcentages == null) {
            to_return = false;
        }

        // confirm that the two lists are of equal size.
        if (to_return && liAs.size() != pourcentages.size()) {
            to_return = false;
        }

        if (to_return) {
            // confirm that the percentages sum to one.
            BigDecimal sum = new BigDecimal(0.0);
            for (double f : pourcentages) {
                if (f <= 0) {
                    to_return = false;
                }
                sum.add(new BigDecimal(f));
            }

            final BigDecimal one = new BigDecimal(1.0);
            if (sum.equals(one)) {
                to_return = false;
            }
            return to_return; // if all passed, this variable is still true
        } else {
            return to_return;
        }

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
        for (Map.Entry<ActionSimple, Double> entry : this.mapPanier.entrySet()) {
            valeur = valeur + (entry.getKey().valeur(j) * entry.getValue());
        }

        return valeur;
    }

}
