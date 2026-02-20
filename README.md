<p align="center">
  <img src="src/main/resources/static/images/hispajug-logo.png" alt="HispaJUG Logo" width="200"/>
</p>

# HispaJUG Website

> El código nos une, el idioma nos conecta

HispaJUG es el sitio web oficial de la comunidad de Java hispanohablante. Este proyecto tiene como objetivo conectar a desarrolladores, líderes de comunidades (JUGs) y entusiastas del ecosistema JVM en todo el mundo hispano.

## 📋 Descripción del Proyecto

Esta aplicación web está construida con **Micronaut 4.10.8** y **Thymeleaf**, proporcionando:

- 🎤 **Charlas mensuales online** sobre tecnologías JVM
- 🌎 **Directorio de JUGs hispanos** organizados por país
- 👥 **Información de líderes** de cada comunidad local
- 📅 **Calendario de eventos** próximos
- 💬 **Integración con Slack** para networking

## 🚀 Cómo Ejecutar el Proyecto

### Requisitos Previos

- Java 25 (JDK)
- Maven 3.9+
- Docker (opcional)

### Ejecución Local

#### Opción 1: Con Maven

```bash
# Compilar el proyecto
mvn clean package

# Ejecutar la aplicación
mvn mn:run
```

La aplicación estará disponible en: `http://localhost:8080`

#### Opción 2: Con Docker

```bash
# Construir la imagen
docker build -t hispajug-website .

# Ejecutar el contenedor
docker run -p 8080:8080 hispajug-website
```

#### Opción 3: Ejecución directa del JAR

```bash
# Compilar
mvn clean package

# Ejecutar
java -jar target/hispajug-website-0.1.jar
```

### Ejecución en Modo Desarrollo

```bash
mvn mn:run
```

Los cambios en las plantillas Thymeleaf se recargarán automáticamente.

## 🤝 Cómo Contribuir

### Reportar un Problema o Sugerencia

Si encuentras un bug, tienes una sugerencia de mejora, o conoces un JUG que debería estar en el directorio:

1. Ve a la pestaña **[Issues](https://github.com/RicardoRB/hispajug-website/issues)**
2. Haz clic en **"New Issue"**
3. Describe claramente:
   - **Título descriptivo** del problema o sugerencia
   - **Descripción detallada** de lo que observaste o propones
   - **Pasos para reproducir** (si es un bug)
   - **Capturas de pantalla** (si aplica)

**Ejemplo para agregar un JUG:**
```
Título: Agregar Barcelona JUG al directorio

Descripción:
- Nombre: Barcelona JUG
- País: España
- Ciudad: Barcelona
- URL: https://barcelonajug.org
- Líder(es): [Nombre] - [LinkedIn URL]
```

### Crear un Pull Request

¿Quieres contribuir con código? ¡Excelente! Sigue estos pasos:

1. **Fork el repositorio**
   - Haz clic en el botón "Fork" arriba a la derecha

2. **Clona tu fork**
   ```bash
   git clone https://github.com/TU_USUARIO/hispajug-website.git
   cd hispajug-website
   ```

3. **Crea una rama para tu cambio**
   ```bash
   git checkout -b feature/nombre-descriptivo
   # Ejemplos:
   # - feature/agregar-bogota-jug
   # - fix/corregir-fecha-evento
   # - docs/actualizar-readme
   ```

4. **Realiza tus cambios**
   - Modifica los archivos necesarios
   - Asegúrate de seguir las convenciones del código existente

5. **Prueba tus cambios localmente**
   ```bash
   mvn clean package
   mvn mn:run
   ```

6. **Commit y push**
   ```bash
   git add .
   git commit -m "feat: descripción clara del cambio"
   git push origin feature/nombre-descriptivo
   ```

7. **Abre el Pull Request**
   - Ve a tu fork en GitHub
   - Haz clic en "Compare & pull request"
   - Completa la descripción explicando:
     - ¿Qué cambia este PR?
     - ¿Por qué es necesario?
     - ¿Cómo se probó?

### Guía de Commits

Seguimos convenciones de commits semánticos:

- `feat:` Nueva funcionalidad
- `fix:` Corrección de bugs
- `docs:` Cambios en documentación
- `style:` Formato, espacios (sin cambios de código)
- `refactor:` Refactorización de código
- `test:` Agregar o modificar tests
- `chore:` Tareas de mantenimiento

**Ejemplos:**
```
feat: agregar filtro por región para JUGs
fix: corregir formato de fecha en eventos
docs: actualizar instrucciones de instalación
```

## 📚 Tecnologías Utilizadas

- **Backend**: Micronaut 4.10.8 (Java 25)
- **Frontend**: Thymeleaf + TailwindCSS
- **Build**: Maven
- **Containerización**: Docker (multi-stage)

## 📖 Documentación Técnica

### Micronaut

- [User Guide](https://docs.micronaut.io/4.10.8/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.10.8/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.10.8/guide/configurationreference.html)
- [Micronaut Maven Plugin](https://micronaut-projects.github.io/micronaut-maven-plugin/latest/)

### Thymeleaf

- [Micronaut Thymeleaf Views](https://micronaut-projects.github.io/micronaut-views/latest/guide/index.html#thymeleaf)
- [Thymeleaf Documentation](https://www.thymeleaf.org/)

## 📝 Licencia

Este es un proyecto de código abierto creado por y para la comunidad Java hispanohablante.

## 💬 Contacto

- **Issues**: [Reporta problemas aquí](https://github.com/RicardoRB/hispajug-website/issues)
- **Contribuciones**: [Guía de contribución](#-cómo-contribuir)

---

Hecho con ❤️ por la comunidad Java hispanohablante


