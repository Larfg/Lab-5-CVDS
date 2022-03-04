package edu.eci.cvds.calculator;

import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.*;

@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
@SessionScoped
public class calculadora{

    static String cadenaEntrada = "";
    static double resultadoMean = 0;
    static double resultadoVariance = 0;
    static double resultadoStandardDeviation = 0;
    static double resultadoMode = 0;
    static double cantidadNumero = 0;


    /**
     * Metodo que transforma la cadena digitada por el usuario en cadena de Double´s
     * @return Array de Double´s
     */
    public calculadora(){}

    /**
     * Calcula promedio de los datos
     * @return Int que representa el promedio
     */
    private static double[] cadenaADouble() {
        String[] valores = cadenaEntrada.split(";");
        double[] resultadoValores = new double[valores.length];
        for (int i = 0; i<valores.length;i++) {
            resultadoValores[i]=Double.parseDouble(valores[i]);
        }
        cantidadNumero = resultadoValores.length;
        return resultadoValores;
    }

    /**
     * Calcula promedio de los datos
     * @return Int que representa el promedio
     */
    public static double calculateMean() {
        double[] m = cadenaADouble();
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i];
        }
        resultadoMean = sum / m.length;
        return resultadoMean ;
    }

    /**
     * Calcula la varianza de los datos
     * @return Int que representa la varianza
     */
    public static double calculateVariance(){
        double[] m = cadenaADouble();
        double sqDiff = 0;
        double n = m.length;
        for (int i = 0; i < n; i++)
            sqDiff += (m[i] - calculateMean()) * (m[i] - calculateMean());
        resultadoVariance = sqDiff/n;
        return resultadoVariance;
    }

    /**
     * Calcula la desviacion estandar de los datos
     * @return Int que representa la desviacion estandar
     */
    public static double calculateStandardDeviation(){
        double[] m = cadenaADouble();
        resultadoStandardDeviation = Math.sqrt(calculateVariance());
        return resultadoStandardDeviation;
    }


    /**
     * Calcula la moda de los datos
     * @return Int que representa la moda
     */
    public static double calculateMode() {
        double maxCount = 0;
        double resultadoMode=0;
        double m[] = cadenaADouble();
        double n = m.length;
        for (int i = 0; i < n; ++i) {
            double count = 0;
            for (int j = 0; j < n; ++j) {
                if (m[j] == m[i])
                    ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                resultadoMode = m[i];
            }
        }
        return resultadoMode;
    }


    /**
     * Metodo que reinicia los datos
     */
    public static void restart(){
        cadenaEntrada = "";
        resultadoMean = 0;
        resultadoVariance = 0;
        resultadoStandardDeviation = 0;
        resultadoMode = 0;
        cantidadNumero = 0;
    }


    /**
     * Get Cadena Entrada
     * @return String
     */
    public String getCadenaEntrada() {
        return cadenaEntrada;
    }

    /**
     * Set Cadena de Entrada
     * @param cadenaEntrada String
     */
    public void setCadenaEntrada(String cadenaEntrada) {
        this.cadenaEntrada = cadenaEntrada;
    }

    /**
     * Get Resultado Operacion Mean
     * @return Double Resultado Mean
     */
    public double getResultadoMean() {
        return resultadoMean;
    }

    /**
     * Set Resultado Mean
     * @param resultadoMean Double
     */
    public void setResultadoMean(double resultadoMean) {
        this.resultadoMean = resultadoMean;
    }

    /**
     * Get Resultado Operacion Varianza
     * @return Double Resultado varianza
     */
    public double getResultadoVariance() {
        return resultadoVariance;
    }

    /**
     * Set Resultado varianza
     * @param resultadoVariance Double
     */
    public void setResultadoVariance(double resultadoVariance) {
        this.resultadoVariance = resultadoVariance;
    }


    /**
     * Get Resultado Desviacion Estandar
     * @return Double de desviacion estandar
     */
    public double getResultadoStandardDeviation() {
        return resultadoStandardDeviation;
    }


    /**
     * Set Desviacion Estandar
     * @param resultadoStandardDeviation Double
     */
    public void setResultadoStandardDeviation(double resultadoStandardDeviation) {
        this.resultadoStandardDeviation = resultadoStandardDeviation;
    }

    /**
     * Get Resultado Moda
     * @return Double Resultado Moda
     */
    public double getResultadoMode() {
        return resultadoMode;
    }


    /**
     * Set Moda
     * @param resultadoMode Double
     */
    public void setResultadoMode(double resultadoMode) {
        this.resultadoMode = resultadoMode;
    }


    /**
     * Get Cantidad de numeros
     * @return Int Cantidad de Numeros
     */
    public double getCantidadNumero() {
        return cantidadNumero;
    }

    /**
     * Set Cantidad de Numeros
     * @param cantidadNumero Int
     */
    public void setCantidadNumero(int cantidadNumero) {
        this.cantidadNumero = cantidadNumero;
    }

    @Override
    public String toString() {
        return "Calculadora [cadenaEntrada=" + cadenaEntrada + ", resultadoMean=" + resultadoMean
                + ", resultadoVariance=" + resultadoVariance + ", resultadoStandartDeviation="
                + resultadoStandardDeviation + ", resultadoMode=" + resultadoMode + ", cantidadNumero=" + cantidadNumero
                + "]";
    }

}