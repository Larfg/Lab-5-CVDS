package edu.eci.cvds.calculator;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "calculadoraBean")
@ApplicationScoped

public class calculadora {

    static String cadenaEntrada = "";
    static double resMean = 0;
    static double resVariance = 0;
    static double resStandardDeviation = 0;
    static double resMode = 0;
    static int cantidadNumero = 0;

    /**
     * Constructor vacio
     */
    public calculadora(){}

    /**
     * Metodo que transforma la cadena digitada por el usuario en cadena de Double´s
     * @return Array de Double´s
     */
    private static double[] cadenaADouble() {
        String[] valores = cadenaEntrada.split(";");
        double[] resultadoValores = new double[valores.length];
        for (int i = 0; i<valores.length;i++) {
            resultadoValores[i] = Double.parseDouble(valores[i]);
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
        resMean = sum / m.length;
        return resMean ;
    }

    /**
     * Calcula la desviacion estandar de los datos
     * @return Int que representa la desviacion estandar
     */
    public static double calculateStandardDeviation(){
        double[] m = cadenaADouble();
        resStandardDeviation = Math.sqrt(calculateVariance());
        return resStandardDeviation;
    }

    /**
     * Calcula la varianza de los datos
     * @return Int que representa la varianza
     */
    public static double calculateVariance(){
        double[] m = cadenaADouble();
        double diff = 0;
        for (int i = 0; i < m.length; i++)
            diff += (m[i] - calculateMean()) * (m[i] - calculateMean());
        resVariance = diff/m.length;
        return resVariance;
    }

    /**
     * Calcula la moda de los datos
     * @return Int que representa la moda
     */
    public static double calculateMode() {
        double maxCount = 0;
        double resultadoMode=0;
        double m[] = cadenaADouble();
        for (int i = 0; i < m.length; ++i) {
            double count = 0;
            for (int j = 0; j < m.length; ++j) {
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
        resMean = 0;
        resVariance = 0;
        resStandardDeviation = 0;
        resMode = 0;
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
        return resMean;
    }

    /**
     * Set Resultado Mean
     * @param resultadoMean Double
     */
    public void setResultadoMean(double resultadoMean) {
        this.resMean = resultadoMean;
    }

    /**
     * Get Resultado Operacion Varianza
     * @return Double Resultado varianza
     */
    public double getResultadoVariance() {
        return resVariance;
    }

    /**
     * Set Resultado varianza
     * @param resultadoVariance Double
     */
    public void setResultadoVariance(double resultadoVariance) {
        this.resVariance = resultadoVariance;
    }

    /**
     * Get Resultado Desviacion Estandar
     * @return Double de desviacion estandar
     */
    public double getResultadoStandardDeviation() {
        return resStandardDeviation;
    }

    /**
     * Set Desviacion Estandar
     * @param resultadoStandardDeviation Double
     */
    public void setResultadoStandardDeviation(double resultadoStandardDeviation) {
        this.resStandardDeviation = resultadoStandardDeviation;
    }

    /**
     * Get Resultado Moda
     * @return Double Resultado Moda
     */
    public double getResultadoMode() {
        return resMode;
    }

    /**
     * Set Moda
     * @param resultadoMode Double
     */
    public void setResultadoMode(double resultadoMode) {
        this.resMode = resultadoMode;
    }

    /**
     * Get Cantidad de numeros
     * @return Int Cantidad de Numeros
     */
    public int getCantidadNumero() {
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
        return "Calculadora [cadenaEntrada=" + cadenaEntrada + ", resultadoMean=" + resMean
                + ", resultadoVariance=" + resVariance + ", resultadoStandartDeviation="
                + resStandardDeviation + ", resultadoMode=" + resMode + ", cantidadNumero=" + cantidadNumero
                + "]";
    }
}