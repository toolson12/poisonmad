# ¿Qué es PoisonMAD?

PoisonMAD es un parseador de datos sobre la calidad del aire que ofrece el Ayuntamiento de Madrid en su plataforma [Datos Abiertos](https://datos.madrid.es/portal/site/egob/). 

Esta implementación, desarrollada en Java, permite [leer un fichero CSV](https://datos.madrid.es/egob/catalogo/212531-10515086-calidad-aire-tiempo-real.csv) que dicha plataforma ofrece cada sesenta minutos y generar una tabla HTML donde **se organizan los datos por estación de medición, agente contaminante y hora** en la que se ha realizado la lectura. 

## Objetivo 

- Presentar de una manera accesible los datos que proporciona el Ayuntamiento de Madrid en formato CSV. 
- Servir de base / esqueleto para implementaciones más complejas en las que se deseen persistir las mediciones en bases de datos. 

## Instalación

// TODO