package rmiServer;

import rmiService.BanqueImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BanqueServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            BanqueImpl obj = new BanqueImpl();
            Naming.rebind("rmi://localhost:1099/BanqueService", obj);
            System.out.println("Serveur banque prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}