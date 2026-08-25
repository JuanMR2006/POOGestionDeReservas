package politicas;
public class DescuentoVIP implements PoliticaDescuento {
    @Override
    public double aplicarDescuento(double montoBase) {
        return montoBase * 0.80;
    }
}