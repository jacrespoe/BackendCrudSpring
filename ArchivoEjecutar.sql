CREATE TABLE IF NOT EXISTS public.productos
(
    id integer NOT NULL,
    name character varying ,
    description character ,
    price numeric(15,2),
    image character varying 
)

insert into productos values(1,'Martillo','Peso 12 oz Garantía 3 meses Ancho18.3 cm Material de la cabeza Acero Espesor 2.7 cm Tipo de martillo Uña',3600.45,'http://placeimg.com/640/480/tech'),
(2,'Set destornilladores 4 piezas CC226','Peso 12 oz Garantía 3 meses Ancho18.3 cm Material de la cabeza Acero Espesor 2.7 cm Tipo de martillo Uña',9900.45,'https://homecenterco.scene7.com/is/image/SodimacCO/62307?fmt=jpg'),
(3,'Martillo Hierro','Peso 12 oz Garantía 3 meses Ancho18.3 cm Material de la cabeza Acero Espesor 2.7 cm Tipo de martillo Uña',3600.45,'http://placeimg.com/640/480/tech')


