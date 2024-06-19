import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class implementacionRMI extends UnicastRemoteObject implements DataRMI {

    private char[] sumaArreglos = null;

    public implementacionRMI() throws RemoteException {
        super();
    }

    public synchronized void recibirArray(char[] array) throws RemoteException {
        if (sumaArreglos == null) {
            sumaArreglos = array.clone();
        } else {
            char[] nuevoSumaArreglos = new char[sumaArreglos.length + array.length];
            System.arraycopy(sumaArreglos, 0, nuevoSumaArreglos, 0, sumaArreglos.length);
            System.arraycopy(array, 0, nuevoSumaArreglos, sumaArreglos.length, array.length);
            sumaArreglos = nuevoSumaArreglos;
        }
    }

    public synchronized char[] regresarArray() throws RemoteException {
        if (sumaArreglos != null) {
            Arrays.sort(sumaArreglos);
        }
        return sumaArreglos;
    }

    public synchronized void limpiar() throws RemoteException {
        sumaArreglos = null;
    }
}
