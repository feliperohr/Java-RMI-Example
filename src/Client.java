import java.rmi.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String host = "localhost";
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao app! ");
        System.out.println("Escolha uma opção para continuar: ");

        /*
        Na loda do cliente, é usada da classe estatica Naming, que provem o lookup(), que é oque retorna para o
        cliente o registo (registry do servidor) dentro do RMI Registry.
        O resultado é um objeto que expoem e executa as chamadas para metodos no servidor.
         */
        CalcAppRemote remObj = (CalcAppRemote) Naming.lookup("rmi://"+host+"/CalcAppRemote");

        boolean aux = false;
        while (!aux){
            System.out.println("1 - Calcular a soma de 2 numeros.");
            System.out.println("2 - Calcular fatorial de um numero.");
            System.out.println("3 - Verifique se um numero é primo.");
            System.out.println("0 - Sair.");

            int a =0;
            int b =0;

            switch (sc.nextInt()){
                case 0:
                    System.out.println ("Até mais!");
                    aux = true;
                    break;
                case 1:
                    System.out.print("valor 1:  ");
                    a = sc.nextInt();

                    System.out.println("");

                    System.out.print("valor 2:  ");
                    b = sc.nextInt();
                    System.out.println("");
                    System.out.println(remObj.sum(a,b));

                    break;

                case 2:
                    System.out.print("Calcular o fatorial de:  ");
                    a = sc.nextInt();
                    System.out.println("");
                    System.out.println(remObj.factorial(a));

                    break;

                case 3:
                    System.out.print("Insira o valor que deseja verificar:  ");
                    a = sc.nextInt();
                    System.out.println("");
                    System.out.println(remObj.isPrimeNumber(a));
                    break;
            }

            System.out.println("");
            System.out.println(" --------------------------------------------------- ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();

        }

    }
}
