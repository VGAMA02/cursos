USE [CentroMedico]
GO
/****** Object:  StoredProcedure [dbo].[ALTA_Paciente]    Script Date: 09/08/2022 12:45:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROC [dbo].[ALTA_Paciente](
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

--EXEC ALTA_Paciente '2324324','Jorge','Lopez','20180518','calle90','MEX','','Jorge@gmail.com',''