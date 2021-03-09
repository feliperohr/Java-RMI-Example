import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcAppRemote extends Remote {

    public int sum(int a, int b) throws RemoteException;

    public String factorial(int a) throws RemoteException;

    public boolean isPrimeNumber(int a) throws RemoteException;

}
