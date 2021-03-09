import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcAppImpl extends UnicastRemoteObject implements CalcAppRemote {

    public CalcAppImpl() throws RemoteException{}

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public String factorial(int a) throws RemoteException {
        int f = 1;
        int c = a;
        String s = "";
        while (c > 1) {
            f *= c;
            s += c + " x " ;
            c--;
        }
        s += c;

        return s + " = " + f;
    }

    @Override
    public boolean isPrimeNumber(int a) throws RemoteException {
        for (int j = 2; j < a; j++) {
            if (a % j == 0)
                return false;
        }
        return true;
    }
}
