--select * from turno
--select * from turnoPaciente
Alter PROC ALTA_Turno(
	@fecha char(14), --20190215 12:00
	@idpaciente  paciente,
	@idmedico  medico,
	@observacion observacion = ''
	)

as

/*
Estado = 0 pendiente
= 1 realizado
= 2 cancelado
*/

if NOT exists(select TOP 1 idTurno from Turno where fechaTurno = @fecha)
BEGIN
	INSERT INTO Turno (fechaTurno,estado,observacion)
	VALUES (@fecha,0,@observacion)

	DECLARE @auxIdTurno turno
	set @auxIdTurno = @@IDENTITY

	INSERT INTO TurnoPaciente (idTurno,idPaciente,idMedico) VALUES (@auxIdTurno,@idpaciente,@idmedico)

	print 'El Turno se agrego correctamente'
	return
END
ELSE
BEGIN
	print 'El Turno ya Existe'
	return
END
--insert into medico values ('Goku','Fernandez')
EXEC ALTA_Turno '20190218 08:15',2,1,'El paciente tiene que estar en ayunas'
select * from TurnoPaciente