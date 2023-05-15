select * from paciente
select * from TurnoPaciente
--busca un elemento que exista en ambas tablas.
select * from Paciente P
INNER JOIN TurnoPaciente T
ON P.idpaciente = T.idPaciente
--Trae todo de la primera tabla y los resultados que se unen combinando las columnas.
select * from Paciente P
LEFT JOIN TurnoPaciente T
ON P.idpaciente = T.idPaciente

select * from Paciente P
Right JOIN TurnoPaciente T
ON P.idpaciente = T.idPaciente

--union permite 2 resultados de 2 consultas diferentes
--No suele funcionar con diferentes tablas, union requiere que los campos sean los mismos con los mismos tipos de datos
--union quita las repeticiones UNION ALL trae todo.
SELECT * from turno where estado = 1
UNION
SELECT * from turno where estado = 2