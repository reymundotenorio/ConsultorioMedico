Create database Clinica;

Use Clinica;

Create Table Especialidad (
    ID_Especialidad int unsigned not null auto_increment unique primary key,
    Nombre nvarchar(50) not null,
    Descripcion nvarchar(150) not null,
    Estado boolean default true not null
);

Create Table Medico (
    ID_Medico int unsigned not null auto_increment unique primary key,
    Nombres nvarchar(100) not null,
    Apellidos nvarchar(100) not null,
 /*   Hora_Inicial nvarchar(15) not null,
    Hora_Final nvarchar(15) not null,*/
    ID_Especialidad int unsigned not null,
    Foreign Key (ID_Especialidad)references Especialidad (ID_Especialidad),
  /*  L boolean default false not null,
    M boolean default false not null,
    X boolean default false not null,
    J boolean default false not null,
    V boolean default false not null,
    S boolean default false not null,
    D boolean default false not null,*/
    ID_Usuario int unsigned default 0 not null,
    Estado boolean default true not null
);

Create Table Paciente (
    ID_Paciente int unsigned not null auto_increment unique primary key,
    Nombres nvarchar(100) not null,
    Apellidos nvarchar(100) not null,
    Peso float not null,
    Altura float not null,
    Edad int not null,
    Telefono nvarchar(9) not null,
    Alergias nvarchar(200) not null,
    Enfermedades nvarchar(200) not null,
    Tipo_Sangre nvarchar(5) not null,
    Estado boolean default true not null
);

Create Table Cita (
    ID_Cita int unsigned not null auto_increment unique primary key,
    Fecha_Cita date not null,
    Hora_Cita nvarchar(15) not null,
    Dia_Cita nvarchar(15) not null,
    Semana_Cita int not null,
    ID_Medico int unsigned not null,
    Foreign Key (ID_Medico)
        references Medico (ID_Medico),
    ID_Paciente int unsigned not null,
    Foreign Key (ID_Paciente)
        references Paciente (ID_Paciente),
    Estado nvarchar(15) not null
);

Create Table Servicio (
    ID_Servicio int unsigned not null auto_increment unique primary key,
    Nombre_Servicio nvarchar(50) not null,
    Descripcion_Servicio nvarchar(150) not null,
    Precio_Servicio decimal(20 , 2 ) not null,
    Estado boolean default true not null
);

Create Table Usuario (
    ID_Usuario int unsigned not null auto_increment unique primary key,
    Nombre_Usuario nvarchar(50) not null,
    Contrasena_Usuario nvarchar(100) not null,
    Rol_Usuario nvarchar(20) not null,
    Estado boolean default true not null
);

Create Table Consulta (
    ID_Consulta int unsigned not null auto_increment unique primary key,
    ID_Cita int unsigned not null,
    Foreign Key (ID_Cita) references Cita (ID_Cita),
    Descripcion_Consulta nvarchar(200) not null,
    Diagnostico nvarchar(200) not null,
    Receta nvarchar(500) not null,
    Estado boolean default true not null
);

Insert into Usuario (Nombre_Usuario, Contrasena_Usuario, Rol_Usuario)
values ('Admin', '1234', 'Admin');

Create Table Pago (
    ID_Pago int unsigned not null auto_increment unique primary key,
    Fecha_Pago timestamp default current_timestamp not null,
    ID_Paciente int unsigned not null,
    Foreign Key (ID_Paciente)
        references Paciente (ID_Paciente),
    ID_Usuario int unsigned not null,
    Foreign Key (ID_Usuario)
        references Usuario (ID_Usuario),
    Estado boolean default true not null
);

Create Table Detalle_Pago (
    ID_Detalle_Pago int unsigned not null auto_increment unique primary key,
    ID_Pago int unsigned not null,
    Foreign Key (ID_Pago) references Pago (ID_Pago),
    ID_Servicio int unsigned not null,
    Foreign Key (ID_Servicio)references Servicio (ID_Servicio),
    Cantidad int unsigned not null,
    Estado boolean default true not null
);


Create Table Dia_Medico(
	ID_Dia_Medico int unsigned not null auto_increment unique primary key,
	ID_Medico int unsigned not null,
    Foreign Key (ID_Medico) references Medico (ID_Medico),
	Dia nvarchar(1) not null,
	Estado boolean default true not null
);

Create Table Hora_Medico(
	ID_Hora_Medico int unsigned not null auto_increment unique primary key,
	ID_Dia_Medico int unsigned not null,
    Foreign Key (ID_Dia_Medico) references Dia_Medico (ID_Dia_Medico),
	Hora_Inicial nvarchar(15) not null,
    Hora_Final nvarchar(15) not null,
	Estado boolean default true not null
);


/*====================PROCEDIMIENTOS ALMACENADOS=============================*/

/*=== AGREGAR ===*/

