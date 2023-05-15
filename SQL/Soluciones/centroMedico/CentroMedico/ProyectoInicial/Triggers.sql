CREATE TRIGGER PacientesCreados ON Paciente
AFTER INSERT AS

IF(SELECT idpais FROM inserted) = 'MEX'
	INSERT INTO PacienteLog (idPaciente,idPais,fechaAlta)
		SELECT i.idpaciente, i.idpais, getdate() FROM inserted i 



--select * from PacienteLog