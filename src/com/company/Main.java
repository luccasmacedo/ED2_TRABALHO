package com.company;

import javax.sound.midi.Receiver;
import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static int COLUNAS = 10;

    public static void main(String[] args) throws IOException
    {
        Leitura leitura = new Leitura(new Arquivo());
        //ArrayList<Deputado> deputados = leitura.getDeputityInfos(1);

        Integer teste1[] = Arrays.copyOfRange(leitura.getReceiptValues(), 3, 10);

//        for(Deputado deputado : deputados){
//            System.out.println("Nome: " + deputado.getDeputyName());
//            for(Recibo recibo : deputado.getReceipt())
//            {
//                System.out.println(recibo.getEstablishmentName());
//                System.out.println(recibo.getReceiptValue());
//                System.out.println(recibo.getReceiptDescription());
//            }
//            System.out.println();
//        }
    }
}
