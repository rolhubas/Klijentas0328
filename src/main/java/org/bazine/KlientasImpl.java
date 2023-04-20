package org.bazine;

public class KlientasImpl implements Klientas {
    private int asmensKodas;
    private int asmensAmzius;
    private String valiuta;
    private double indelis;
    public KlientasImpl(){

    }

    public KlientasImpl(int asmensKodas, int asmensAmzius, String valiuta, double indelis) {
        this.asmensKodas = asmensKodas;
        this.asmensAmzius = asmensAmzius;
        this.valiuta = valiuta;
        this.indelis = indelis;
    }

    @Override
    public int getAsmensKodas() {
        return asmensKodas;
    }


    @Override
    public int getAsmensAmzius() {
        return asmensAmzius;
    }


    @Override
    public String getValiuta() {
        return valiuta;
    }

    @Override
    public void setValiuta(String valiuta) {
        this.valiuta = valiuta;
    }

    @Override
    public double getIndelis() {
        return indelis;
    }

    @Override
    public void setIndelis(double indelis) {
        this.indelis = indelis;
    }

    @Override
    public String toString() {
        return "Klientas " +
                " Asmens Kodas " + asmensKodas +
                " Amzius " + asmensAmzius +
                " valiuta " + valiuta  +
                " indelis " + indelis ;
    }
}
