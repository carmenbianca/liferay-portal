/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AccountEntry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntry
 * @generated
 */
public class AccountEntryTable extends BaseTable<AccountEntryTable> {

	public static final AccountEntryTable INSTANCE = new AccountEntryTable();

	public final Column<AccountEntryTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<AccountEntryTable, Long> accountEntryId = createColumn(
		"accountEntryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AccountEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, Long> parentAccountEntryId =
		createColumn(
			"parentAccountEntryId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, String> domains = createColumn(
		"domains", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, Long> logoId = createColumn(
		"logoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountEntryTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private AccountEntryTable() {
		super("AccountEntry", AccountEntryTable::new);
	}

}