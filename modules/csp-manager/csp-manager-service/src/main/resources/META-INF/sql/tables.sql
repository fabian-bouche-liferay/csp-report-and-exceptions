create table FOO_CSPViolation (
	uuid_ VARCHAR(75) null,
	cspViolationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	plid LONG,
	url VARCHAR(75) null,
	violationType VARCHAR(75) null,
	violation VARCHAR(75) null,
	violationHash VARCHAR(75) null,
	whiteListed BOOLEAN
);