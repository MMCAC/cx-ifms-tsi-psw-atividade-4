/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author maico
 */
@Named("imcBean")
@SessionScoped
public class ImcBean implements Serializable {
    private double peso;
    private double altura;
    private double imc;
    private String classificacao;

    // getters e setters
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public double getImc() { return imc; }
    public String getClassificacao() { return classificacao; }

    // Novo getter
    public String getResultado() {
        if (imc == 0) return "";
        return "IMC: " + imc + " - " + classificacao;
    }

    public String calcular() {
        this.imc = peso / (altura * altura);

        if (imc < 18.5) classificacao = "Abaixo do peso";
        else if (imc < 24.9) classificacao = "Peso normal";
        else if (imc < 29.9) classificacao = "Sobrepeso";
        else if (imc < 34.9) classificacao = "Obesidade grau I";
        else if (imc < 39.9) classificacao = "Obesidade grau II";
        else classificacao = "Obesidade grau III";

        return "resultado"; // navega para resultado.xhtml
    }
}
