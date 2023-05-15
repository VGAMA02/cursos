declare @var1 varchar(50)
set @var1 = 'Maximo decimo melirio'
print left(@var1,4)
print right(@var1,4)
print LEN(@var1)
print LOWER(@var1) + ' ' + UPPER(@var1)
print REPLACE(@var1,'e','')
print REPLICATE('AGRIA',5)
print LTRIM(RTRIM('   GOKU     '))
print CONCAT(@var1,' ',':D')
print GETDATE()
print GETUTCDATE()
print DATEADD(hour,1,GETDATE())
print DATEADD(day,2,GETDATE())
print DATEDIFF(hour,GETDATE(),GETUTCDATE())
print DATEPART(month,GETDATE())
print DATEPART(YEAR,GETDATE())
print ISDATE(GETDATE())

--CAST Genera un tipo de dato en otro mientras sea de la misma familia ejemplo int a decimal
--CONVERT convierte los datos
declare @var money
declare @f datetime
set @f = GETDATE()
set @var = 500.50
SELECT CAST(@var as int) AS Resultado
SELECT Convert(char(30), @f,112) AS ResultadoC