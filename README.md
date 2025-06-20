# Sebastian Cepeda # API REST - Gestión de Clientes y Entregas (Salesforce)

## 📌 Descripción del Proyecto
>Tenemos como primer punto el modelado BPMN de un proceso de reclamos para motos seguido de un >video explicando este modelo.
>
>>![Nuevo Modelo](https://github.com/user-attachments/assets/1c1e80b0-12fa-41d1-a6c5-290a54fe224a)
>>
>
>
>>https://github.com/user-attachments/assets/c706a0a6-d5f2-4159-a401-7ed121c38c63
>>

Como segundo punto tenemos un  proyecto  que consiste en una API REST desarrollada con Spring Boot que permite gestionar **Clientes** y sus respectivas **Entregas** mediante integración directa con Salesforce (con una relación de 1 a muchos).  
A través de esta API se pueden:
- Crear nuevos clientes.
- Crear entregas asociadas a un cliente.
- Consultar entregas por cliente.
- Consultar clientes Creados.
- Actualizar el estado de una entrega (lo cual puede activar un Flow en Salesforce que cambia automáticamente la fecha de entrega).

>Objeto Personalizado Cliente
>>![image](https://github.com/user-attachments/assets/4d6ee2bc-1bcd-4d88-828f-7ebba9b267ab)
>
>Objeto Personalizado Entregas
>>![image](https://github.com/user-attachments/assets/863dfe84-486a-4910-9691-a691bd88d2a9)
>
>Flow Automatización
>>![image](https://github.com/user-attachments/assets/598a8f2e-327f-4560-9f7e-b677d62d6451)
>

## 🗂️ Estructura de Carpetas

```bash
src/
├── main/
│   ├── java/com/example/juan/
│   │   ├── controller/
│   │   ├── config/
│   │   ├── dto/
│   │   ├── service/
│   │   ├── model/
│   │   └── SalesforceAuthUtil 
│   └── resources/
│       └── application.properties
```
## Tecnologías utilizadas

- **Backend**: Spring Boot (Java)
- **Gestor de dependencias**: Maven
- **CRM**: SalesForce
## Requisitos previos
Asegúrate de tener instalados los siguientes programas:

- [Java 17 o superior](https://www.oracle.com/co/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
## Pasos para clonar el repositorio y ejecutar el proyecto

### 1. Clonar el repositorio

Clonar el repositorio en la máquina local utilizando el siguiente comando:

```bash
git clone https://github.com/tu_usuario/SebastianCepedaAPIPrueba.git
```
### 2. abrir el repositorio en su editor de preferencia

### 3. entrar a la siguiente ruta 
```bash
cd back
```
### 4.poner los siguientes comando 
```bash
mvn clean install
mvn spring-boot:run
```
luego podemos hacer las pruebas con postam
> Crea Cliente
>>![image](https://github.com/user-attachments/assets/7bdedbbc-1647-484e-87f0-64df7d5ad5d4)
>
> Crear Entregas
>> ![image](https://github.com/user-attachments/assets/7588cdd3-67b0-407b-96f1-957a8a62f2e0)
>
> Ver Clientes Creados
>> ![image](https://github.com/user-attachments/assets/d2909ee6-4353-4fe4-ba66-0d4b5230df38)
>
> Ver Entregas de un cliente
>>![image](https://github.com/user-attachments/assets/b678204d-fefc-487e-9911-c4392aa6ced7)
>
> Modificar estado entrega
>> ![image](https://github.com/user-attachments/assets/2571f92d-293e-4c1f-b2ab-98a7ff1dfb34)
>

>




