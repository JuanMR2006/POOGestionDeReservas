package politicas;
public class DescuentoCorporativo implements PoliticaDescuento {
    @Override
    public double aplicarDescuento(double montoBase) {
        return montoBase * 0.70;
    }
}
