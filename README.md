# Sistema de reservas: extensión de dominio rico y SOLID

Esta entrega añade requisitos sin editar las clases que ya existían. Las nuevas
clases se crean como extensiones y consumen los contratos originales.

## Dominio rico

- `NumeroHabitacion` es un Value Object inmutable (`record`) y valida que su
  valor no sea vacío.
- `Habitacion` es una entidad con capacidad mínima de una persona y protege las
  transiciones `DISPONIBLE`, `OCUPADA` y `MANTENIMIENTO` mediante métodos de
  comportamiento, no setters.
- `ReservaConHabitacion` asocia una `Reserva` existente a una `Habitacion` y
  coordina su confirmación/cancelación. De esta manera se conserva intacta la
  clase `Reserva` que se desarrolló en clase.

## SOLID aplicado

**OCP (Open/Closed):** `DescuentoTemporadaBaja` y `DescuentoEstadiaLarga`
implementan la interfaz existente `PoliticaDescuento`. Para añadir un descuento
no se cambia ni el servicio ni las políticas anteriores; basta una nueva clase.

**LSP e ISP:** `WhatsAppNotificadorService` y `PushNotificadorService` cumplen
el contrato pequeño `NotificadorService`, por lo que pueden sustituir sin
cambios a correo o SMS.

**DIP (Dependency Inversion):** `ReservaArchivoRepository` implementa la
abstracción `ReservaRepository`. El nuevo
`ConfirmacionReservaConHabitacionService` recibe por constructor las interfaces
`ReservaRepository` y `NotificadorService`, nunca implementaciones concretas.

## Ejecución

Compilar desde la carpeta del proyecto:

```powershell
mvn clean package
```

Ejecutar el ejemplo de la extensión:

```powershell
java -cp target/classes com.mycompany.sistema.reservas.dominio.DemoExtensionDominioRico
```

La ejecución genera o agrega una línea al archivo `reservas-confirmadas.txt`.

## Diagrama UML

El diagrama editable se encuentra en `docs/diagrama-clases.puml`; la entrega
incluye también su exportación en `docs/diagrama-clases.png`.
