package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        //Recorreremos todo el string str
        for(int i=0;i<str.length();i++) {
        	char c=str.charAt(i);
        	//para cada elemento de s,verificamos si es diferente de un parentesis de cierre
        	//osea puede ser un parentesis de apertura,o una variable o un operador
        	if(c!=')') {
        		//Si lo es,entonces lo agregamos a la pila
        		stack.push(c);
        	}
        	//Si no lo es,entonces es de cierre
        	else {
        		//Entonces borramos el top de la pila y lo conservamos en la variable top
        		char top=stack.pop();
        		//Vamos a contar el número de caracteres entre un cierre y una apertura
        		int auxi=0;
        		while(top!='(') {
        			//Osea extraeremos los caracteres de la pila hasta encontrar un parentesis de apertura
        			//y ademas llevamos un conteo de cuantos caracteres vamos sacando
        			auxi++;
        			top=stack.pop();
        		}
        		//Si ese conteo es menor que 1,significa que los parentesis son duplicados o redundantes
        		if(auxi<1) {
        			return true;
        		}
        	}
        }
        //Si llegamos aca nunca entramos en auxi<1 y por lo tanto no hay duplicados
        return false;
    }
}
