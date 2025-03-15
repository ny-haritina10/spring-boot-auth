CREATE TABLE public.admins (
	id bigserial NOT NULL,
	email varchar(255) NOT NULL,
	password_hash varchar(255) NOT NULL,
	CONSTRAINT admins_email_key UNIQUE (email),
	CONSTRAINT admins_pkey PRIMARY KEY (id)
);

CREATE TABLE public.clients (
	id serial4 NOT NULL,
	"name" varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	password_hash varchar(255) NOT NULL,
	passport_image varchar(255) NULL,
	CONSTRAINT clients_email_key UNIQUE (email),
	CONSTRAINT clients_pkey PRIMARY KEY (id)
);