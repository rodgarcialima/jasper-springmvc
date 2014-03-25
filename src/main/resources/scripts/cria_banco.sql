-- banco de dados
CREATE DATABASE jasper
  WITH ENCODING='UTF8'
       OWNER=postgres
       LC_COLLATE='Portuguese_Brazil.1252'
       LC_CTYPE='Portuguese_Brazil.1252'
       CONNECTION LIMIT=-1;


-- tabela de cliente
CREATE TABLE public.cliente
(
   id serial NOT NULL,
   nome character varying(100) NOT NULL,
   CONSTRAINT pk_cliente PRIMARY KEY (id)
)
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.cliente
  OWNER TO postgres;
