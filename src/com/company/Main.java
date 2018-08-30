package com.company;

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

        Integer teste1[] = Arrays.copyOfRange(leitura.getReceiptValues(10), 3, 10);

        for(Integer iterator: teste1){
            System.out.println(iterator);
        }
    }
}
