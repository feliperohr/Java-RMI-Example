import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {
        try {
            CalcAppImpl localObj = new CalcAppImpl(); // Cria o objeto que implementa o serviço

            Registry registry = LocateRegistry.getRegistry(); //Referencia do serviço do RMI na maquina.
            registry.bind("CalcAppRemote", localObj); //Faz o reistro do servidor no RMI Host

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
