connect 'jdbc:derby://localhost:1530/laboratorio2;user=root;password=root;create=true;';
create table pago(
    id int PRIMARY KEY  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
    nombre varchar(128) not null, 
    email varchar(128) not null, 
    tipoTarjeta varchar(32) not null, 
    fechaVencimiento varchar(32) not null, 
    transaccion varchar(256) not null, 
    numeroTarjeta bigint not null, 
    valorTransaccion bigint not null, 
    codigoSeguridad varchar(3) not null
);