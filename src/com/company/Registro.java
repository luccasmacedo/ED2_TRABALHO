package com.company;

import java.util.ArrayList;

public class Registro
{
    private static ArrayList<Deputado> deputities = new ArrayList<Deputado>();

    Registro(String[] columns, int id)
    {
        registerDeputity(columns, id);
    }

    public void registerDeputity(String[] columns, int id)
    {
        if(!this.verifyDeputity(id))
            deputities.add(new Deputado(columns[5], columns[3], columns[4], Integer.parseInt(columns[2]), Integer.parseInt(columns[0]), this.getRecepit(columns)));
        else
            deputities.get(this.getIndex(id)).setReceipt(this.getRecepit(columns));
    }

    public Recibo getRecepit(String[] columns)
    {
        return new Recibo(columns[1], columns[6], columns[8], columns[7], Integer.parseInt(columns[9]));
    }

    private boolean verifyDeputity(int id)
    {
        for (Deputado deputity : deputities)
            if(deputity.getDeputyId() == id)
                return true;
            return false;
    }

    private int getIndex(int id)
    {
        for(int i = 0; i < deputities.size(); i++)
            if(deputities.get(i).getDeputyId() == id)
                return i;
            return -1;
    }
}
