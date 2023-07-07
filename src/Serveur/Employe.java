package Serveur;


import java.rmi.RemoteException;
import java.sql.*;
import java.rmi.server.UnicastRemoteObject;

public class Employe extends UnicastRemoteObject implements InterfaceEmploye{
	
	Statement st;

	protected Employe() throws RemoteException {
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

	public void Create(String nom, String prenom,String adresse,long numerocpt,int grade,int superieur) throws RemoteException {
		try {
			st.executeUpdate("INSERT INTO employe"+" VALUES (NULL, " +nom+ ", "+prenom+ ","+ adresse+", "+String.valueOf(numerocpt)+","+String.valueOf(grade)+" , "+String.valueOf(superieur) +");");
			
			System.out.print("employe inseré avec succes !");
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
	}

	@Override
	public void Create(String nom, String prenom) throws RemoteException {
		try {
			st.executeUpdate("INSERT INTO `employe` VALUES (NULL, '"+ nom +"', '"+ prenom +"', NULL, NULL, NULL, NULL)");

			System.out.println("employe inseré avec succes !");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}


	public String Read () throws RemoteException {
		
		String affichage = "id     Nom     Prenom     Adresse          num compte     grade     superieur \n --------------------------------------------------------------\n";
		try {
			ResultSet res = st.executeQuery("select * from employe ;");
			
				while (res.next())
				{ 
					 affichage +=(res.getString(1)+"      "+res.getString(2)+"     "+res.getString(3)+"          "+res.getString(4)+"     "+res.getString(5)+"     "+res.getString(6)+"     "+res.getString(7)+'\n');
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return affichage;

	}



	@Override
	public void Update(int id,String nom, String prenom,String adresse,long numerocpt,int grade,int superieur) throws RemoteException {
		try {
 
			st.executeUpdate("UPDATE `employe` SET `nom` = "+ nom+", `prenom` = "+prenom+", `adresse` = "+adresse+", `numero_compte` = "+numerocpt+", `grade` = "+grade+", `supérieur` = "+superieur+" WHERE `employe`.`id_employe` = "+id);

			System.out.println("employe supprimé avec succes !");
					
		} catch (Exception e) {
		e.printStackTrace();
		}			
}

	

	@Override
	public void Delete(int id) throws RemoteException {
		
		try {
				st.executeUpdate("DELETE FROM employe WHERE `employe`.`id_employe` ="+id );

				System.out.println("employe supprimé avec succes !");
						
			} catch (Exception e) {
			e.printStackTrace();
			}			
	}




}
