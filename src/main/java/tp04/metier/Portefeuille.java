/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.Collection;
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

    /**
     * Obtention de l'action d'une ligne de protefeuillee donné
     *
     * @param a, l'action
     * @return l'action si l'action existe, -1 sinon
     */
    public Action getAction(Action a) {

        if (a != null && this.mapLignes.get(a) != null) {
            return this.mapLignes.get(a).getAction();
        } else {
            return null;
        }
    }

    public float getGlobalValue(Jour j) {
        float total = 0;
        for (Map.Entry<Action, LignePortefeuille> entry : this.mapLignes.entrySet()) {
            LignePortefeuille value = entry.getValue();
            total += value.getQte() * value.getAction().valeur(j);
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

        if (a != null && this.mapLignes.get(a) != null) {
            return this.mapLignes.get(a).getQte();
        } else {
            return -1;
        }
    }

    public void acheter(Action a, int q) {
        if (this.mapLignes.containsKey(a) == false) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    /**
     * Fonction de vente d'action
     *
     * @param a, Action à vendre
     * @param q, Quantite à vendre
     * @return, a si l'action a étévendue, null sinon
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

    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }
}
