create table admin(
    username varchar2(20),
    nome_admin varchar2(30) not null,
    cognome_admin varchar2(30) not null,
    password varchar2(500) not null,
    constraint p_id_admin primary key (username)
);
create table corsista(
    id_corsista int,
    nome_corsista varchar2(30) not null,
    cognome_corsista varchar2(30) not null,
    precedenti_formativi number(1) default 0,
    constraint p_id_corsista primary key (id_corsista)
);
create table docente(
    id_docente int,
    nome_docente varchar2(30) not null,
    cognome_docente varchar2(30) not null,
    cv varchar2(500) not null,
    constraint p_id_docente primary key (id_docente)
);
create table corso(
    id_corso int,
    id_docente int,
    nome_corso varchar2(30) not null,
    data_inizio date not null,
    data_fine date not null,
    costo number(8,2) not null,
    commenti varchar2(500),
    aula char(4) not null,
    constraint p_id_corso primary key (id_corso),
    constraint f_id_docente foreign key (id_docente) references docente(id_docente) on delete CASCADE
);
create table corso_corsista (
    id_corso int,
    id_corsista int,
    constraint f_id_corso foreign key (id_corso) references corso(id_corso) on delete CASCADE,
    constraint f_id_corsista foreign key (id_corsista) references corsista(id_corsista) on delete CASCADE,
    constraint p_corso_corsista primary key (id_corso,id_corsista)
);

