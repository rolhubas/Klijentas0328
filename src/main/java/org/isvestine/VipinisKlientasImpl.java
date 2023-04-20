package org.isvestine;

import org.bazine.KlientasImpl;

import java.util.Comparator;

public class VipinisKlientasImpl extends KlientasImpl implements VipinisKlientas, Comparable<VipinisKlientasImpl> {
    private double procentas;
    private double priedas;

    public VipinisKlientasImpl(){

    }

    public VipinisKlientasImpl(int asmensKodas, int asmensAmzius, String valiuta, double indelis, double procentas, double priedas) {
        super(asmensKodas, asmensAmzius, valiuta, indelis);
        this.procentas = procentas;
        this.priedas = priedas;
    }

    @Override
    public double getProcentas() {
        return procentas;
    }

    @Override
    public void setProcentas(double procentas) {
        this.procentas = procentas;
    }

    @Override
    public double getPriedas() {
        return priedas;
    }

    @Override
    public void setPriedas(double priedas) {
        this.priedas = priedas;
    }

    @Override
    public int compareTo(VipinisKlientasImpl o) {
        return Comparator
                .comparing(VipinisKlientasImpl ::getIndelis)
                .reversed()
                .thenComparing(VipinisKlientasImpl ::getAsmensAmzius )
                .compare(this,o);
    }

    @Override
    public String toString() {
        return super.toString() +
                " procentas " + procentas +
                " priedas " + priedas ;

    }
}
