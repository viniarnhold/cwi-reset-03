package br.com.cwi.reset.projeto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {
        int soma = 0;
        for(int numero : numeros){
            soma += numero;
        }
        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        int soma = 0;
        for(int numero : numeros){
            soma += numero;
        }
        double media = soma / numeros.size();
        return media;
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        int maiorNumero = 0;
        for(int numero : numeros){
            if(numero>maiorNumero){
                maiorNumero = numero;
            }
        }
        return maiorNumero;
    }

    public String obterPalavraInvertida(String palavra) {
        String palavraInvertida = "";
        for(int i = palavra.length()-1;i>=0 ;i--){
            palavraInvertida += palavra.charAt(i);
        }

        return palavraInvertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        for(int i = 0; i < numeros.size()-1 ; i++) {
            for (int j = 0; j < (numeros.size() - i - 1); j++) {
                if(numeros.get(j) > numeros.get(j+1)){
                    int aux = numeros.get(j);
                    numeros.set(j, numeros.get(j+1));
                    numeros.set(j+1, aux);
                }
            }
        }
        return numeros;
    }
}

