package Serveur;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Serveur {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			Employe emp = new Employe();
			Tache tache = new Tache();
			System.out.println("serveur en attente ...");
			
			Naming.rebind("rmi://localhost:1099/employe", emp);
			Naming.rebind("rmi://localhost:1099/tache", tache);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
