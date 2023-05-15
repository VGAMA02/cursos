EXEC SEL_EspecialidadesMedicas

CREATE PROC SEL_EspecialidadesMedicas
as
set nocount on

if exists(SELECT * FROM Especialidad)
	SELECT * FROM Especialidad
else
	SELECT 0 as resultado
