
# API Cotizador de seguros

### Instalación del proyecto

```bash
  git clone https://github.com/yeisonmenau/cotizador-seguros-api.git
```

### Abrir el XAMPP y asegurarse que el puerto de la base de datos sea 3306


![image](https://github.com/user-attachments/assets/be921d9f-e07c-48ca-b981-4dbcb7504886)

### Crear base de datos "ejemplo_uno"


![image](https://github.com/user-attachments/assets/1a276bf3-3e24-49bf-bf6e-64b2631b1675)

#### O también con el siguiente Query

![image](https://github.com/user-attachments/assets/2c15cd14-7535-4a62-aab8-f712f9ab1a9e)

### Ejecutar el main del proyecto 


![image](https://github.com/user-attachments/assets/af155c1a-c42e-4de7-96b3-e0d7f38c818d)

### Usuario Schemas

#### Post
```bash
{
  "cedula": "cedula123",
  "nombre": "fulano",
  "correo": "fulano@mail.com",
  "password": "fulano123"
}
```

#### Put

```bash
{
  "nombre": "Maria",
  "correo": "Maria@gmail.com",
  "password": "Maria123"
}
```

### Vehiculo Schemas

#### Post 
```bash
{
  "usuarioId": 16,
  "placa": "ABC123",
  "marca": "KIA",
  "modelo": 2023
}
```
#### Put 
```bash
{
  "marca": "MARCA X",
  "modelo": 2020
}
```


## Recomendaciones
  
//No se pueden borrar usuarios que tenga vehículos

//Para guardar un vehículo debe de ligarse a un usuario existente

//Sigue los Shemas para agregar y editar usario y vehículos 

## Documentation

[Documentation](http://localhost:8080/swagger-ui/index.html#/)

![image](https://github.com/user-attachments/assets/cba5f769-24ad-42a0-84b6-6e5123f2957e)

