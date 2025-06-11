# 📚 SENA Viewer

SENA Viewer es una aplicación de consola desarrollada en Java que permite a los usuarios navegar, visualizar y gestionar contenido multimedia como películas, series, libros y revistas. Además, incluye un sistema de reportes detallados para realizar un seguimiento del contenido consumido.

---

## 🚀 **Características Principales**

### 🎬 **Gestión de Contenido**
- **Películas:**  
  Visualiza una lista de películas disponibles, marca automáticamente las películas como "vistas" y lleva un registro del tiempo de visualización.
- **Series:**  
  Explora series, realiza un seguimiento de los episodios vistos y continúa donde lo dejaste.
- **Libros:**  
  Accede a una colección de libros, marca los libros como leídos y lleva un registro del tiempo de lectura.
- **Revistas:**  
  Consulta revistas disponibles y mantén un historial de las que has leído.

### 📊 **Sistema de Reportes**
- **Historial Completo:**  
  Consulta un reporte general de todo el contenido consumido.
- **Reportes Específicos:**  
  - 🎥 Películas vistas con tiempo de visualización.
  - 📺 Series vistas con seguimiento de episodios.
  - 📚 Libros leídos con tiempo de lectura.
  - 📰 Revistas leídas con detalles de edición.

### ✅ **Validación de Entrada**
- Manejo de entradas inválidas para evitar errores y mejorar la experiencia del usuario.

### ✨ **Interfaz Amigable**
- Menús numerados para facilitar la navegación.
- Mensajes claros y personalizados para el usuario.

---

## 🛠️ **Estructura del Proyecto**

El proyecto está organizado de la siguiente manera:

```
README.md
bin/
	App.class
	model/
		Book.class
		Film.class
		Magazine.class
		Movie.class
		Publication.class
		Serie.class
lib/
src/
	App.java
	model/
		Book.java
		Film.java
		Magazine.java
		Movie.java
		Publication.java
		Serie.java
```

### Clases Principales

- **Publication**: Clase base para publicaciones, con atributos como título, fecha de edición, editorial y autores.
- **Book**: Extiende `Publication` y añade atributos específicos como ISBN, estado de lectura y tiempo leído.
- **Magazine**: Extiende `Publication` y representa revistas.
- **Film**: Clase base para medios audiovisuales, con atributos como título, género, creador, duración y año.
- **Movie**: Extiende `Film` y añade el tiempo visto.
- **Serie**: Extiende `Film` y añade atributos como cantidad de sesiones y tiempo visto.

## Requisitos

- Java 8 o superior

## Compilación y Ejecución

1. Compila el proyecto:
   ```bash
   javac -d bin src/**/*.java
   ```

2. Ejecuta la aplicación:
   ```bash
   java -cp bin App
   ```

