create table tb_entrega(
    id bigint not null auto_increment,
    cliente_id bigint not null,
    taxa DECIMAL (10,2) not null,
    status varchar(15) not null,
    data_pedido datetime not null,
    data_finalizacao DATETIME,

    destinatario_nome varchar (60) not null,
    destinatario_logradouro varchar (255) not null,
    destinatario_numero varchar (10) not null,
    destinatario_complemento varchar (60) not null,
    destinatario_bairro varchar (30) not null,

	PRIMARY KEY (id),
    FOREIGN KEY (cliente_id) references tb_cliente (id)
);