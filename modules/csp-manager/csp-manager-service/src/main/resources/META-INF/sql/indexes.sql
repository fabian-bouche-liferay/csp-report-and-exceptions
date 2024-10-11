create index IX_86D22234 on FOO_CSPViolation (plid, violationHash[$COLUMN_LENGTH:75$]);
create index IX_203208A7 on FOO_CSPViolation (plid, whiteListed);
create unique index IX_A04C4FDA on FOO_CSPViolation (uuid_[$COLUMN_LENGTH:75$], groupId);