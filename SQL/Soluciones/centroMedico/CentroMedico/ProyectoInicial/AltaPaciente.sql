--select * from paciente
CREATE PROC ALTA_Paciente(
	@dni varchar(20),
	@nombre varchar(50),
	@apellido varchar(50),
	@fnacimiento varchar(8),
	@domicilio varchar(50),
	@idpais char(3),
	@tel varchar(20) = '',
	@email varchar(30),
	@observacion varchar(1000) = ''
	)

as

if NOT exists(select * from Paciente where dni=@dni)
BEGIN
	INSERT INTO Paciente (dni,nombre,apellido,fnacimiento,domicilio,idpais,telefono,email,observacion)
	VALUES (@dni,@nombre,@apellido,@fnacimiento,@domicilio,@idpais,@tel,@email,@observacion)
	print 'El paciente se agrego correctamente'
	return
END
ELSE
BEGIN
	print 'El paciente Existe'
	return
END

EXEC ALTA_Paciente '2324924',',Verde','Lopez','20180518','calle90','MEX','','jorge@gmail.com',''
select * from Paciente