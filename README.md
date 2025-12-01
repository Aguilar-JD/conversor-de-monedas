# 💱 Conversor de Monedas - Challenge Alura

![Java](https://img.shields.io/badge/Java-17-orange) ![Gson](https://img.shields.io/badge/Library-Gson-blue) ![Status](https://img.shields.io/badge/Status-Finalizado-green)

Bienvenido al **Conversor de Monedas**, una aplicación Backend desarrollada en Java que consume la API de ExchangeRate para realizar conversiones de divisas en tiempo real. Este proyecto forma parte del Challenge del programa **Oracle Next Education (ONE)** con Alura Latam.

## 🚀 Características Principales

* **Consumo de API en tiempo real:** Obtiene tasas de cambio actualizadas al instante.
* **Conversión Multimoneda:** Soporte para Dólar (USD), Peso Argentino (ARS), Real Brasileño (BRL) y Peso Colombiano (COP).
* **Historial Persistente:** Guarda automáticamente todas las consultas realizadas en un archivo `historial_consultas.json`.
* **Registro de Fecha y Hora:** Cada conversión incluye la marca de tiempo exacta de la API (`time_last_update_utc`).
* **Validación de Datos:** Sistema robusto para manejar errores de entrada del usuario (evita caídas por letras o números inválidos).
* **Seguridad:** Manejo de API Key mediante variables de entorno para no exponer credenciales.

## 🛠️ Tecnologías Utilizadas

* **Java 17:** Lenguaje principal.
* **HttpClient:** Para las peticiones HTTP a la API.
* **Gson (Google):** Librería para serializar y deserializar los datos JSON.
* **java.io:** Para la generación y escritura de archivos en el disco.

## 📋 Requisitos Previos

Para ejecutar este proyecto necesitas:
1.  Tener instalado **Java JDK 17** o superior.
2.  Un entorno de desarrollo (IDE) como **IntelliJ IDEA**.
3.  Obtener una **API Key** gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/).

## ⚙️ Configuración e Instalación

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/Aguilar-JD/conversor-de-monedas.git](https://github.com/Aguilar-JD/conversor-de-monedas.git)
    ```

2.  **Configurar la Variable de Entorno:**
    Por seguridad, la API Key no está incluida en el código. Debes configurarla en tu sistema operativo o en tu IDE.
    * **Nombre de la variable:** `API_KEY`
    * **Valor:** `Tu_Clave_Alfanumerica_De_ExchangeRate`

    > **En IntelliJ:** Ve a *Run > Edit Configurations > Environment variables* y agrégala ahí.

3.  **Ejecutar la aplicación:**
    Busca la clase `Principal.java` (o `Main.java`) y dale al botón de **Run**.

## 📂 Estructura del Proyecto

El código está organizado siguiendo las buenas prácticas de separación de responsabilidades:

* `io.github.aguilarjd.model`: Contiene el record `Moneda` (DTO).
* `io.github.aguilarjd.service`: Lógica de conexión con la API (`ConsultarMoneda`).
* `io.github.aguilarjd.principal`: Contiene el punto de entrada (`Main`), el manejo de archivos (`GeneradorDeArchivos`) y la validación de usuario (`LecturaDeDatos`).

## 📄 Ejemplo de Historial JSON

Al usar la aplicación, se generará un archivo `historial_consultas.json` con este formato:

```json
[
  {
    "base_code": "USD",
    "target_code": "ARS",
    "time_last_update_utc": "Mon, 01 Dec 2025 00:00:02 +0000",
    "conversion_rate": 1050.50
  },
  {
    "base_code": "BRL",
    "target_code": "USD",
    "time_last_update_utc": "Mon, 01 Dec 2025 00:00:02 +0000",
    "conversion_rate": 0.19
  }
]