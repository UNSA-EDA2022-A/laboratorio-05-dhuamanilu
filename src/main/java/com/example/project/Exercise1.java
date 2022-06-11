package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
        MyStack<Character> stack = new LinkedListStack<>();
        //Recorreremos todo el string s
        for(int i=0;i<s.length();i++) {
        	char c=s.charAt(i);
        	//para cada elemento de s,verificamos si es un corchete de apertura 
        	if(c=='(' || c=='[' || c=='{') {
        		//Si lo es,entonces lo agregamos a la pila
        		stack.push(s.charAt(i));
        	}
        	//Si no es de apertura
        	else {
        		//Entonces es de cierre,y verificaremos 2 cosas
        		//Si el elemento top de la pila es un corchete de abertura y el char actual es su respectivo corchete de cierre
        		boolean tieneAbertura=((stack.top()=='(' && c==')') || (stack.top()=='[' && c==']') || (stack.top()=='{' && c=='}'));
        		//Y además no esta vacia
        		if(!stack.isEmpty() && tieneAbertura) {
        			//Entonces el char actual tiene su abertura,retiramos esa abertura de la pila
        			stack.pop();
        		}
        		else {
        			//Si la pila esta vacia o no tiene abertura,entonces definitivamente s no esta balanceado y retornamos false
        			return false;
        		}
        	}
        }
        //Si al final del algoritmo la pila esta vacia,significa que s esta balanceado, de otro modo s no esta balanceado
        return stack.isEmpty();

        return false;
    }
}
