package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceEmploye extends Remote{
public void Create(String nom, String prenom,String adresse,long numerocpt,int grade,int superieur)throws RemoteException ;
public void Create(String nom, String prenom)throws RemoteException ;

public String Read()throws RemoteException ;
public void Update(int id,String nom, String prenom,String adresse,long numerocpt,int grade,int superieur)throws RemoteException ;
public void Delete(int id)throws RemoteException ;

}
