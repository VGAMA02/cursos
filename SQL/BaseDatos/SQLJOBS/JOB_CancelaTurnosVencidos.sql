USE CentroMedico
GO
update Turno set estado = 2 where CONVERT(char(8),fechaTurno,112) < CONVERT(char(8),GETDATE(),112)
and estado = 0