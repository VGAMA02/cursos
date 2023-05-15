select * from paciente
BEGIN TRANSACTION
	update paciente set telefono = 444 where idPaciente = 2
	if @@ROWCOUNT = 2
	BEGIN 
		COMMIT TRANSACTION
	END
	ELSE
	BEGIN
		ROLLBACK TRAN
	END
	
