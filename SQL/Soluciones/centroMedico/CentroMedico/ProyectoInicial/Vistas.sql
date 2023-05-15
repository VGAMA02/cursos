CREATE VIEW PacientesTurnosPendientes as

SELECT P.idPaciente, P.nombre,P.apellido,T.idTurno,T.estado
    from paciente P
	INNER JOIN TurnoPaciente TP
	ON TP.idPaciente = P.idPaciente
	INNER JOIN TURNO T
	ON T.idTurno = TP.idTurno
WHERE isnull(T.estado,0) = 0

SELECT * FROM PacientesTurnosPendientes
SELECT * FROM VistaPrueba