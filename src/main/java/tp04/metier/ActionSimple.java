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

/**
 *
 * @author perussel
 */
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours;

    /**
     * ActionSimple constructor
     *
     * @param libelle
     */
    public ActionSimple(String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
        this.mapCours = new HashMap<Jour, Cours>();
    }

    /**
     * Register value for a day
     *
     * @param j, the day
     * @param v  , the value
     */
    public void enrgCours(Jour j, Double v) {
        if (this.mapCours.containsKey(j) == false) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }

    /**
     * Get the value for a given day
     * 
     * @param j the day
     * @return the value for the day
     */
    @Override
    public Double valeur(Jour j) {
        if (this.mapCours.containsKey(j) == true) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0.; // definition d'une constante possible
        }
    }

    // encapsulation de la définition de la classe Cours
    private class Cours {

        private Jour jour;

        private double valeur;

        public double getValeur() {
            return valeur;
        }

        public Jour getJour() {
            return jour;
        }

        public Cours(Jour jour, Double valeur) {
            this.jour = jour;
            this.valeur = valeur;
        }

    }
}
