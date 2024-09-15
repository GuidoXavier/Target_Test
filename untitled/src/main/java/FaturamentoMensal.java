public class FaturamentoMensal {
    private int dia;
    private double valor = 0;

    public FaturamentoMensal() {

    }


    public int getDia() {
        return dia;
    }

    public double getValor() {
        return valor;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "FaturamentoMensal{" +
                "dia=" + dia +
                ", valor=" + valor +
                '}';
    }
}
