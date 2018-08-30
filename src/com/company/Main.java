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
        Integer teste[] = new Integer[20];
        for(int i = 0; i < 20; i ++) {
            teste[i] = (20 - i);
        }
        Integer teste1[] = Arrays.copyOfRange(teste, 3, 6);

        for(Integer iterator: teste1){
            System.out.println(iterator);
        }
    }
}
