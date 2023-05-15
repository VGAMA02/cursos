--select * from TurnoPaciente
ALTER PROC ALTA_Medico(
	@nombre varchar(50), --20190215 12:00
	@apellido  varchar(20),
	@idespecialidad  int,
	@descripcion varchar(50) = ''
	)

as

/*
Estado = 0 pendiente
= 1 realizado
= 2 cancelado
*/

if NOT exists(select TOP 1 idMedico from Medico where nombre = @nombre AND apellido=@apellido)
BEGIN
	INSERT INTO Medico (nombre,apellido) VALUES (@nombre,@apellido)

	DECLARE @auxIdMedico int
	set @auxidMedico = @@IDENTITY

	INSERT INTO MedicoEspecialidad (idMedico,idEspecialidad,descripcion)
	VALUES (@auxIdMedico,@idespecialidad,@descripcion)

	print 'El Medico se agrego correctamente'
	return
END
ELSE
BEGIN
	print 'El Medico ya Existe'
	return
END
--EXEC ALTA_Medico 'Juan','Molina',1,'Don'
