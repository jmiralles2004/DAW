# SAPAMERCAT - Gestió del Carro de la Compra

## Descripció

El projecte **SAPAMERCAT** és una aplicació dissenyada per gestionar el carro de la compra d'una botiga, oferint als usuaris la capacitat de veure en temps real els preus dels productes que afegeixen al carro. L'aplicació permet afegir productes de tres categories:

- **Alimentació**
- **Tèxtil**
- **Electrònica**

Els preus dels productes es calculen mitjançant fórmules específiques per a cada tipus de producte, tenint en compte factors com la data de caducitat, la composició o els dies de garantia. A més, es realitzen validacions per assegurar que les dades introduïdes siguin correctes, evitant errors durant el procés de compra.

Aquest projecte ha estat desenvolupat com a part d'un exercici de programació en Java, seguint el patró de disseny **MVC (Model-Vista-Controlador)** i utilitzant excepcions personalitzades i validacions per garantir una experiència d'usuari òptima.

## Característiques

- **Gestió de productes**: L'aplicació permet gestionar productes de tres tipus:

  - **Alimentació**: Inclou un sistema de càlcul de preu basat en la proximitat de la data de caducitat.
  - **Tèxtil**: Els productes tèxtils es gestionen segons la seva composició (cotó, llana, seda) i mantenen un preu constant.
  - **Electrònica**: Els productes electrònics tenen una garantia associada que ajusta el preu en funció de la durada de la garantia.

- **Carro de compra**: El carro emmagatzema els productes afegits i gestiona les quantitats de cada producte. El total es calcula automàticament en funció del preu unitari i la quantitat.

- **Generació de tiquets**: En passar per caixa, l'aplicació genera un tiquet amb la llista de productes adquirits, el preu unitari de cada producte, el total de la compra i es buida el carro per a la següent compra.

- **Interfície d'usuari**: La interfície es basa en un menú interactiu que permet a l'usuari:
  - Afegir productes al carro.
  - Visualitzar el contingut del carro.
  - Realitzar el pagament i obtenir un tiquet.
  - Cercar productes mitjançant el codi de barres.

## Requisits

Per poder executar aquest projecte, cal tenir instal·lat:

- **Java 8 o superior**.
- **IDE de la teva preferència** (com IntelliJ IDEA, Eclipse, NetBeans).
- **Maven o Gradle** per a la gestió de dependències (si és necessari).

## Instal·lació

1. Clona aquest repositori amb el següent comandament:
   ```bash
   git clone https://github.com/jmiralles2004/DAW.git
   ```