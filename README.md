# 💱 Conversor de Monedas - Java Console App

Este es un proyecto de consola desarrollado en **Java** utilizando **Maven**, que permite convertir valores entre distintas monedas en tiempo real consumiendo datos desde una API externa de tasas de cambio.

---

## 📌 Características

- Conversión en tiempo real entre más de 150 monedas.
- Entrada interactiva desde consola.
- Arquitectura modular: separación de responsabilidades por clases.
- Manejo de errores para entradas no válidas y respuestas de API.
- Código limpio y fácil de mantener.
- Proyecto listo para ejecutar desde Maven.

---

## 🛠️ Tecnologías y herramientas

- ☕ **Java 17**
- 📦 **Maven** (gestor de dependencias)
- 🌐 **API de tipo de cambio**: [ExchangeRate API](https://www.exchangerate-api.com/)
- 🧪 IDE recomendado: IntelliJ IDEA / VS Code / Eclipse

---

## 📁 Estructura del proyecto

ConversorMonedas/
├── src/
│ └── main/
│ └── java/
│ └── com/
│ └── miapp/
│ └── conversor/
│ ├── ConversorMonedas.java # Clase principal
│ ├── ApiConnector.java # Conexión y consumo de API
│ └── Moneda.java # Modelo de datos para conversión
├── pom.xml # Configuración del proyecto Maven
└── README.md # Documentación del proyecto



🧪 Ejemplo de uso

Conversor de Monedas
Moneda base (ej. USD): usd

Moneda objetivo (ej. EUR): cop

Cantidad a convertir: 100

100.00 USD equivalen a 396900.00 COP





🧠 Autor

Desarrollado por: Juan Causil

GitHub: https://github.com/JuanCausil

Email: jdavix42@gmail.com
