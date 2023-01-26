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
 */
public class ActionComposee extends Action {

    // attribut lien
    Map<ActionSimple, Float> mapPanier;

    /**
     * Action composee constructor
     * 
     * @param libelle 
     */
    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }

    /**
     * Register action function 
     * @param liAs
     * @param pourcentages
     * @return true if everything went ok, else false
     */
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

    /**
     * Contains action
     * @param a
     * @return true if a in ac, else false
     */
    public boolean containsAction(ActionSimple a) {
        return this.mapPanier.containsKey(a);
    }

    /**
     * Get global value for one day
     * @param j
     * @return the value for the day j
     */
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
