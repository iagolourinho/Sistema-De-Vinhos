Create table vinho(
 codigo BIGINT primary key identity(1,1),
 nome varchar(50) not null,
 tipo varchar(50) not null,
 safra int not null,
 volume int not null,
 valor decimal(10,2) not null
);