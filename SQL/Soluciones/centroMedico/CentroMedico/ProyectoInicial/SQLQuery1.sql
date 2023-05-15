CREATE PROC S_paciente (
	@idpaciente int
)
AS

SELECT *,
(SELECT pais FROM Pais WHERE idpais = idpais) 
FROM paciente WHERE idPaciente = @idpaciente

GO

