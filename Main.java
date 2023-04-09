import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] nomi =  new String[]{"Casa", "A", "B", "C", "D", "E", "Ufficio"};
        Nodo[] nodi = new Nodo[7];

        for(int i = 0; i<7; i++){
            nodi[i] = new Nodo(nomi[i]);
        }

        Set<Nodo> visitati = new HashSet<>();
        PriorityQueue<Nodo> daVisitare = new PriorityQueue<>((a, b) -> a.getPeso() - b.getPeso());

        nodi[0].setPeso(0);

        nodi[0].collega(nodi[1],2);
        nodi[0].collega(nodi[4],8);

        nodi[1].collega(nodi[2], 6);
        nodi[1].collega(nodi[3], 2);

        nodi[2].collega(nodi[6], 5);

        nodi[3].collega(nodi[5], 9);
        nodi[3].collega(nodi[4], 2);

        nodi[4].collega(nodi[5], 3);

        nodi[5].collega(nodi[6],1);

        daVisitare.offer(nodi[0]);

        while (!daVisitare.isEmpty()) {

            Nodo corrente = daVisitare.poll();
            visitati.add(corrente);
            for (Map.Entry<Nodo, Integer> entry : corrente.getcollegamenti().entrySet()) {

                Nodo vicino = entry.getKey();
                int distanza = corrente.calcolaPeso(vicino);
                if (!visitati.contains(vicino) && distanza < vicino.getPeso()) {

                    vicino.setPeso(distanza);
                    vicino.setPrecedente(corrente);
                    daVisitare.offer(vicino);
                }
            }
        }

        System.out.println(nodi[6].getPercorso());
    }
}