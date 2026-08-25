package politicas;
public class DescuentoRegular implements PoliticaDescuento {
    @Override
    public double aplicarDescuento(double montoBase) {
        return montoBase;
    }
}
