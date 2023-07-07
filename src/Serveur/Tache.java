package Serveur;


import java.rmi.RemoteException;
import java.sql.*;
import java.rmi.server.UnicastRemoteObject;

public class Tache extends UnicastRemoteObject implements InterfaceTache{
	
	Statement st;

	protected Tache() throws RemoteException {
		super();
		try {
			//creer une connexion mysql
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/entreprise","root","");
			// creer un etat de connexion pour executer les requetes sql
			 st =cnx.createStatement();
			
		}catch(Exception e) {
			System.out.println("error : "+e.getMessage());
		}

	}

	public void Create(String desc,int emp) throws RemoteException {
		try {
			st.executeUpdate("INSERT INTO `tache`VALUES (NULL, "+desc+","+emp );
			System.out.print("employe inseré avec succes !");
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
	}

	@Override
	public void Create(String desc) throws RemoteException {
		try {
			st.executeUpdate("INSERT INTO `tache`VALUES (NULL, "+desc+",NULL" );
			System.out.println("employe inseré avec succes !");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}


	public String Read () throws RemoteException {
		
		String affichage = "\nid       Desciption                          Employe \n--------------------------------------------------------\n";
		try {
			ResultSet res = st.executeQuery("select * from tache ;");
			
				while (res.next())
				{ 
					 affichage +=(res.getString(1)+"        "+res.getString(2)+"      "+res.getString(3)+'\n');
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return affichage;

	}



	@Override
	public void Update(int id,int emp) throws RemoteException {
		try {
 
			st.executeUpdate("UPDATE `tache` SET `id_employe` = "+emp+"WHERE `tache`.`id_tache` = "+id);

			System.out.println("Tache modifiée avec succes !");
					
		} catch (Exception e) {
		e.printStackTrace();
		}			
}

	public void Update(int id,String desc) throws RemoteException {
		try {
 
			st.executeUpdate("UPDATE `tache` SET `Description` = "+desc+"WHERE `tache`.`id_tache` = "+id);

			System.out.println("Tache modifiée avec succes !");
					
		} catch (Exception e) {
		e.printStackTrace();
		}			
}

	

	@Override
	public void Delete(int id) throws RemoteException {
		
		try {
				st.executeUpdate("DELETE FROM tache WHERE `tache`.`id_tache` = "+id );

				System.out.println("Tache supprimée avec succes !");
						
			} catch (Exception e) {
			e.printStackTrace();
			}			
	}




}
