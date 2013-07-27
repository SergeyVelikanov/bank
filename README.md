bank
====
Este ejercicio trata de modelar un banco. El banco consiste de una lista de cuentas y una lista de clientes. De los clientes tenemos su DNI, nombre, apellidos, dirección y teléfono.

Sobre un banco podemos efectuar una revisión de todas las cuentas del mismo. En cada cuenta podemos ingresar dinero, sacar dinero, consultar saldo, cambiar el cliente, efectuar una revisión mensual.

La revisión mensual de la cuenta hace lo siguiente:
Saldo = saldo + interés_cuenta  comisión

Todas las cuentas tienen una comisión de 0,6 mensuales que puede ser modificada.

Hay tres tipos de cuenta: CuentaCorriente (CC), CuentaVivienda (CV) y FondoInversion (FI).

La CC tiene un interés del 0.1, la CV del 0.2 y el FI de un 0.34. De la CC no se puede sacar mas dinero del que hay, del FI se pueden sacar hasta 500 de números rojos (si se supera la cuenta se bloquea) y de la CV no se puede sacar dinero. La revisión mensual de la CV no paga comisión bancaria. La cuenta de puntos, cada vez que se ingresan 6 se suma un punto. Se pueden ver cuantos puntos lleva la cuenta. 
Hay que implementar el modelo del banco en Java, y crear una clase de prueba que compruebe la funcionalidad de las clases. En este apartado, no es necesaria la creación de interfaz textual o gráfica.

1  Diseñar el modelo de clases y objetos que se va a usar, con sus atributos y operaciones.<br/>
2  Implementar cada una de las clases, y localizar los conceptos:<br/>
* Relaciones entre clases (1..N)
* Propiedades y operaciones de cada clase.
* Abstracción y encapsulación.
* Herencia
* Polimorfismo y ligadura dinámica
* Excepciones
* Redefinición por reemplazo y refinamiento.
3  Crear una clase main, que genere varios objetos, y pruebe el compartamiento de las clases mostrando el resultado por pantalla, en la misma consola.
