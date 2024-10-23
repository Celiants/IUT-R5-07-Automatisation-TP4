package TP4;

import java.util.Stack;

public class Calculette {
    private Stack<Double> pile;

    public Calculette() {
        pile = new Stack<>();
    }

    public void addition() {
        if (pile.size() < 2) {
            throw new IllegalStateException("Pas assez d'opérandes pour l'addition");
        }
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a + b);
    }

    public void soustraction() {
        if (pile.size() < 2) {
            throw new IllegalStateException("Pas assez d'opérandes pour la soustraction");
        }
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a - b);
    }

    public void multiplication() {
        if (pile.size() < 2) {
            throw new IllegalStateException("Pas assez d'opérandes pour la multiplication");
        }
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a * b);
    }

    public void division() {
        if (pile.size() < 2) {
            throw new IllegalStateException("Pas assez d'opérandes pour la division");
        }
        double b = pile.pop();
        if (b == 0) {
            throw new ArithmeticException("Division par zéro");
        }
        double a = pile.pop();
        pile.push(a / b);
    }

    public double evaluer(String expression) {
        String[] tokens = expression.split("\\s+");
        for (String token : tokens) {
            switch (token) {
                case "+":
                    addition();
                    break;
                case "-":
                    soustraction();
                    break;
                case "*":
                    multiplication();
                    break;
                case "/":
                    division();
                    break;
                default:
                    try {
                        pile.push(Double.parseDouble(token));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Token invalide : " + token);
                    }
            }
        }
        if (pile.size() != 1) {
            throw new IllegalStateException("Expression mal formée");
        }
        return pile.pop();
    }
}
