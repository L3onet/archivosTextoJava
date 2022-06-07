public class ReciboLuz {
    private double costoKw;          // El costo por KW
    private int lecturaAnterior;    // La lectura anterior del medidor
    private int lecturaActual;      // La lectura actual del medidor
    private int consumoKw;          // El total de consumo de KW en el periodo
    private double costoConsumo;     // El total a pagar sin impuestos
    private double totalAPagar;      // El total a pagar con impuestos
/*
    Esta clase calcula el total a pagar
    por el consumo de energía
 */

    public ReciboLuz(double costoKw, int lecturaAnterior, int lecturaActual) {
        this.lecturaActual = lecturaActual;
        this.lecturaAnterior = lecturaAnterior;
        this.costoKw = costoKw;
        this.calcularConsumo();
        this.calcularCostoConsumo();
        this.calcularTotalConsumo();
    }

    public double getCostoKw() {
        return costoKw;
    }

    public void setCostoKw(double costoKw) {
        this.costoKw = costoKw;
    }

    public int getLecturaAnterior() {
        return lecturaAnterior;
    }

    public void setLecturaAnterior(int lecturaAnterior) {
        this.lecturaAnterior = lecturaAnterior;
    }

    public int getLecturaActual() {
        return lecturaActual;
    }

    public void setLecturaActual(int lecturaActual) {
        this.lecturaActual = lecturaActual;
    }

    public int getConsumoKw() {
        return consumoKw;
    }

    public void setConsumoKw(int consumoKw) {
        this.consumoKw = consumoKw;
    }

    public double getCostoConsumo() {
        return costoConsumo;
    }

    public void setCostoConsumo(double costoConsumo) {
        this.costoConsumo = costoConsumo;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public void calcularConsumo(){
        this.consumoKw = this.lecturaActual - this.lecturaAnterior;
    }

    public void calcularCostoConsumo(){
        this.costoConsumo = this.consumoKw * this.costoKw;
    }

    public void calcularTotalConsumo(){
        if (this.consumoKw < 500){
            this.totalAPagar = this.costoConsumo * 1.22;
        } else if(this.consumoKw >= 500 && this.consumoKw < 900){
            this.totalAPagar = this.costoConsumo * 1.18;
        } else {
            this.totalAPagar = this.costoConsumo * 1.12;
        }
    }

    public static void main(String[] args){
        ReciboLuz reciboLuz = new ReciboLuz(1.4, 467, 856);
        System.out.println(reciboLuz.getTotalAPagar());
    }
}
