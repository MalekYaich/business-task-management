package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface InterfaceTache extends Remote{
	
public void Create(String desc,int emp)throws RemoteException ;
public void Create(String desc)throws RemoteException ;

public String Read()throws RemoteException ;

public void Update(int id,String desc)throws RemoteException ;
public void Update(int id,int emp)throws RemoteException ;

public void Delete(int id)throws RemoteException ;

}
