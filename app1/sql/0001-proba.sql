CREATE TABLE table1
(
  id numeric NOT NULL,
  name text,
  CONSTRAINT table1_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE table1
  OWNER TO postgres;