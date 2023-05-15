EXEC SELECT_TurnosPaciente 2

alter PROC SELECT_TurnosPaciente(
	@idpaciente paciente
)
as 
set nocount on
--SELECT * FROM TurnoPaciente

--insert into MedicoEspecialidad values(1,2,'Medico Clinico')

SELECT * FROM Paciente P
INNER JOIN TurnoPaciente TP
ON TP.idPaciente = P.idPaciente
INNER JOIN Turno T
ON T.idTurno = TP.idPaciente
inner join MedicoEspecialidad M
ON M.idEspecialidad = TP.idMedico
WHERE P.idPaciente = @idpaciente