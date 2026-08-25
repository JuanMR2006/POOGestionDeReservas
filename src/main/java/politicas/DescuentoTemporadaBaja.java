package politicas;
public class DescuentoTemporadaBaja implements PoliticaDescuento {
    @Override
    public double aplicarDescuento(double montoBase) {
        return montoBase * 0.85;
    }
}
