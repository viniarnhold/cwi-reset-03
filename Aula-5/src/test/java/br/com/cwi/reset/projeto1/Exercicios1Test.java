package br.com.cwi.reset.projeto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Exercicios1Test {

    @Test
    public void testSomaNumerosInteirosPositivos(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        Integer expected = 15;

        //Action
        Integer result = exercicios1.somarLista(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaQuatroNumerosInteirosPositivosUmNegativo(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList(1,2,3,4,-5);
        Integer expected = 5;

        //Action
        Integer result = exercicios1.somarLista(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaTresNegativos(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList(-5,-3,-2);
        Integer expected = -10;

        //Action
        Integer result = exercicios1.somarLista(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaTodosZero(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList(0,0,0,0);
        Integer expected = 0;

        //Action
        Integer result = exercicios1.somarLista(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaListaVazia(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList();
        Integer expected = 0;

        //Action
        Integer result = exercicios1.somarLista(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaNumerosInteirosPositivos(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        Double expected = 3.0;

        //Action
        Double result = exercicios1.calcularMedia(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaQuatroNumerosInteirosPositivosUmNegativo(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList(1,2,3,4,-5);
        Double expected = 1.0;

        //Action
        Double result = exercicios1.calcularMedia(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaTresNegativos(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList(-5,-3,-1);
        Double expected = -3.0;

        //Action
        Double result = exercicios1.calcularMedia(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaTodosZero(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList(0,0,0,0);
        Double expected = 0.0;

        //Action
        Double result = exercicios1.calcularMedia(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaListaVazia(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        List<Integer> numeros = Arrays.asList();
        Double expected = 0.0;

        //Action
        Double result = exercicios1.calcularMedia(numeros);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testePalavraInvertidaAbacate(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        String expected = "etacabA";

        //Action
        String result = exercicios1.obterPalavraInvertida("Abacate");

        //Assert
        Assertions.assertEquals(expected, result);
        }

    @Test
    public void testePalavraInvertidaBanana(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        String expected = "ananaB";

        //Action
        String result = exercicios1.obterPalavraInvertida("Banana");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testePalavraInvertidaPessego(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        String expected = "ogesseP";

        //Action
        String result = exercicios1.obterPalavraInvertida("Pessego");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testePalavraInvertidaMorango(){
        //Arrange
        Exercicios1 exercicios1 = new Exercicios1();
        String expected = "ognaroM";

        //Action
        String result = exercicios1.obterPalavraInvertida("Morango");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testeOrdenacaoListaTodosPositivos(){
        //Arrange
        Exercicios1 exercicio1 = new Exercicios1();
        List<Integer> list = Arrays.asList(3,1,5,2,4,8);
        List<Integer> expected = Arrays.asList(1,2,3,4,5,8);
        //Action
        List<Integer> result = exercicio1.ordenarLista(list);

        //Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testeOrdenacaoListaTodosNegativos(){
        //Arrange
        Exercicios1 exercicio1 = new Exercicios1();
        List<Integer> list = Arrays.asList(-3,-1,-5,-2,-4,-8);
        List<Integer> expected = Arrays.asList(-8,-5,-4,-3,-2,-1);
        //Action
        List<Integer> result = exercicio1.ordenarLista(list);

        //Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testeOrdenacaoListaTresNegativosTresPositivos(){
        //Arrange
        Exercicios1 exercicio1 = new Exercicios1();
        List<Integer> list = Arrays.asList(-3,-1,-5,2,4,8);
        List<Integer> expected = Arrays.asList(-5,-3,-1,2,4,8);
        //Action
        List<Integer> result = exercicio1.ordenarLista(list);

        //Assert
        Assertions.assertEquals(expected, result);

    }

}
