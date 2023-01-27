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
public class Portefeuille {

    Map<Action, LignePortefeuille> mapLignes;

    private class LignePortefeuille {

        private Action action;

        private int qte;

        public int getQte() {
            return qte;
        }

        public void setQte(int qte) {
            this.qte = qte;
        }

        public Action getAction() {
            return this.action;
        }

        public LignePortefeuille(Action action, int qte) {
            this.action = action;
            this.qte = qte;
        }

        public String toString() {
            return Integer.toString(qte);
        }
    }

    public Portefeuille() {
        this.mapLignes = new HashMap<Action, LignePortefeuille>();
    }

    /**
     * Obtention de l'action d'une ligne de protefeuillee donné
     *
     * @param a, l'action
     * @return l'action si l'action existe, -1 sinon
     */
    public Action getAction(Action a) {
        LignePortefeuille currentAction = this.mapLignes.get(a);
        if (a != null && currentAction != null) {
            return currentAction.getAction();
        }
        return null;

    }

    /**
     * Get the global value for a given day
     * 
     * @param j, the day
     * @return the global value for j
     */
    public float getGlobalValue(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total += lp.getQte() * lp.getAction().valeur(j);
        }
        return total;
    }

    /**
     * Obtention de la quantité d'une ligne de protefeuillee donné
     *
     * @param a, l'action
     * @return la quatité si l'action existe, -1 sinon
     */
    public int getQuantite(Action a) {

        LignePortefeuille currentLine = this.mapLignes.get(a);
        if (a != null && currentLine != null) {
            return currentLine.getQte();
        }
        return -1;
    }

    /**
     * Fonction d'achat d'action
     *
     * @param a, l'action
     * @param q, la quantité achetée
     * @return l'action si elle est achetée, null sinon
     */
    public Action acheter(Action a, int q) {
        if (q > 0 && a != null) { //
            if (!this.mapLignes.containsKey(a)) {

                this.mapLignes.put(a, new LignePortefeuille(a, q));

                return a;
            } else {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
                return a;
            }
        } else {
            return null;
        }
    }

    /**
     * Fonction de vente d'action
     *
     * @param a, Action à vendre
     * @param q, Quantite à vendre
     *           @return, a si l'action a étévendue, null sinon
     */
    public Action vendre(Action a, int q) {
        Action returnedAction = null;
        if (this.mapLignes.containsKey(a)) {
            final int currentQte = this.mapLignes.get(a).getQte();
            if (currentQte > q) {
                this.mapLignes.get(a).setQte(currentQte - q);
                returnedAction = a;
            } else if (currentQte == q) {
                this.mapLignes.remove(a);
                returnedAction = a;
            }
        }
        return returnedAction;
    }

    public String toString() {
        return this.mapLignes.toString();
    }

    public double valeur(Jour j) {
        double total = 0.;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }

    /**
     * Returns the qte of action if it exists in the Protefeuille If the actions
     * does not exists in the Portefeuille, returns 0
     *
     * @param action
     * @return The quantity in the Portefeuille or 0.
     */
    public int getQteAction(Action action) {
        final LignePortefeuille lp = this.mapLignes.get(action);
        if (lp != null) {
            return lp.getQte();
        } else {
            return 0;
        }
    }
}
