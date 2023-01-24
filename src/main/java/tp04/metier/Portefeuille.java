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
        this.mapLignes = new HashMap();
    }

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

    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a) == true) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }
        }
    }

    public String toString() {
        return this.mapLignes.toString();
    }

    public float valeur(Jour j) {
        float total = 0;
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
