CREATE FUNCTION Concatenar(@apellido varchar(50),
	@nombre varchar(50)
)
returns varchar(100)
as
begin
	declare @resultado varchar(100)
	set @resultado = @apellido + ', ' + @nombre
	return @resultado
end

--select dbo.concatenar('Lopez','Ramirez')
--select dbo.obtenerPais(1)
ALTER FUNCTION obtenerPais(
	@idPaciente paciente
)
returns varchar(50)
as
begin
	declare @pais varchar(50)
	SET @pais =  (SELECT PA.pais from Paciente P
					INNER JOIN Pais PA
					ON PA.idPais = P.idPais
					where idPaciente = @idpaciente)
	return @pais
end

--FUNCIONES DE TIPO TABLA -->

CREATE FUNCTION ListaPaises()
returns @paises TABLE(idpais char(3),pais varchar(50))
as
begin
	insert into @paises values('ESP', 'España')
	insert into @paises values('MEX', 'Mexico')
	insert into @paises values('CHI', 'Chile')
	insert into @paises values('PER', 'Peru')
	insert into @paises values('ARG', 'Argentina')
	return
end

--Select * from dbo.ListaPaises()