Create Procedure CitaAtendida(IN ID int unsigned)
Update Cita
Set Estado = "Atendida"
Where ID_Cita = ID;

Create Procedure AgregarEspecialidad(
IN Nombre Nvarchar (50), IN Descripcion Nvarchar (150)
)
Insert Into Especialidad
(Nombre,
Descripcion
)
Values(Nombre, Descripcion)
;


Create Procedure AgregarMedico(
IN Nombres Nvarchar (100), IN Apellidos Nvarchar (100), IN ID_Especialidad int
)
Insert Into Medico
(Nombres,
Apellidos,
ID_Especialidad
)
Values(Nombres, Apellidos, ID_Especialidad);

Create Procedure AgregarDia_Medico(
IN ID_MedicoD int, IN DiaM Nvarchar (1)
)
Insert Into Dia_Medico
(ID_Medico,
Dia
)
Values(ID_MedicoD, DiaM)
;

Create Procedure AgregarHora_Medico(
IN ID_Dia_MedicoD int, IN HoraInicioM Nvarchar (15), IN HoraFinalM Nvarchar (15)
)
Insert Into Hora_Medico
(ID_Dia_Medico,
Hora_Inicial,
Hora_Final
)
Values(ID_Dia_MedicoD, HoraInicioM, HoraFinalM)
;


Create Procedure AgregarPaciente(
IN Nombres Nvarchar (100), IN Apellidos Nvarchar (100), IN Peso Float,
IN Altura Float, IN Edad Int, IN Alergias Nvarchar(200), IN Enfermedades Nvarchar(200),
IN Tipo_Sangre Nvarchar(5), IN Telefono nvarchar(9)
)
Insert Into Paciente
(Nombres,
Apellidos,
Peso,
Altura,
Edad,
Alergias,
Enfermedades,
Tipo_Sangre, 
Telefono
)
Values(Nombres, Apellidos, Peso, Altura, Edad, Alergias, Enfermedades, Tipo_Sangre,
Telefono);


Create Procedure AgregarCita(
IN Fecha_Cita date, IN Hora_Cita nvarchar(15), IN ID_Medico int, IN ID_Paciente int,
IN Estado nvarchar(15), IN Dia_Semana nvarchar(15), IN Semana_Cita int
)
Insert Into Cita
(Fecha_Cita,
Hora_Cita,
ID_Medico,
ID_Paciente,
Estado,
Dia_Cita, 
Semana_Cita
)
Values(Fecha_Cita, Hora_Cita, ID_Medico, ID_Paciente, Estado, Dia_Semana, Semana_Cita);


Create Procedure AgregarServicio(
IN Nombre Nvarchar (50), IN Descripcion Nvarchar (150), IN Precio decimal(20,2)
)
Insert Into Servicio
(Nombre_Servicio,
Descripcion_Servicio,
Precio_Servicio
)
Values(Nombre, Descripcion, Precio)
;

Create Procedure AgregarConsulta(
IN ID_Cita int, IN Consulta Nvarchar (200), IN Diagnostico nvarchar(200),
IN Receta nvarchar(500)
)
Insert Into Consulta
(ID_Cita,
Descripcion_Consulta,
Diagnostico,
Receta
)
Values(ID_Cita, Consulta, Diagnostico, Receta)
;


Create Procedure AgregarPago(
IN ID_Paciente int, IN ID_Usuario int
)
Insert Into Pago
(ID_Paciente,
ID_Usuario
)
Values(ID_Paciente, ID_Usuario)
;

Create Procedure AgregarDetallePago(
IN ID_Pago int, IN ID_Servicio int, IN Cantidad int
)
Insert Into Detalle_Pago
(ID_Pago,
ID_Servicio,
Cantidad
)
Values(ID_Pago, ID_Servicio, Cantidad)
;

Create Procedure AgregarUsuario(
IN Nombre nvarchar(50), IN Contrasena nvarchar(100),
IN Rol nvarchar(20)
)
Insert Into Usuario
(Nombre_Usuario,
Contrasena_Usuario,
Rol_Usuario
)
Values(Nombre, Contrasena, Rol)
;

Create Procedure UsuarioMedico(IN ID_M int unsigned, IN ID_U int unsigned)
Update Medico
Set ID_Usuario = ID_U
Where ID_Medico = ID_M;

/*=== MODIFICAR ===*/
Create Procedure ModificarEspecialidad(
IN ID int, IN Nombre Nvarchar (50), IN Descripcion Nvarchar (150)
)
Update Especialidad
Set Nombre = Nombre,
Descripcion = Descripcion
Where ID_Especialidad = ID;


Create Procedure ModificarMedico(
IN ID int, IN Nombres Nvarchar (100), IN Apellidos Nvarchar (100), IN ID_Especialidad int
)
Update Medico
Set Nombres = Nombres,
Apellidos = Apellidos,
ID_Especialidad = ID_Especialidad
Where ID_Medico = ID;


