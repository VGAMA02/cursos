declare @fecha char(12)
declare @path varchar(150)
declare @name varchar(20)

set @fecha = Convert(char(8),GETDATE(),112) + replace(Convert(char(5),GETDATE(),108),':','')
set @path = 'D:\2-Cursos\SQL\BaseDatos\BackUp\CentroMedico' + @fecha + '.bak'
set @name = 'CentroMedico' + @fecha

BACKUP DATABASE CentroMedico
TO DISK = @path
WITH NO_COMPRESSION, NAME=@name