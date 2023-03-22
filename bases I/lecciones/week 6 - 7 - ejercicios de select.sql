use viveroshop;

-- rodrigo nunez

-- 2.1 seleccione la receta es decir los ingredientes y su cantidad para un producto específico
-- output: nombre del producto, nombre del ingrediente, cantidad necesaria

SELECT * FROM Plantas;
Select plantas.name, operationtype, log.quantity from inventorylog log
inner join plantas on plantas.plantid = log.plantid
WHERE plantas.name = 'Geranio';

select prod.name, ingre.name, ingre.cantidad from productos prod 
inner join ingrexprod on ingrexprod.productid = prod.productid
inner join ingredientes ingre on ingre.ingredienteid = ingrexprod.ingredienteid
where prod.name = 'Copo 3 leches';

-- 2.2 muestre todos los productos con su precio actual ordenados de precio mayor a precio menor. 
-- Tome en cuenta que el producto podría tener o no precio especial por playa.
-- output: nombre del producto, precio, un flag, beachname que diga si este es precio especial de playa

products(id, name);
productsprices(productid, startdate, enabled, price);
beachprices(productid, beachid, price, startdate, enabled);
beaches(beachid, name)

SELECT prod.name productname,  
coalese(bp.price, pprice.price) price,
case bp.price WHEN NULL THEN 'No' ELSE 'Si' END CASE flagEspecial,
IFNULL(beaches.name, 'No asociado a playa') beachname
FROM products prod 
inner join productprices pprices ON prod.productid = pprices.productid
left join beachprices bp on bp.productid = prod.productid
left join beaches on beaches.beachid = bp.beachid
where pprices.enabled = 1

declare porcentajedeaceptacion decimal(4,2) DEFAULT 0.10

-- 1 hacer los inserts de las ventas por turno, por copero, por carrito, por dia
-- podria estarte generando negativos 
-- sumo todo lo que se gasto, 10% a 30%, me da 18, suma*1.18=k
-- inserto el opening o un refill con ese monto para esos ingredientes

-- o

-- calculas previamente cuanto vas a vender en el día 
-- con esto haces el opening y el refill

-- o
-- haces un gran opnening un refill
-- cuando generas los productos lo haces con los max min que tengan esos ingredientes

-- calculo cuanto hielo ocupo, hielo --> k productos--> k ingredientes * 1.30 
-- 10 entre K

-- generar unas 10 plantillas, y cada dia se basa en las plantillas


2.3 averigue que ingredientes son usados en únicamente un solo producto
output: nombre del producto, nombre del ingrediente

-- que operationType ha sido aplicado unicamente a una planta
-- en sql tenemos operadores de conjunto IN, NOT IN, INTERSECT, EXCEPT, UNION, EXISTS
-- hay que tomar en cuenta que si los campos que están involucrados en la operación no tienen índice
-- la comparación es secuencial, creando un n^2
-- para optimizar el uso de conjuntos se recomienda o bien hay campos indexados, o se le aplica el mismo
-- sort a ambos
select plantid, operationtype from inventorylog log where log.operationtype 
NOT IN (select operationtype from inventorylog where plantid!=log.plantid);


1   3 
1   4 <--- 
3   0 
2   2
2   3

1   1  
1   3 
1   4 <--- 
3   0
3   5 
2   2
2   3


2.4 liste cuanto se ha vendido en una playa específica durante una fecha inicial y una fecha final
output: nombre de la playa, monto vendido, fecha inicial, fechafinal

set @startime = CONVERT("2022-09-15 15:04:32", DATETIME);
set @endtime = CONVERT("2022-11-15 20:54:50", DATETIME);

select plantas.name, SUM(log.quantity), @startime, @endtime  FROM inventorylog log 
INNER JOIN plantas ON plantas.plantid = log.plantid 
WHERE log.posttime BETWEEN @startime and @endtime
group by plantas.name;

-- select playas.name, sum(monto) from playas
inner join ventas 
where ventas between fechas
group by playa

select * from inventorylog WHERE posttime>=@startime and posttime <= @endtime;


2.5 
select carrito.nombre, playas.nombre, sum(ventas.monto) playatotal, sum(ventas.quantity) from carritos carrito 
inner join playas 
inner join ventas
where ventas.posttime between fechainicial and fechafinal
group by carrito.nombre, playas,nombre
order by playatotal, playas.nombre

2.6 
select productos.nombre, sum(cantidad) from productos 
inner join ventas
where ventas.postime between starttime and endtime
group by productos.nombre
having count()>=5

