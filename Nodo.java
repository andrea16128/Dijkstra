import java.util.TreeMap;

public class Nodo {
    private String name;
    private int peso;
    private TreeMap<Nodo, Integer> collegamenti;
    private Nodo precedente;

    public Nodo(String name) {
        this.name = name;
        peso = Integer.MAX_VALUE;
        collegamenti = new TreeMap<>((a, b) -> a.name.compareTo(b.name));
        precedente = null;
    }
    public int calcolaPeso(Nodo nodo) {
        return peso + collegamenti.get(nodo);
    }

    public void collega(Nodo nodo, Integer peso) {
        collegamenti.put(nodo, peso);
        nodo.collegamenti.put(this, peso);
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public int getPeso() {
        return peso;
    }
    public void setPrecedente(Nodo precedente) {
        this.precedente = precedente;
    }
    public TreeMap<Nodo, Integer> getcollegamenti() {
        return collegamenti;
    }
    public String getPercorso() {
        String peso = "";

        if (this.peso < Integer.MAX_VALUE) {
            peso += this.peso;
        }

        String percorso = name + ": " + peso;
        if (precedente != null) {
            percorso = precedente.getPercorso() + "+" + precedente.collegamenti.get(this) + "\n" + percorso;
        }
        return percorso;
    }
}
