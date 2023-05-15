
/*
select * from turno
select * from turnoPaciente
*/
EXEC UPD_Turno 1,2,'El paciente llamo cancelar'
ALTER PROC UPD_Turno(
	@idturno turno,
	@estado smallint,
	@observacion observacion
)
as
set nocount on

IF exists(SELECT * FROM Turno Where idTurno = @idturno)
	UPDATE Turno SET estado = @estado, observacion = @observacion WHERE idTurno = @idturno
ELSE
	SELECT 0 as resultado