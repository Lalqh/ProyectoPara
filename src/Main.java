import java.rmi.Remote;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
            Registry rmii = java.rmi.registry.LocateRegistry.createRegistry(5000);
            rmii.rebind("MergeSort", (Remote) new implementacionRMI());
            System.out.println("Servdior activo...");
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
