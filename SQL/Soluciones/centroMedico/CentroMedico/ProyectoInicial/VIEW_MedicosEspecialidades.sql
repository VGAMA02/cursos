
-- Select * from VIEW_MedicosEspecialidades
CREATE VIEW VIEW_MedicosEspecialidades AS

select M.idMedico, M.nombre, M.apellido, ME.idEspecialidad, ME.descripcion from Medico M
INNER JOIN MedicoEspecialidad ME
ON ME.idMedico = M.idMedico
