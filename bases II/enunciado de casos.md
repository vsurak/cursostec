# caso #1, 10%

*instituto tecnológico de costa rica*, escuela de computación  
*bases de datos II*  
_prof. rodrigo núñez_  
*tipo:* parejas  

## descripción
la empresa ferianueva de costa rica quiere crear una plataforma web donde las personas inscritas puedan comprar frutas, verduras y otros productos de consumo que estaban destinados a ser desperdicio. ferianueva se encarga de recoger dichas frutas y verduras, restaurarlos para que sean aprovechables para consumo; tomar productos procesados o otros que tienen defectos o fechas próximos a vencimiento que ha recolectado de un proceso logístico y los vende en un ecomerce. una vez que una persona registrada compra los productos, ferianueva se encarga de entregarlos en una única ruta que hace 2 veces por semana.

entre los retos más importantes que tiene feria nueva son:

1. mantener el inventario de productos disponible incluso con antelación desde antes de irlo a recoger y luego de restaurarlo

2. organizar en el espacio físico de bodegaje el producto listo para vender y entregar

3. que el camión de entrega sepa bien que productos son los que tiene que entregarle a cada persona en la ruta en ese día

4. asegurarse que el consumidor reciba un producto en buen estado y que el repartidor le haya dado un servicio amable y completo

proceda a realizar un diseño para la base de datos de ferianueva hecho en sql server. luego una vez que tenga el diseño proceda a cargar de información de tal forma que se tengan: 

- al menos 15 productos
- al menos 20 personas registradas
- entre 1 a 3 ordenes de varios productos por persona en 4 semanas en el pasado y que hayan sido entregadas

el líder técnico quiere que usted le demuestre con su base de datos diseñada, implementada y con datos que podrá dar respuesta a las siguientes incognitas:

## preliminar #1, 15 de febrero, 20pts
1. cuál es el top 5 de compradores estrella

2. cuál es el top 5 de productos más vendidos en los últimos 15 días

3. cuál es el total de compras por persona

4. cuál es el total vendido por producto 

- contenido: un archivo sql con todos los scripts necesarios

## preliminar #2, 22 de febrero, 40pts

5. determinar si existe al menos una diferencia de carga de trabajo del 20% entre los dos días de entrega

6. cuáles son las principales razones por las que el consumidor devuelve producto

7. demostrar que las operaciones de ordenar productos y agregar productos a bodega pueden ser transaccionales 

8. demostrar si va a ser posible crear vistas que ayuden a la implementación del sistema

- contenido: un archivo sql con todos los scripts necesarios

## entrega final #3, 27 de febrero, 40pts
9. demostrar bajo que circustancias en su modelo podrían suceder problemas de dirty read, lost update y phantoms

10. demostrar bajo que circustancias en su modelo podrían darse deadlocks 

11. como se defiende su modelo ante fraudes donde el sistema se ve comprometido con los datos para beneficio de alguna persona 

- contenido: un archivo sql con todos los scripts necesarios

## aspectos operativos
- entrega al asistente al correo: fvsasistencia@gmail.com
- subject: bases 2 - caso #1 - <entregable> 


---

# caso #2, 7%

*instituto tecnológico de costa rica*, escuela de computación  
*bases de datos II*  
_prof. rodrigo núñez_  
*tipo:* parejas  

Proceda a generar en una base de datos la siguiente tabla debidamente rellena basado en el script a continuación:

```sql
USE [hacker_rank]
GO

/****** Object:  Table [dbo].[hackerranklog]    Script Date: 2/20/2023 10:43:23 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[hackerranklog]') AND type in (N'U'))
DROP TABLE [dbo].[hackerranklog]
GO

/****** Object:  Table [dbo].[hackerranklog]    Script Date: 2/20/2023 10:43:23 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[hackerranklog](
	[logid] [bigint] IDENTITY(1,1) NOT NULL,
	[posttime] [datetime] NOT NULL,
	[exercise] [int] NOT NULL,
	[level] [varchar](10) NOT NULL,
	[type] [varchar](20) NOT NULL,
	[username] [varchar](34) NOT NULL,
	[points] [smallint] NOT NULL,
	[duration] [smallint] NOT NULL,
	[result] [varchar](20) NOT NULL,
 CONSTRAINT [PK_hackerranklog] PRIMARY KEY CLUSTERED 
(
	[logid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


DECLARE @AMOUNT_OF_RECORDS INT
DECLARE @PostTime DATETIME
DECLARE @Exercise_Number INT
DECLARE @Points INTEGER

SET @AMOUNT_OF_RECORDS = 25000

WHILE @AMOUNT_OF_RECORDS>0 BEGIN
	SET @PostTime = DATEADD(dd, ABS(CAST(CAST(NEWID() AS VARBINARY) AS INT))%1345*-1, GETDATE())
	SET @Exercise_Number = ABS(CAST(CAST(NEWID() AS VARBINARY) AS INT))%100+1
	SET @Points = 65+ABS(CAST(CAST(NEWID() AS VARBINARY) AS INT))%35+1

	INSERT INTO dbo.hackerranklog (posttime, exercise, [level], [type], username, points, duration, result)
	SELECT @PostTime, @Exercise_Number, 
	CASE WHEN @Exercise_Number<34 THEN 'Basic'
		 WHEN @Exercise_Number>33 and @Exercise_Number<64 THEN 'Medium'
		 WHEN @Exercise_Number>63 THEN 'Advance'
	END,
	CASE WHEN @Exercise_Number%2=0 THEN 'Divide and Conquer'
		 WHEN @Exercise_Number%3=0 THEN 'Hashing'
		 WHEN @Exercise_Number%5=0 THEN 'Sorting'
		 ELSE 'Decision tree'
	END, 
	CONCAT('User_', CONVERT(VARCHAR,ABS(CAST(CAST(NEWID() AS VARBINARY) AS INT))%1315) ,'_'),
	@Points,
	20+ABS(CAST(CAST(NEWID() AS VARBINARY) AS INT))%40,
	CASE WHEN @Points<85 THEN 'Failed' ELSE 'Approved' END

	SET @AMOUNT_OF_RECORDS = @AMOUNT_OF_RECORDS - 1
END
GO

```

El anterior es la bitácora resultado de una plataforma de entrenamiento y evaluación de ejercicios algoritmos. La tabla contiene el número de ejercicio, el nivel de complejidad el ejercicio, el tipo de estrategia de solución esperado, el usuario que hizo el test, los puntos obtenidos y la cantidad de minutos usados en la resolución del ejercicio. 

De los datos extraídos se quiere averiguar lo siguiente:

1. 