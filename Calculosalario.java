/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.calculosalario;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Calculosalario {

    public static void main(String[] args) {
        //Os dependentes são caracterizados como encargos da família, e dessa forma, podem ser incluídos no imposto de renda segundo alguns critérios estabelecidos pela Receita Federal. Dessa forma, dentre os que podem ser admitidos, estão:
        //Cônjuges;
        //Companheiro (a) com quem o contribuinte tenha filho em comum ou que esteja junto há pelo menos cinco anos;
        //Filhos de até 21 anos, ou de até 24 anos desde que esteja na universidade ou cursando escola técnica;
        //Filho que seja incapacitado física ou mentalmente para o trabalho;
        //Pais, avós e bisavós que, em 2019, tenham recebido rendimentos, tributáveis ou não, até R$ 22.847,76.
        Scanner in = new Scanner(System.in);
        System.out.println("quanto você recebe de salario? ");
        double salarioBruto = in.nextDouble();
        System.out.println("quantos dependentes você tem? ");
        double depen = in.nextDouble();// depententes; regras acima 
        double FGTS = salarioBruto*0.08;
        double INSS = 0;
        double faixa1 = 0;
        double faixa2 = 0;
        double faixa3 = 0;
        double faixa4 = 0;
        if(salarioBruto<=1212.00){
            INSS = salarioBruto*0.075;
        }else if(salarioBruto<=2427.35){
            faixa1 = 1212.00*0.075; 
            faixa2 = (salarioBruto-1212.00)*0.09;
            INSS = faixa1+faixa2;
        }else if(salarioBruto<=3641.03){
            faixa1 = 1212.00*0.075; 
            faixa2 = (2427.35-1212.00)*0.09;
            faixa3 = (salarioBruto-2427.35)*0.12;
            INSS = faixa1+faixa2+faixa3;
        }else if(salarioBruto>=3641.04 && salarioBruto<7087.22){
            faixa1 = 1212.00*0.075; 
            faixa2 = (2427.35-1212.00)*0.09;
            faixa3 = (3641.04-2427.35)*0.12;
            faixa4 = (salarioBruto-3641.03)*0.14;
            INSS = faixa1+faixa2+faixa3+faixa4;
        }else if(salarioBruto>=7087.22){
            faixa1 = 1212.00*0.075; 
            faixa2 = (2427.35-1212.00)*0.09;
            faixa3 = (3641.04-2427.35)*0.12;
            faixa4 = (7087.22-3641.03)*0.14;
            INSS = faixa1+faixa2+faixa3+faixa4;
        }
        System.out.println(INSS);
        double inssIrrf = salarioBruto-INSS;// Desconto do INSS no calculo do imposto de renda(IRRF)
        double depenIrrf = 189.59; // Dedução de dependentes no calculo do imposto de renda(IRRF)
        if(depen>1){
           depenIrrf = depenIrrf*(depen-1);
        }
        double salarioIrrf = inssIrrf-depenIrrf; // salario usado no calculo do imposto de renda(IRRS)
        double IRRF = 0;
        if(salarioIrrf>=1903.99){
            IRRF = salarioIrrf*0.075;
        }else if(salarioIrrf>=2826.66){
            IRRF = salarioIrrf*0.15;
        }else if(salarioIrrf>=3751.06){
            IRRF = salarioIrrf*0.225;
        }else if(salarioIrrf>=4664.68){
            IRRF = salarioIrrf*0.275;
        }else{
            System.out.println("não paga imposto de renda");
        }
        double salarioLiquido = 0;
        salarioLiquido = salarioBruto-FGTS-INSS-IRRF;
        System.out.println("Seu salario total com os descontos é de " + salarioLiquido);
    }
}