Create Procedure ModificarPaciente(
IN ID int, IN Nombres Nvarchar (100), IN Apellidos Nvarchar (100), IN Peso Float,
IN Altura Float, IN Edad Int, IN Alergias Nvarchar(200), IN Enfermedades Nvarchar(200),
IN Tipo_Sangre Nvarchar(5), IN Telefono nvarchar(9)
)
Update Paciente
Set Nombres = Nombres,
Apellidos = Apellidos,
Peso = Peso,
Altura = Altura,
Edad = Edad,
Alergias = Alergias,
Enfermedades = Enfermedades,
Tipo_Sangre = Tipo_Sangre,
Telefono = Telefono
Where ID_Paciente = ID;


Create Procedure ModificarServicio(
IN ID int, IN Nombre Nvarchar (50), IN Descripcion Nvarchar (150), IN Precio decimal(20,2)
)
Update Servicio
Set Nombre_Servicio = Nombre,
Descripcion_Servicio = Descripcion,
Precio_Servicio = Precio
Where ID_Servicio = ID;


Create Procedure ModificarConsulta(
IN ID int, IN Consulta Nvarchar (200), IN Diagnostico nvarchar(200),
IN Receta nvarchar(500)
)
Update Consulta
Set Descripcion_Consulta = Consulta,
Diagnostico = Diagnostico,
Receta = Receta
Where ID_Consulta = ID;




Create Procedure ModificarUsuario(
IN ID int, IN Nombre nvarchar(50), IN Contrasena nvarchar(100),
IN Rol nvarchar(20)
)
Update Usuario
Set Nombre_Usuario = Nombre,
Contrasena_Usuario = Contrasena,
Rol_Usuario = Rol
Where ID_Usuario = ID;



/*=== Eliminar ===*/


Create Procedure EliminarDia(IN ID int unsigned)
Delete from Dia_Medico Where ID_Medico = ID;

Create Procedure EliminarHora(IN ID int unsigned)
Delete from Hora_Medico Where ID_Dia_Medico = ID;


Create Procedure Activar_Especialidad(
IN ID int
)
Update Especialidad
Set Estado = true
Where ID_Especialidad = ID;

Create Procedure Desactivar_Especialidad(
IN ID int
)
Update Especialidad
Set Estado = false
Where ID_Especialidad = ID;


Create Procedure Activar_Medico(
IN ID int
)
Update Medico
Set Estado = true
Where ID_Medico = ID;

Create Procedure Desactivar_Medico(
IN ID int
)
Update Medico
Set Estado = false
Where ID_Medico = ID;


Create Procedure Activar_Paciente(
IN ID int
)
Update Paciente
Set Estado = true
Where ID_Paciente = ID;

Create Procedure Desactivar_Paciente(
IN ID int
)
Update Paciente
Set Estado = falseDetalle_Pago
Where ID_Paciente = ID;

Create Procedure Cancelar_Pago(
IN ID int
)
Update Pago
Set Estado = False
Where ID_Pago = ID;

Create Procedure Cancelar_DPago(
IN ID int
)
Update Detalle_Pago
Set Estado = False
Where ID_Pago = ID;

Create Procedure Activar_Servicio(
IN ID int
)
Update Servicio
Set Estado = true
Where ID_Servicio = ID;

Create Procedure Desactivar_Servicio(
IN ID int
)
Update Servicio
Set Estado = false
Where ID_Servicio = ID;


Create Procedure Activar_Usuario(
IN ID int
)
Update Usuario
Set Estado = true
Where ID_Usuario = ID;

Create Procedure Desactivar_Usuario(
IN ID int
)
Update Usuario
Set Estado = false
Where ID_Usuario = ID;

Create Procedure Cancelar_Cita(
IN ID int
)
Update Cita
Set Estado = "Cancelada"
Where ID_Cita = ID;


Create Procedure Activar_Consulta(
IN ID int
)
Update Consulta
Set Estado = true
Where ID_Consulta = ID;

Create Procedure Desactivar_Consulta(
IN ID int
)
Update Consulta
Set Estado = false
Where ID_Consulta = ID;


/*===== VISTAS =====*/


Create view CitaV as
    (Select 
        C.ID_Cita,
        C.ID_Medico,
        M.Nombres as 'Nombres_Med',
        M.Apellidos as 'Apellidos_Med',
        C.Fecha_Cita,
        C.Dia_Cita,
        C.Semana_Cita,
        C.Hora_Cita,
        P.Nombres,
        P.Apellidos,
        C.Estado
    from
        Cita C
            Inner Join
        Paciente P ON C.ID_Paciente = P.ID_Paciente
            Inner Join
        Medico M ON C.ID_Medico = M.ID_Medico);

