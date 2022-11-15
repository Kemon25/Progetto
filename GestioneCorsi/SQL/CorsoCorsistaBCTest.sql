insert into CORSO values(101,1,'JAVA',TO_DATE('01/01/2020', 'DD/MM/YYYY'),TO_DATE('12/01/2020', 'DD/MM/YYYY'),299,'commento','C1A1');
insert into CORSO values(102,2,'C',TO_DATE('01/02/2020', 'DD/MM/YYYY'),TO_DATE('26/03/2020', 'DD/MM/YYYY'),199,'commento','C1A1');
insert into CORSO values(103,3,'C++',TO_DATE('06/01/2020', 'DD/MM/YYYY'),TO_DATE('15/03/2020', 'DD/MM/YYYY'),359,'commento','C1A1');
insert into CORSO values(104,4,'PYTHON',TO_DATE('01/05/2020', 'DD/MM/YYYY'),TO_DATE('19/06/2020', 'DD/MM/YYYY'),50,'commento','C1A1');

insert into corsista values(101,'Luca','Rossi',1);
insert into corsista values(102,'Angelo','Iossa',1);
insert into corsista values(103,'Veronica','Porretta',1);
insert into corsista values(104,'Elisabetta','Vivolo',1);
insert into corsista values(105,'Loris','Todisco',1);
insert into corsista values(106,'Mirko','Iossa',1);

insert into CORSO_CORSISTA values(101,101);
insert into CORSO_CORSISTA values(101,102);
insert into CORSO_CORSISTA values(101,103);
insert into CORSO_CORSISTA values(102,103);
insert into CORSO_CORSISTA values(102,104);
insert into CORSO_CORSISTA values(103,106);
insert into CORSO_CORSISTA values(104,106);
insert into CORSO_CORSISTA values(104,101);
insert into CORSO_CORSISTA values(104,102);
