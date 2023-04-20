package org.example;

import org.isvestine.VipinisKlientasImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<VipinisKlientasImpl> klientuSarasas = new ArrayList<>();
        klientuSarasas.add(new VipinisKlientasImpl(399852741, 25, "EUR", 300, 12, 0.01));
        klientuSarasas.add(new VipinisKlientasImpl(399852568, 40, "EUR", 500, 11, 0.06));
        klientuSarasas.add(new VipinisKlientasImpl(399852789, 32, "EUR", 300, 17, 0.05));
        klientuSarasas.add(new VipinisKlientasImpl(399852236, 22, "EUR", 90, 10, 0.04));
        klientuSarasas.add(new VipinisKlientasImpl(399852123, 18, "EUR", 255, 12, 0.07));
        klientuSarasas.add(new VipinisKlientasImpl(398523694, 30, "EUR", 300, 15, 0.09));
        klientuSarasas.add(new VipinisKlientasImpl(398569321, 65, "EUR", 110, 8, 0.02));
        klientuSarasas.add(new VipinisKlientasImpl(395698322, 50, "EUR", 600, 10, 0.02));
        klientuSarasas.add(new VipinisKlientasImpl(389654777, 45, "EUR", 900, 18, 0.06));
        klientuSarasas.add(new VipinisKlientasImpl(392365847, 60, "EUR", 90, 5, 0.07));

        System.out.println("\n****** Klientu sarasas ******\n");
        spausdintiKlientusarasa(klientuSarasas);

        System.out.println("\n Svenciu proga klientu kuriu priedas 0.06 pakeiciamas i 0.08\n");
        pakeistiPrieda(klientuSarasas, 0.06);
        spausdintiKlientusarasa(klientuSarasas);
        //2.3. Surūšiuoti klientus mažėjimo tvarka pagal indėlio sumą, jeigu indėlio suma vienoda, pagal amžių; 1 BALAS
        System.out.println(" \nSurūšiuoti klientai mažėjimo tvarka pagal indėlio sumą, jeigu indėlio suma vienoda, pagal amžių\n");
        Collections.sort(klientuSarasas);
        spausdintiKlientusarasa(klientuSarasas);
        System.out.println("\n Pašalinami iš sarašo klientai, kurių indėlio suma neviršija 100 EUR \n");
        pasalintiKlienta(klientuSarasas, 100);
        spausdintiKlientusarasa(klientuSarasas);
        System.out.println("\n  Sukeistos indėliu SUMOS tarpusavyje tų klientų, kurie turi mažiausią ir dydžiausią indėlio sumą \n");
        sukeistiIndelius(klientuSarasas);
        spausdintiKlientusarasa(klientuSarasas);

        //rastiAtspausdintiKlienta_pagalAsmensKoda(klientuSarasas);
        rastiAtspausdintiKlienta_pagalAsmensKoda2(klientuSarasas);


    }

    /**
     * Funkcija atvaizduoja vartotojui klientu sarasa
     *
     * @param sarasas
     */
    public static void spausdintiKlientusarasa(ArrayList<VipinisKlientasImpl> sarasas) {
        for (VipinisKlientasImpl klientas : sarasas)
            System.out.println(klientas);
    }

    /**
     * Funkcija Pakeicianti prieda i kita prieda
     *
     * @param sarasas klientu sarasas
     * @param priedas preidas kuri norime pakeisti
     */
    public static void pakeistiPrieda(ArrayList<VipinisKlientasImpl> sarasas, double priedas) {
       // Iterator<VipinisKlientasImpl> i = sarasas.iterator();
        for (VipinisKlientasImpl klientas : sarasas) {
            if (klientas.getPriedas() == priedas) {
                klientas.setPriedas(0.08);
            }
        }
    }

    /**
     * Funkcija skirta rasti klienta pagal asmens koda vartotujui ivedus
     * ir atspausdina paieskos rezultatus
     *
     * @param sarasas paduodamas klientu sarasas
     */
    static void rastiAtspausdintiKlienta_pagalAsmensKoda(ArrayList<VipinisKlientasImpl> sarasas) {
        System.out.println("  <- Kliento paieska -> \n ( Iveskite asmens koda )");
        Scanner scanner = new Scanner(System.in);
        int klavetura = Integer.parseInt(scanner.next());
        Iterator<VipinisKlientasImpl> i = sarasas.iterator();
        System.out.println("*** Rezultatas ***\n");
        while (i.hasNext()) {
            VipinisKlientasImpl klientas = i.next();
            if (klientas.getAsmensKodas() == klavetura) {
                System.out.println(klientas);
            }
        }
    }

    static void rastiAtspausdintiKlienta_pagalAsmensKoda2(ArrayList<VipinisKlientasImpl> sarasas) {
        System.out.println("  <- Kliento paieska -> \n ( Iveskite asmens koda )");
        Scanner scanner = new Scanner(System.in);
        try {


            int klavetura = Integer.parseInt(scanner.next());


            Iterator<VipinisKlientasImpl> i = sarasas.iterator();


            System.out.println("*** Rezultatas ***\n");
            while (i.hasNext()) {
                VipinisKlientasImpl klientas = i.next();
                if (klientas.getAsmensKodas() == klavetura) {
                    System.out.println(klientas);
                }
            }
        } catch (NumberFormatException klaida) {
            klaida.getMessage();
            System.out.println(" Klaida: Iveskite skaicius ! ");
            System.exit(0);
        }
    }

    /**
     * Funkcija pasalina klienta pagal indelio dydi
     *
     * @param sarasas Klientu sarasas
     * @param indelis indelio dydis iki kurio bus salinami dydziai
     */
    public static void pasalintiKlienta(ArrayList<VipinisKlientasImpl> sarasas, double indelis) {
        Iterator<VipinisKlientasImpl> i = sarasas.iterator();
        while (i.hasNext()) {
            VipinisKlientasImpl klientas = i.next();
            if (klientas.getIndelis() < indelis) {
                i.remove();
            }
        }
    }

    /**
     * Funkcija sukeicia indelius vietomis, maziausia indeli su diziausiu indeliu
     *
     * @param sarasas naudojamas klientu sarasas
     */
    public static void sukeistiIndelius(ArrayList<VipinisKlientasImpl> sarasas) {
        double max = Collections.min(sarasas).getIndelis();
        double min = Collections.max(sarasas).getIndelis();

        for (VipinisKlientasImpl klientas : sarasas) {
            if (klientas.getIndelis() == min) {
                klientas.setIndelis(max);

            } else if (klientas.getIndelis() == max) {
                klientas.setIndelis(min);

            }
        }
    }

}