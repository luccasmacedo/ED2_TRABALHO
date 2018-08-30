package com.company;

public class THash
{
    int[] hashVetor = new int[5];
    int[] valores = {8, 1, 1, 2, 5};
    int n = 5;

    public void insere(int n)
    {
        int k = 0;
        for(int i = 0; i < n; i++)
        {
            k = this.hashVetor[hash(valores[i])];
            if(k == 0)
                this.hashVetor[k] = valores[i];
            else
            {
                
                //sondagemLinear(k, )
            }
        }
    }

    public int hash(int k)
    {
        return k % this.n;
    }

    public int sondagemLinear(int k, int colisoes)
    {
        return 0;
    }
}
