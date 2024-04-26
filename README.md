# Biblioteca Digital

## Objetivo
El objetivo de este ejercicio es que el alumno sepa digitalizar un producto. Para ello, se deberán obtener todas las necesidades del cliente y se deberá transformar la necesidad del cliente en una solución digital.
Biblioteca Digital Debido al auge del formato digital, la biblioteca digital de Ávila necesita una aplicación que permita catalogar todo tipo de colecciones digitales: libros, música, vídeos, software, etc.  

La biblioteca necesita ir clasificando colecciones digitales por lo que no puede esperar a que se desarrolle por completo la aplicación. Nos comenta que inicialmente quiere clasificar libros digitales. Además, necesita poder gestionar la biblioteca, para ello necesita:
- Dar de alta, baja o modificar los datos de un usuario.
- Consultar los usuarios dados de alta en la biblioteca digital.
- Dar de alta, baja o modificar los datos de un recurso: libros digitales.
- Consultar los recursos digitales dados de alta.
- Crear o eliminar un préstamo.
- Consultar los préstamos aún por finalizar. Es decir, préstamos que aún no se ha devuelto el recurso.
- Consultar los préstamos ya finalizados. Es decir, préstamos en los que ya se ha devuelto el recurso prestado.

**Nota**:
Un usuario es una persona que puede reservar un recurso digital.  

El alumno deberá:
- El proyecto debe seguir la estructura de paquete inicial: com.iesam.digitalibrary
- El proyecto creado debe ser la arquitectura: Clean Architecture con tres capas: presentation, domain y data. La capa de data debe tener dos fuentes de datos: local y remoto.
- Gestionar este proyecto a nivel de código con GitHub:  
  - Se usará un sistema de tickets o issue que describa la implementación a realizar. 
  - Se crearán ramas por cada ticket propuesto. 
  - Se seguirá una metodología GitFlow para la gestión de las ramas. 
  - Los commits deberán seguir el formato recomendado en clase.
- El modelado de las clases lo decidirá el alumno, es decir, el alumno decidirá los atributos que debe llevar una clase. Se recomienda seguir un enfoque lo más realista posible.
- Se deberá realizar todos los test posibles.

## Gestión de Tickets
En el ámbito del desarrollo de software, un ticket o una issue, es información que requiere una implementación.  
Para realizar una implementación debemos previamente crear un ticket. Se tiene que añadir esta información:
- Título de lo que se desea desarrollar.
- Descripción de lo que se desea desarrollar.

## Controlador de Versiones

## Gestión de ramas
Para la gestión de ramas vamos a usar tres tipos de ramas:
- feature: se añade una nueva funcionalidad.
- hotfix: se soluciona un problema.
- release: se crea una nueva versión para la aplicación.
- chore: para tareas de mantenimiento, renombrado, etc.
- test: para añadir nuevos test.
- docs: escribir comentarios

El nombre de una rama sigue esta estructura:

(feature | hotfix | release | chore | test)/ID_TICKET/nombre_rama

Ejemplo para una nueva funcionalidad:
feature/123/crear_ebooks

Ejemplo para un renombrado de clases:
chore/122/renombrado_clases_ebooks

## Gestión de commits
Se van a distinguir los siguientes tipos de commits:
- feat: se añade una nueva funcionalidad.
- fix: se soluciona un problema.
- chore: para tareas de mantenimiento, renombrado, etc.
- test: para añadir nuevos test.

Por cada funcionalidad implementada se deberá hacer un commit que seguirá esta estructura:  
 
tipo: título
(espacio)  
Descripción  

Ejemplo:
 feat: Creación de Libros
 
 Se crean los casos de usos para añadir libros digitales.