Create view RecetaV as
    (Select 
        C.ID_Consulta,
        CC.ID_Cita,
        CC.Fecha_Cita,
        M.Nombres as 'NombresMed',
        M.Apellidos as 'ApellidosMed',
        E.Nombre as 'NombreEsp',
        P.Nombres,
        P.Apellidos,
        C.Receta
    from
        Consulta C
            Inner Join
        Cita CC ON C.ID_Cita = CC.ID_Cita
            Inner Join
        Medico M ON CC.ID_Medico = M.ID_Medico
            Inner Join
        Paciente P ON CC.ID_Paciente = P.ID_Paciente
            Inner Join
        Especialidad E ON M.ID_Especialidad = E.ID_Especialidad);

Create view MedicoV as
    (Select 
        M.ID_Medico,
        M.Nombres,
        M.Apellidos,
        E.Nombre,
 /*       M.Hora_Inicial,
        M.Hora_Final,
        M.L,
        M.M,
        M.X,
        M.J,
        M.V,
        M.S,
        M.D,*/
        M.Estado
    from
        Medico M
            Inner Join
        Especialidad E ON M.ID_Especialidad = E.ID_Especialidad);

Create View HorarioMedico as(
Select M.ID_Medico, M.Nombres, M.Apellidos, E.Nombre, D.Dia, H.Hora_Inicial,
Hora_Final, M.Estado
from Medico M
Inner Join Dia_Medico D
On M.ID_Medico = D.ID_Medico
Inner Join Hora_Medico H
On D.ID_Dia_Medico = H.ID_Dia_Medico
Inner Join Especialidad E
On M.ID_Especialidad = E.ID_Especialidad);

Create View Horario as(
Select M.ID_Medico, D.Dia, H.Hora_Inicial,
Hora_Final
from Medico M
Inner Join Dia_Medico D
On M.ID_Medico = D.ID_Medico
Inner Join Hora_Medico H
On D.ID_Dia_Medico = H.ID_Dia_Medico
Inner Join Especialidad E
On M.ID_Especialidad = E.ID_Especialidad);


Create view ConsultaV as
    (Select 
        C.ID_Consulta,
        CC.Fecha_Cita,
        M.Nombres as 'NombresMed',
        M.Apellidos as 'ApellidosMed',
        P.Nombres,
        P.Apellidos,
        C.Descripcion_Consulta,
		C.Diagnostico,
		C.Receta,
		C.Estado
        from
        Consulta C
            Inner Join
        Cita CC ON C.ID_Cita = CC.ID_Cita
            Inner Join
        Medico M ON CC.ID_Medico = M.ID_Medico
            Inner Join
        Paciente P ON CC.ID_Paciente = P.ID_Paciente
         );

Create View PagoV as (
Select P.ID_Pago, P.Fecha_Pago, PA.Nombres, PA.Apellidos, U.Nombre_Usuario,
SUM(S.Precio_Servicio * DP.Cantidad) as 'Total' , P.Estado
from Pago P
Inner Join Paciente PA
On P.ID_Paciente = PA.ID_Paciente
Inner Join Usuario U
On P.ID_Usuario = U.ID_Usuario
Inner Join Detalle_Pago DP
On P.ID_Pago = DP.ID_Pago
Inner Join Servicio S
On DP.ID_Servicio = S.ID_Servicio
);

Create View Detalle_PagoV as (
Select DP.ID_Pago, DP.ID_Detalle_Pago, S.Nombre_Servicio, S.Precio_Servicio, DP.Cantidad,
(S.Precio_Servicio * DP.Cantidad) as 'Total' , DP.Estado
from Detalle_Pago DP
Inner Join Servicio S
On DP.ID_Servicio = S.ID_Servicio
);


Create View HorarioV as (
Select DM.ID_Medico, DM.ID_Dia_Medico, HM.ID_Hora_Medico, DM.Dia, HM.Hora_Inicial, HM.Hora_Final
from Dia_Medico DM
Inner Join Hora_Medico HM
On DM.ID_Dia_Medico = HM.ID_Dia_Medico
);

Create View Expediente as (
Select P.ID_Paciente, M.ID_Medico, C.ID_Consulta, CC.Fecha_Cita, C.Descripcion_Consulta, C.Diagnostico, C.Receta, P.Nombres, P.Apellidos,
M.Nombres as 'NombreM', M.Apellidos as 'ApellidoM', E.Nombre as 'Especialidad'
From Consulta C
Inner Join Cita CC
On C.ID_Cita = CC.ID_Cita
Inner Join Paciente P
On CC.ID_Paciente = P.ID_Paciente
Inner Join Medico M
On CC.ID_Medico = M.ID_Medico
Inner Join Especialidad E
On M.ID_Especialidad = E.ID_Especialidad
Where C.Estado = true
);

