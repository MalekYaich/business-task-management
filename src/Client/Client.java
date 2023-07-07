package Client;
import java.rmi.Naming;

public class Client {
	public static void main(String[] args)
	{
	try {
		System.out.println("je suis le client !");
		
		//InterfaceEmploye emp=(InterfaceEmploye)Naming.lookup("rmi://localhost:1099/employe");
		InterfaceTache tache=(InterfaceTache)Naming.lookup("rmi://localhost:1099/tache");

		
		System.out.println(tache.Read());
		
	} catch (Exception e) {
		e.printStackTrace();
	}

}}
