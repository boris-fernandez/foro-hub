# Foro Hub - API REST  

![Portada del Proyecto](ruta/a/tu/imagen.png)  

## Índice  
1. [Título e imagen de portada](#foro-hub---api-rest)  
2. [Insignias](#Insignias)  
3. [Índice](#Índice)  
4. [Descripción del proyecto](#descripción-del-proyecto)  
5. [Estado del proyecto](#estado-del-proyecto)  
6. [Funcionalidades](#funcionalidades)  
7. [Acceso al proyecto](#acceso-al-proyecto)  
8. [Tecnologías utilizadas](#tecnologías-utilizadas)  
9. [Contacto](#contacto)  

---

## 📜 Insignias  
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)  

---

## 📝 Descripción del proyecto  
**Foro Hub** es una API REST diseñada para facilitar la interacción entre usuarios en un foro virtual. Proporciona un entorno robusto y eficiente para que los usuarios puedan publicar temas, responder discusiones, editar publicaciones y gestionar toda la información relacionada con el foro.

El sistema está pensado para comunidades de todos los tamaños, ofreciendo características avanzadas como autenticación segura, gestión de roles, y búsqueda personalizada. Además, su diseño modular y escalable permite una integración fluida con otras herramientas y sistemas, convirtiéndolo en una solución versátil para foros modernos.

Foro Hub prioriza la usabilidad y la seguridad, garantizando que los usuarios puedan interactuar de manera intuitiva y segura, mientras que los administradores tienen el control completo sobre la plataforma y su contenido. Este proyecto es ideal para fomentar la colaboración, el intercambio de ideas y el crecimiento de comunidades virtuales.

---

## 🔧 Estado del proyecto  
🚀 **En desarrollo**  
Actualmente, el proyecto incluye las funcionalidades básicas y se están añadiendo nuevas características. Próximamente se incorporará una interfaz gráfica para facilitar la interacción del usuario con el foro, mejorando la experiencia de uso y haciendo más accesible la gestión de las publicaciones y respuestas.

---

## ⚙️ Funcionalidades  

### 🗣️ **CRUD de Tópicos**  
- **Crear un nuevo tópico**:  
  - Los usuarios pueden crear nuevos tópicos.  
  - Solo los administradores pueden aprobar o gestionar tópicos creados por otros usuarios.  
- **Listar todos los tópicos creados**:  
  - Los usuarios pueden consultar todos los tópicos del foro.  
  - Los administradores tienen acceso completo para ordenar, filtrar y gestionar todos los tópicos.  
- **Consultar un tópico específico**:  
  - Los usuarios pueden ver un tópico específico y sus respuestas.  
  - Los administradores pueden consultar, modificar o eliminar cualquier tópico, independientemente de quién lo haya creado.  
- **Actualizar un tópico existente**:  
  - Los usuarios solo pueden actualizar los tópicos que han creado.  
  - Los administradores pueden actualizar cualquier tópico, sin importar su autor.  
- **Eliminar un tópico**:  
  - Los administradores pueden eliminar cualquier tópico creado por cualquier usuario.  
  - Los usuarios solo pueden eliminar los tópicos que han creado.

### 💬 **CRUD de Respuestas a Tópicos**  
- **Crear una respuesta**:  
  - Los usuarios pueden responder a los tópicos existentes.  
  - Solo los administradores pueden moderar y gestionar las respuestas de otros usuarios.  
- **Listar las respuestas a un tópico**:  
  - Los usuarios pueden ver las respuestas a un tópico específico.  
  - Los administradores pueden ver todas las respuestas, independientemente del autor del tópico.  
- **Actualizar una respuesta**:  
  - Los usuarios solo pueden actualizar las respuestas que han creado.  
  - Los administradores pueden actualizar cualquier respuesta, sin importar quién la haya creado.  
- **Eliminar una respuesta**:  
  - Los administradores pueden eliminar cualquier respuesta creada por cualquier usuario.  
  - Los usuarios solo pueden eliminar las respuestas que hayan creado.

### 🎓 **CRUD de Cursos**  
- **Crear un nuevo curso**:  
  - Los administradores pueden crear nuevos cursos.  
  - Los usuarios no tienen acceso para crear cursos.  
- **Listar todos los cursos**:  
  - Los usuarios pueden ver todos los cursos disponibles.  
  - Los administradores pueden acceder a todos los cursos y gestionarlos.  
- **Consultar un curso por ID**:  
  - Los usuarios pueden consultar un curso específico usando su ID (ruta: `GET /cursos/{id}`).  
  - Los administradores pueden ver detalles de cualquier curso, independientemente de su autor.  
- **Consultar cursos por categoría**:  
  - Los usuarios pueden ver los cursos que pertenecen a una categoría específica (ruta: `GET /cursos/categoria/{categoria}`).  
- **Actualizar un curso**:  
  - Los administradores pueden actualizar cualquier curso usando su ID (ruta: `PUT /cursos/{id}`).  
  - Los usuarios no pueden actualizar cursos.  
- **Eliminar un curso**:  
  - **Los administradores pueden eliminar cualquier curso** usando su ID (ruta: `DELETE /cursos/{id}`).  
  - Los usuarios no tienen acceso para eliminar cursos.

### 👥 **CRUD de Usuarios**  
- **Crear un nuevo usuario**:  
  - **Solo los administradores** pueden crear nuevos usuarios a través de la API. Los administradores tienen control total sobre la creación de cuentas de usuario en el sistema.  
  - Los usuarios no tienen acceso a esta funcionalidad.  
- **Actualizar un usuario existente**:  
  - **Solo los administradores** pueden actualizar los detalles de un usuario (como cambiar el nombre, el correo, etc.).  
  - Los usuarios no pueden modificar sus propios datos a través de la API, ni los de otros usuarios.  
  - Los administradores pueden actualizar cualquier usuario según sea necesario.

### 🔐 **Autenticación y Autorización**  
- **Acceso restringido a ciertas funcionalidades según el rol del usuario**:  
  - **Administradores**:  
    - Pueden crear, actualizar usuarios.  
    - Tienen control total sobre las cuentas de usuario y sus roles.  
    - Pueden gestionar, actualizar y eliminar cualquier tópico, respuesta y curso.  
  - **Usuarios**:  
    - Pueden crear, leer, actualizar y eliminar solo los tópicos y respuestas que hayan creado.  
    - No tienen acceso a la gestión de usuarios ni a la eliminación de contenido ajeno.  
    - Pueden consultar los cursos y ver sus detalles, pero no pueden modificarlos ni eliminarlos.

### ✅ **Validaciones**  
- **Validaciones específicas basadas en reglas de negocio**:  
  - Se validan los datos de usuarios (como correo electrónico y contraseña).  
  - Se validan las publicaciones (tópicos, respuestas, y cursos) para asegurar que se cumplan con las normas del foro.  
  - Solo los administradores pueden realizar acciones como la eliminación de usuarios y contenido.

### 💾 **Persistencia**  
- **Almacenamiento de datos en una base de datos relacional**:  
  - Todos los datos (usuarios, tópicos, respuestas, cursos) se almacenan en una base de datos relacional (por ejemplo, MySQL).  
  - Esto asegura que la información se maneje de forma eficiente y coherente.

### 📖 **Documentación Automática**  
- **Swagger para exponer la documentación interactiva de la API**:  
  - Se utiliza Swagger para generar una documentación interactiva de la API, donde los desarrolladores pueden ver y probar las rutas disponibles de manera visual.  
  - La documentación también incluye detalles sobre los roles de usuario y los permisos asociados a cada funcionalidad.

---

## 🔑 Acceso al proyecto  
### Prerrequisitos  
- **Java** 11 o superior.  
- **Spring Boot**.  
- **MySQL**.

### Pasos para ejecutar el proyecto  
1. Clona este repositorio:  
   ```bash  
   git clone https://github.com/boris-fernandez/foro-hub.git

---
### Contacto
- **Desarrollador**: Boris Fernandez Cabrera
- **Email**: borisfernandezcabrera@gmail.com
- **GitHub**: boris-fernandez

---

**Gracias por revisar este proyecto. ¡Sigue programando y nunca dejes de aprender!** 🚀💻

**"El código es como el arte: siempre hay algo nuevo que aprender y mejorar."** 🎨👨‍💻
