Create table vinho(
 codigo BIGINT primary key identity(1,1),
 nome varchar(50) not null,
 tipo varchar(50) not null,
 sofra int not null,
 valume int not null,
 valor decimal(10,2) not null
)