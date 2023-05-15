--select * from paciente
ALTER PROC ALTA_Especialidad(
	@especialidad varchar(30)
	)

as

if NOT exists(select * from Especialidad where especialidad=@especialidad)
BEGIN
	INSERT INTO Especialidad (especialidad)
	VALUES (@especialidad)
	print 'La especialidad se agrego correctamente'
	return
END
ELSE
BEGIN
	print 'La especialidad ya Existe'
	return
END

EXEC ALTA_Especialidad 'Cirugia'
select * from Especialidad