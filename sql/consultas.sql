--1.1. Mostrar las tareas por estado (tareas ordenadas)--
SELECT *
	FROM tarea
	ORDER BY id_estado

--1.2. Mostrar las tareas por estado (seleccionar un estado con una función)--
--1.2.1.Función--
CREATE OR REPLACE FUNCTION seleccionEstado(seleccion VARCHAR) RETURNS int AS
$$
DECLARE

BEGIN
	IF seleccion = 'Pendiente'
		THEN RETURN 1;
	END IF;
	IF seleccion = 'En progreso'
		THEN RETURN 2;
	END IF;
	IF seleccion = 'Completada'
		THEN RETURN 3;
	END IF;
	IF seleccion = 'Cancelada'
		THEN RETURN 4;
	END IF;
END;
$$
language PLPGSQL;

--1.2.2. Consulta SQL--
SELECT *
	FROM tarea
	WHERE id_estado = seleccionEstado('En progreso')


--2. Mostrar las tareas completadas--
SELECT *
	FROM tarea
	WHERE id_estado = 3