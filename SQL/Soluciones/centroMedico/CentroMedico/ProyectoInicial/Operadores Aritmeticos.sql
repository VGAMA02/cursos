declare @num1 decimal(9,2) = 10
declare @num2 decimal(9,2) = 20
declare @result decimal(9,2)

declare @c1 varchar(20) = 'Buenas'
declare @c2 varchar(20) = ' las tenga'
declare @resultc varchar(40)


set @result = @num1 + @num2
set @resultc = @c1 + @c2
--set @result = @num1 - @num2
--set @result = @num1 * @num2
--set @result = @num1 / @num2
--set @result = @num1 % @num2
print @result
print @resultc

if @num1 > @num2
	print 'Simon'
else
	print 'Nel'

if @c1 > @c2 -- las cadenas de texto lo que va a comparar es el valor del orden alfabetico no el tamaño de la cadena
	print 'Simon'
else
	print 'Nel'