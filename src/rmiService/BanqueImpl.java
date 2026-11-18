package rmiService;

import metier.Compte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {

    private Map<Integer, Compte> comptes = new HashMap<>();

    public BanqueImpl() throws RemoteException {
        super();
    }

    @Override
    public synchronized String creerCompte(Compte c) throws RemoteException {
        if (comptes.containsKey(c.getCode())) {
            return "Erreur : le compte " + c.getCode() + " existe déjà.";
        }
        comptes.put(c.getCode(), c);
        return "Compte " + c.getCode() + " créé avec un solde de " + c.getSolde();
    }

    @Override
    public synchronized String getInfoCompte(int code) throws RemoteException {
        Compte c = comptes.get(code);
        if (c == null) {
            return "Erreur : le compte " + code + " est introuvable.";
        }
        return "Code : " + c.getCode() + " | Solde : " + c.getSolde()
                + " | Créé le : " + c.getDateCreation();
    }
}