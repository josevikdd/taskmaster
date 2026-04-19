--Mostrar las tareas por estado--
SELECT *
	FROM tarea
	ORDER BY id_estado


--Mostrar las tareas completadas--
SELECT *
	FROM tarea
	WHERE id_estado = 3