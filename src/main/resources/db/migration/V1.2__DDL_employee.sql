CREATE TABLE testcontainer.employee (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	name varchar NOT NULL,
	address varchar NOT NULL,
	CONSTRAINT employee_pk PRIMARY KEY (id)
);