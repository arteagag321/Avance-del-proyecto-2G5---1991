public class Presupuesto {
    private double total;
    private double gastado;

    public Presupuesto(double total) {
        this.total = total;
        this.gastado = 0;
    }

    public void actualizarPresupuesto(double nuevoGasto) {
        if (gastado + nuevoGasto <= total) {
            gastado += nuevoGasto;
        } else {
            System.out.println("Error: Presupuesto insuficiente.");
        }
    }

    public double getTotal() {
        return total;
    }

    public double getGastado() {
        return gastado;
    }

    public double getSaldoRestante() {
        return total - gastado;
    }

    @Override
    public String toString() {
        return "Presupuesto Total: " + total + ", Gastado: " + gastado + ", Saldo Restante: " + getSaldoRestante();
    }
}
