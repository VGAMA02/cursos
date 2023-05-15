 EXEC SEL_HistoriaPaciente 2

alter PROC SEL_HistoriaPaciente(
	@idpaciente paciente
)
as
set nocount on

/*
SELECT * FROM historia
SELECT * FROM historiaPaciente
*/
IF EXISTS(SELECT * FROM Paciente P
INNER JOIN HistoriaPaciente HP
ON HP.idPaciente = P.idPaciente
INNER JOIN Historia H
ON H.idHistoria = HP.idHistoria
INNER JOIN MedicoEspecialidad ME
ON ME.idMedico = HP.idMedico
INNER JOIN Medico M
ON M.idMedico = ME.idMedico
WHERE P.idPaciente = @idpaciente)

SELECT * FROM Paciente P
INNER JOIN HistoriaPaciente HP
ON HP.idPaciente = P.idPaciente
INNER JOIN Historia H
ON H.idHistoria = HP.idHistoria
INNER JOIN MedicoEspecialidad ME
ON ME.idMedico = HP.idMedico
INNER JOIN Medico M
ON M.idMedico = ME.idMedico
WHERE P.idPaciente = @idpaciente


ELSE
PRINT 'No existen Resutaldos'

