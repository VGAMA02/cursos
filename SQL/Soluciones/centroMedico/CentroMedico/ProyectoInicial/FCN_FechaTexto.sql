print dbo.FCN_Fechatexto ('20190501')


ALTER FUNCTION FCN_FechaTexto(@fecha datetime)
returns varchar(60)
as
begin

declare @dia varchar(20)
declare @mes varchar(20)
declare @fechatexto varchar(50)
set @dia = (CASE WHEN datepart(dw,@fecha) = 1 then 'Domingo '  + convert(char(2),datepart(dd,@fecha))
				 WHEN datepart(dw,@fecha) = 2 then 'Lunes '  + convert(char(2),datepart(dd,@fecha))
				 WHEN datepart(dw,@fecha) = 3 then 'Martes '  + convert(char(2),datepart(dd,@fecha))
				 WHEN datepart(dw,@fecha) = 4 then 'Miércoles '  + convert(char(2),datepart(dd,@fecha))
				 WHEN datepart(dw,@fecha) = 5 then 'Jueves '  + convert(char(2),datepart(dd,@fecha))
				 WHEN datepart(dw,@fecha) = 6 then 'Viernes '  + convert(char(2),datepart(dd,@fecha))
				 WHEN datepart(dw,@fecha) = 7 then 'Sábado '  + convert(char(2),datepart(dd,@fecha))
			END)
set @mes = (CASE WHEN datepart(mm,@fecha) = 1 then 'Enero'
			WHEN datepart(mm,@fecha) = 2 then 'Febrero'
			WHEN datepart(mm,@fecha) = 3 then 'Marzo'
			WHEN datepart(mm,@fecha) = 4 then 'Abril'
			WHEN datepart(mm,@fecha) = 5 then 'Mayo'
			WHEN datepart(mm,@fecha) = 6 then 'Junio'
			WHEN datepart(mm,@fecha) = 7 then 'Julio'
			WHEN datepart(mm,@fecha) = 8 then 'Agosto'
			WHEN datepart(mm,@fecha) = 9 then 'Septiembre'
			WHEN datepart(mm,@fecha) = 10 then 'Octubre'
			WHEN datepart(mm,@fecha) = 11 then 'Nomviembre'
			WHEN datepart(mm,@fecha) = 12 then 'Diciembre'
		END)

set @fechatexto = @dia + 'de ' + @mes
RETURN @fechatexto
end