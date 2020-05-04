/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.values.query.internal;

import com.liferay.dynamic.data.mapping.form.values.query.DDMFormValuesQuery;
import com.liferay.dynamic.data.mapping.form.values.query.DDMFormValuesQueryFactory;
import com.liferay.dynamic.data.mapping.form.values.query.DDMFormValuesQuerySyntaxException;
import com.liferay.dynamic.data.mapping.form.values.query.internal.parser.DDMFormValuesQueryLexer;
import com.liferay.dynamic.data.mapping.form.values.query.internal.parser.DDMFormValuesQueryParser;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marcellus Tavares
 */
@Component(immediate = true, service = DDMFormValuesQueryFactory.class)
public class DDMFormValuesQueryFactoryImpl
	implements DDMFormValuesQueryFactory {

	@Override
	public DDMFormValuesQuery create(DDMFormValues ddmFormValues, String query)
		throws DDMFormValuesQuerySyntaxException {

		try {
			DDMFormValuesQueryParser.PathContext pathContext =
				createPathContext(query);

			DDMFormValuesQueryListener ddmFormValuesQueryListener =
				new DDMFormValuesQueryListener();

			ParseTreeWalker parseTreeWalker = new ParseTreeWalker();

			parseTreeWalker.walk(ddmFormValuesQueryListener, pathContext);

			return new DDMFormValuesQueryImpl(
				ddmFormValues,
				ddmFormValuesQueryListener.getDDMFormValuesFilters());
		}
		catch (Exception exception) {
			throw new DDMFormValuesQuerySyntaxException(exception);
		}
	}

	protected DDMFormValuesQueryParser.PathContext createPathContext(
		String query) {

		CharStream charStream = new ANTLRInputStream(query);

		DDMFormValuesQueryLexer ddmFormValuesQueryLexer =
			new DDMFormValuesQueryLexer(charStream);

		DDMFormValuesQueryParser ddmFormValuesQueryParser =
			new DDMFormValuesQueryParser(
				new CommonTokenStream(ddmFormValuesQueryLexer));

		ddmFormValuesQueryParser.setErrorHandler(new BailErrorStrategy());

		return ddmFormValuesQueryParser.path();
	}

}