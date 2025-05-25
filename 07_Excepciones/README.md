# Excepciones
### Ejercicio: Clasificando excepciones
Dados los siguientes casos de error, 
determinar si corresponde modelar la excepción 
de tipo _checked_ o _unchecked_:
1) División de un número por 0: **Unchecked** 
-> _ArithmeticException_
2) Formato de número de teléfono incorrecto: **Unchecked** 
-> _IllegalArgumentException_
3) No se puede abrir el archivo solicitado: **Checked** 
-> _IOException_
4) No existe el archivo a acceder: **Checked** -> 
_FileNotFoundException_
5) Operación aritmética no soportada en cierto tipo 
de dato: **Unchecked** -> _UnsupportedOperationException_
6) Se superó el límite de capacidad de la estructura: 
**Unchecked** -> _IndexOutOfBoundsException_ o 
_IllegalStateException_
7) La configuración externa de la aplicación es incorrecta: 
**Checked** -> _IOException_
8) Falló la conexión a la base de datos: **Checked** 
-> _SQLException_
9) Se convierte una referencia a un subtipo
(downcasting) que no corresponde: **Unchecked** 
-> _ClassCastException_