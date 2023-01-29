
CREATE TABLE card (
  id UUID NOT NULL,
   user_id UUID NOT NULL,
   set_id UUID NOT NULL,
   term VARCHAR(120) NOT NULL,
   definition VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   create_date TIMESTAMP WITHOUT TIME ZONE,
   modify_date TIMESTAMP WITHOUT TIME ZONE,
   version INTEGER,
   CONSTRAINT pk_card PRIMARY KEY (id)
);

CREATE TABLE study_set (
  id UUID NOT NULL,
   user_id UUID NOT NULL,
   title VARCHAR(120) NOT NULL,
   subject VARCHAR(120),
   description VARCHAR(255),
   create_date TIMESTAMP WITHOUT TIME ZONE,
   modify_date TIMESTAMP WITHOUT TIME ZONE,
   version INTEGER,
   CONSTRAINT pk_study_set PRIMARY KEY (id)
);

CREATE TABLE user_zfc (
  id UUID NOT NULL,
   password VARCHAR(60) NOT NULL,
   username VARCHAR(20) NOT NULL,
   email VARCHAR(30) NOT NULL,
   enabled BOOLEAN NOT NULL,
   role VARCHAR(255) NOT NULL,
   create_date TIMESTAMP WITHOUT TIME ZONE,
   modify_date TIMESTAMP WITHOUT TIME ZONE,
   version INTEGER,
   CONSTRAINT pk_user_zfc PRIMARY KEY (id)
);

ALTER TABLE user_zfc ADD CONSTRAINT uc_user_zfc_email UNIQUE (email);