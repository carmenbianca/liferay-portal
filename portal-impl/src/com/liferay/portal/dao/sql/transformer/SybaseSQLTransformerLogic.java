/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.sql.transformer;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.function.Function;
import java.util.regex.Matcher;

/**
 * @author Manuel de la Peña
 */
public class SybaseSQLTransformerLogic extends BaseSQLTransformerLogic {

	public SybaseSQLTransformerLogic(DB db) {
		super(db);

		Function[] functions = {
			getBitwiseCheckFunction(), getBooleanFunction(),
			getCastClobTextFunction(), getCastLongFunction(),
			getCastTextFunction(), getConcatFunction(),
			getDropTableIfExistsTextFunction(), getInstrFunction(),
			getIntegerDivisionFunction(), getLengthFunction(), getModFunction(),
			getNullDateFunction(), getSubstrFunction(), _getCrossJoinFunction(),
			_getReplaceFunction()
		};

		if (!db.isSupportsStringCaseSensitiveQuery()) {
			functions = ArrayUtil.append(functions, getLowerFunction());
		}

		setFunctions(functions);
	}

	@Override
	protected String replaceCastLong(Matcher matcher) {
		return matcher.replaceAll("CONVERT(BIGINT, $1)");
	}

	@Override
	protected String replaceCastText(Matcher matcher) {
		return matcher.replaceAll("CAST($1 AS NVARCHAR(5461))");
	}

	@Override
	protected String replaceDropTableIfExistsText(Matcher matcher) {
		StringBundler sb = new StringBundler(5);

		sb.append("IF EXISTS(select 1 from sysobjects where name = '$1' and ");
		sb.append("type = 'U')\n");
		sb.append("BEGIN\n");
		sb.append("DROP TABLE $1\n");
		sb.append("END");

		return matcher.replaceAll(sb.toString());
	}

	private Function<String, String> _getCrossJoinFunction() {
		return (String sql) -> StringUtil.replace(
			sql, "CROSS JOIN", StringPool.COMMA);
	}

	private Function<String, String> _getReplaceFunction() {
		return (String sql) -> sql.replaceAll("(?i)replace\\(", "str_replace(");
	}

}