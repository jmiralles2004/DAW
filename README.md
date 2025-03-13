# SAPAMERCAT - Gestió del Carro de la Compra

## Descripció

El projecte **SAPAMERCAT** és una aplicació que permet gestionar el carro de la compra d'una botiga, mostrant en temps
real el preu dels productes que es van afegint al carro. L'aplicació permet afegir productes de tres categories: *
*Alimentació**, **Tèxtil** i **Electrònica**. Els preus es calculen segons certes fórmules específiques per a cada tipus
de producte i es realitzen validacions per assegurar que les dades introduïdes siguin correctes.

Aquest projecte ha estat desenvolupat com a part d'un exercici de programació en Java, seguint el patró de disseny *
*MVC (Model-Vista-Controlador)** i utilitzant excepcions personalitzades i validacions.

## Característiques

- **Gestió de productes**: L'aplicació gestiona productes de tres tipus:
    - **Alimentació**: amb data de caducitat i càlcul del preu basat en la proximitat de la data.
    - **Tèxtil**: amb una composició i preu constant.
    - **Electrònica**: amb dies de garantia i un ajust al preu basat en la durada de la garantia.

- **Carro de compra**: El carro pot emmagatzemar productes i calcular el total, gestionant quantitats de productes
  iguals.

- **Generació de tiquets**: En passar per caixa, es genera un tiquet amb els productes adquirits, el seu preu unitari,
  el total i es buida el carro.

- **Interfície d'usuari**: Un menú interactiu permet afegir productes, veure el carro, passar per caixa i cercar
  productes per codi de barres.

## Requisits

- **Java 8 o superior**.
- **IDE de la teva preferència** (com IntelliJ IDEA, Eclipse, NetBeans).
- **Maven o Gradle** (si es requereix per a la gestió de dependències).

## Instal·lació

1. Clona aquest repositori:
   ```bash
   git clone https://github.com/jmiralles2004/DAW.git