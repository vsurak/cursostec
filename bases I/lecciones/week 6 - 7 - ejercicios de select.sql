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

