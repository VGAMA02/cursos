declare @idpaciente int
declare @idturno int
set @idpaciente = 7
/*if
IF @idpaciente = 7
BEGIN
	SET @idturno = 20
	SELECT * FROM Paciente where idPaciente = @idpaciente
	print @idturno

	IF EXISTS(SELECT * FROM Paciente WHERE idPaciente = 2)
	BEGIN
		print 'Existe'
	END

END
ELSE
BEGIN
	SELECT * FROM Paciente where idPaciente != @idpaciente
END
*/



declare @contador int = 0
WHILE @contador <= 10
BEGIN
	print @contador
	SET @contador = @contador + 1
	if @contador = 3 BREAK
	/*RETURN SACA A LA CONSOLA, EL BREAK SACA DE LA ESTRUCTURA DE CONTROL PERO NO DEL SCRIPT */

END
print 'Sigue Ejecutando'


BEGIN TRY
	set @contador = 'texto'
END TRY

BEGIN CATCH
	print 'No es posible asingar un texto a la variable @contador'
END CATCH



/* CASE 
declare @valor int
declare @resultado char(10)=''
set @valor = 20

set @resultado = (CASE WHEN @valor = 10 THEN 'ROJO'
						WHEN @valor = 20 THEN 'VERDE'
						WHEN @valor = 30 THEN 'AZUL'
						END)
print @resultado
select * , (CASE WHEN estado = 1 THEN 'ROJO'
						WHEN estado = 2 THEN 'VERDE'
						WHEN estado = 3 THEN 'AZUL'
						ELSE 'GRIS'
						END) Color from turno
*/

