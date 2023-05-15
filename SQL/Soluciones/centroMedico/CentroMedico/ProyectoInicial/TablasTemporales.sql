--Tabla temporal em memoria

DECLARE @mitabla TABLE(id int IDENTITY(1,1), pais varchar(50))
INSERT INTO @mitabla values('Mex')
INSERT INTO @mitabla values('Per')
INSERT INTO @mitabla values('Arg')
INSERT INTO @mitabla values('Chi')

Select * from @mitabla

--TABLA TEMPORAL FISICA esta tabla existe mientras el servicio este activo cuando se reinicie la tabla morira.

CREATE TABLE #mitabla(id int IDENTITY(1,1), nombre varchar(50), apellido varchar(50))
INSERT INTO #mitabla values ('juan', 'Ramirez')
INSERT INTO #mitabla values ('jose', 'Ramirez')
INSERT INTO #mitabla values ('julian', 'Ramirez')

Select * from #mitabla

--SCRIPT



declare @turnos table (id int IDENTITY(1,1),idTurno turno, idpaciente paciente)
declare @idPA paciente
set @idPA = 1003
INSERT into @turnos (idTurno,idpaciente)
select TP.idTurno, TP.idTurno from Paciente P
inner join TurnoPaciente TP
on TP.idPaciente = P.idPaciente
declare @i int,@total int
set @i = 1
set @total = (select count(*) from @turnos)

while @i <= @total
begin
	if(select idpaciente from @turnos where id = @i) <> 1003
		delete from @turnos where id = @i

	set @i = @i + 1
end


select * from Paciente P
inner join @turnos T
ON T.idpaciente = P.idpaciente


CREATE PROC 
