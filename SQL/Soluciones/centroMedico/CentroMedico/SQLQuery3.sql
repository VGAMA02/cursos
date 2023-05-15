USE [CentroMedico]
GO
/****** Object:  StoredProcedure [dbo].[S_paciente]    Script Date: 25/07/2022 06:06:44 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROC [dbo].[S_paciente] (
	@idpaciente int
)
AS

SELECT *,
(SELECT pais FROM Pais ps WHERE ps.idPais = pa.idPais) descPais 
FROM paciente pa WHERE idPaciente = @idpaciente

