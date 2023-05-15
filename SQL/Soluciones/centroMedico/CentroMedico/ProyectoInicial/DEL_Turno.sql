EXEC DEL_turno 1002
/*
select * from turno
select * from turnoPaciente
*/

alter PROC DEL_turno(
	@idturno turno
)
as
set nocount on

IF exists(SELECT * FROM Turno Where idTurno = @idturno)
BEGIN
	DELETE FROM TurnoPaciente WHERE idTurno = @idturno
	DELETE FROM Turno WHERE idTurno = @idturno
END
ELSE
	SELECT 0 as resultado