CREATE TABLE "PS_NAMES"
   (
	"EMPLID" VARCHAR(11) NOT NULL,
	"NAME_TYPE" VARCHAR(3) NOT NULL,
	"EFFDT" DATE NOT NULL,
	"EFF_STATUS" VARCHAR(1) NOT NULL,
	"COUNTRY_NM_FORMAT" VARCHAR(3) NOT NULL,
	"NAME" VARCHAR(50) NOT NULL,
	"NAME_INITIALS" VARCHAR(6) NOT NULL,
	"NAME_PREFIX" VARCHAR(4) NOT NULL,
	"NAME_SUFFIX" VARCHAR(15) NOT NULL,
	"NAME_ROYAL_PREFIX" VARCHAR(15) NOT NULL,
	"NAME_ROYAL_SUFFIX" VARCHAR(15) NOT NULL,
	"NAME_TITLE" VARCHAR(30) NOT NULL,
	"LAST_NAME_SRCH" VARCHAR(30) NOT NULL,
	"FIRST_NAME_SRCH" VARCHAR(30) NOT NULL,
	"LAST_NAME" VARCHAR(30) NOT NULL,
	"FIRST_NAME" VARCHAR(30) NOT NULL,
	"MIDDLE_NAME" VARCHAR(30) NOT NULL,
	"SECOND_LAST_NAME" VARCHAR(30) NOT NULL,
	"SECOND_LAST_SRCH" VARCHAR(30) NOT NULL,
	"NAME_AC" VARCHAR(50) NOT NULL,
	"PREF_FIRST_NAME" VARCHAR(30) NOT NULL,
	"PARTNER_LAST_NAME" VARCHAR(30) NOT NULL,
	"PARTNER_ROY_PREFIX" VARCHAR(15) NOT NULL,
	"LAST_NAME_PREF_NLD" VARCHAR(1) NOT NULL,
	"NAME_DISPLAY" VARCHAR(50) NOT NULL,
	"NAME_FORMAL" VARCHAR(60) NOT NULL,
	"NAME_DISPLAY_SRCH" VARCHAR(50) NOT NULL,
	"LASTUPDDTTM" DATE,
	"LASTUPDOPRID" VARCHAR(30) NOT NULL
   );


  CREATE INDEX "PS0NAMES" ON "PS_NAMES" ("NAME", "EMPLID", "NAME_TYPE", "EFFDT" DESC);

  CREATE INDEX "PS1NAMES" ON "PS_NAMES" ("LAST_NAME_SRCH", "EMPLID", "NAME_TYPE", "EFFDT" DESC);

  CREATE INDEX "PS2NAMES" ON "PS_NAMES" ("FIRST_NAME_SRCH", "EMPLID", "NAME_TYPE", "EFFDT" DESC);

  CREATE INDEX "PS3NAMES" ON "PS_NAMES" ("SECOND_LAST_SRCH", "EMPLID", "NAME_TYPE", "EFFDT" DESC);

  CREATE INDEX "PS4NAMES" ON "PS_NAMES" ("NAME_AC", "EMPLID", "NAME_TYPE", "EFFDT" DESC) ;

  CREATE INDEX "PS5NAMES" ON "PS_NAMES" ("NAME_DISPLAY_SRCH", "EMPLID", "NAME_TYPE", "EFFDT" DESC);

  CREATE INDEX "PSANAMES" ON "PS_NAMES" ("LAST_NAME_SRCH", "NAME_TYPE", "EFFDT", "EMPLID");

  CREATE INDEX "PSBNAMES" ON "PS_NAMES" ("NAME_DISPLAY_SRCH", "NAME_TYPE", "EFFDT", "EMPLID");

  CREATE UNIQUE INDEX "PS_NAMES" ON "PS_NAMES" ("EMPLID", "NAME_TYPE", "EFFDT" DESC);
