https://github.com/aalvaroo7/CasoFinalt6.git

## distribucion de las clases


VentanaPrincipal
- listaTransacciones: ListaTransacciones
- tablaTransacciones: JTable
- campoId: JTextField
- campoMonto: JTextField
- campoFecha: JTextField
- campoCliente: JTextField
+ VentanaPrincipal()
+ actionPerformed(ActionEvent e)
ListaTransacciones
- transacciones: ArrayList<Transaccion>
+ agregarTransaccion(Transaccion t)
+ eliminarTransaccion(int index)
+ getTransaccion(int index)
+ filtrarPorCliente(String cliente)
+ filtrarPorRangoDeFechas(String fechaInicial, String fechaFinal)
+ filtrarPorMontoMinimo(double montoMinimo)
+ ordenarPorMonto()
+ ordenarPorFecha()
Transaccion
- id: int
- monto: double
- fecha: String
- cliente: String
+ Transaccion(int id, double monto, String fecha, String cliente)
+ setId(int id)
+ setMonto(double monto)
+ setFecha(String fecha)
+ setCliente(String cliente)
TransaccionesTableModel
- transacciones: List<Transaccion>
+ TransaccionesTableModel(List<Transaccion> transacciones)
+ getColumnCount()
+ getColumnName(int column)
+ getRowCount()
+ getValueAt(int row, int column)
+ setValueAt(Object value, int row, int column)

La clase VentanaPrincipal es la clase principal que crea y gestiona la interfaz de usuario para la aplicación. Contiene un objeto ListaTransacciones que gestiona la lista de transacciones, así como varios componentes de interfaz de usuario para la introducción y visualización de los datos de las transacciones.
La clase ListaTransacciones se encarga de gestionar la lista de transacciones y proporciona métodos para añadir, eliminar y filtrar transacciones. También proporciona métodos para ordenar la lista de transacciones por monto o fecha.
La clase Transaccion representa una transacción individual y contiene campos para el ID de la transacción, el monto, la fecha y el cliente.
La clase TransaccionesTableModel es un modelo de tabla personalizado que se utiliza para mostrar la lista de transacciones en un componente JTable. Extiende la clase AbstractTableModel y proporciona implementaciones de los métodos requeridos, como getColumnCount(), getColumnName(int column), getRowCount() y getValueAt(int row, int column). También proporciona un constructor que acepta una lista de objetos Transaccion y crea un modelo de tabla basado en esa lista.
La clase VentanaPrincipal contiene un JFrame con un JTable que muestra la lista de transacciones, un JTextField para el ID de la transacción, un JTextField para el monto, un JTextField para la fecha y un JTextField para el cliente. También contiene varios botones para añadir, modificar, eliminar y ordenar transacciones, así como para filtrar transacciones por cliente, rango de fechas o monto mínimo.
