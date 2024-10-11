/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;FOO_CSPViolation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CSPViolation
 * @generated
 */
public class CSPViolationTable extends BaseTable<CSPViolationTable> {

	public static final CSPViolationTable INSTANCE = new CSPViolationTable();

	public final Column<CSPViolationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, Long> cspViolationId = createColumn(
		"cspViolationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CSPViolationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, Long> plid = createColumn(
		"plid", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, String> violationType = createColumn(
		"violationType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, String> violation = createColumn(
		"violation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, String> violationHash = createColumn(
		"violationHash", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CSPViolationTable, Boolean> whiteListed = createColumn(
		"whiteListed", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private CSPViolationTable() {
		super("FOO_CSPViolation", CSPViolationTable::new);
	}

}