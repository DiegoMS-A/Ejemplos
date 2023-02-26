import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumatorioExecutorService {

    public static void main(String args[]) {
        Long index1 = Long.parseLong(args[0]);
        Long index2 = Long.parseLong(args[1]);

        try {
            // Ordenamos los índices
            if (index1 > index2) {
                Long tmp = index1;
                index1 = index2;
                index2 = tmp;
            }

            // Particionamos el rango de valores

            Runtime runtime = Runtime.getRuntime();
            int num_processadores = runtime.availableProcessors();
            System.out.println("Dividiendo la tarea en " + num_processadores + " hilos");

            // Obtención de los rangos
            long incremento = ((index2 - index1) / (num_processadores - 1));

            ExecutorService servicio = Executors.newFixedThreadPool(num_processadores);

            // Definimos la lista de tareas
            List<Callable<Long>> listaSumas = new ArrayList<>();
            // La variable para el resultado
            long sumaTotal = 0;
            // Y la lista de Futures para los resultados
            List<Future<Long>> resultados = new ArrayList<>();

            // Creamos la lista de tareas
            for (int i = 0; i < num_processadores; i++) {

                long ini = index1 + incremento * i;
                long fin = index1 + incremento * (i + 1) - 1;
                if (fin > index2)
                    fin = index2;

                listaSumas.add(new Suma(ini, fin));
            }

            // Invocamos todas las tareas
            resultados = servicio.invokeAll(listaSumas);


            // Y calculamos la suma
            Iterator<Future<Long>> it=resultados.iterator();
            while (it.hasNext())
                try {
                    sumaTotal += it.next().get();
                } catch (InterruptedException | ExecutionException e) {
                    System.err.println(e.getStackTrace());
                }


            System.out.println("Suma total: " + sumaTotal);
            servicio.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
