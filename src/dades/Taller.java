package dades;

public class Taller extends Activitat {

    private String hora;
    private int durada, capacitat;
    private int totalPuntuacions, numPuntuacions;
    
    public Taller(String entitat, String nom_activitat, String lloc, int codi_postal, int dia, String hora, int durada, int capacitat) {
        super(entitat, nom_activitat, lloc, codi_postal, dia);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
        this.totalPuntuacions = 0;
        this.numPuntuacions = 0;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    protected Taller copia(){
        return new Taller(entitat, nom_activitat, lloc, codi_postal, dia, hora, durada, capacitat);
    }

    @Override
    public String toString() {
        return super.toString()+", hora=" + hora + ", durada=" + durada + ", capacitat=" + capacitat + ", totalPuntuacions="
                + totalPuntuacions + ", numPuntuacions=" + numPuntuacions + "]";
    }

    


    
}
