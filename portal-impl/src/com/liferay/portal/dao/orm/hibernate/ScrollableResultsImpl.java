/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.ScrollableResults;

/**
 * @author Brian Wing Shun Chan
 */
public class ScrollableResultsImpl implements ScrollableResults {

	public ScrollableResultsImpl(
		org.hibernate.ScrollableResults scrollableResults) {

		_scrollableResults = scrollableResults;
	}

	@Override
	public boolean first() throws ORMException {
		try {
			return _scrollableResults.first();
		}
		catch (Exception exception) {
			throw ExceptionTranslator.translate(exception);
		}
	}

	@Override
	public Object[] get() throws ORMException {
		try {
			return _scrollableResults.get();
		}
		catch (Exception exception) {
			throw ExceptionTranslator.translate(exception);
		}
	}

	@Override
	public Object get(int i) throws ORMException {
		try {
			return _scrollableResults.get(i);
		}
		catch (Exception exception) {
			throw ExceptionTranslator.translate(exception);
		}
	}

	@Override
	public boolean last() throws ORMException {
		try {
			return _scrollableResults.last();
		}
		catch (Exception exception) {
			throw ExceptionTranslator.translate(exception);
		}
	}

	@Override
	public boolean next() throws ORMException {
		try {
			return _scrollableResults.next();
		}
		catch (Exception exception) {
			throw ExceptionTranslator.translate(exception);
		}
	}

	@Override
	public boolean previous() throws ORMException {
		try {
			return _scrollableResults.previous();
		}
		catch (Exception exception) {
			throw ExceptionTranslator.translate(exception);
		}
	}

	@Override
	public boolean scroll(int i) throws ORMException {
		try {
			return _scrollableResults.scroll(i);
		}
		catch (Exception exception) {
			throw ExceptionTranslator.translate(exception);
		}
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{_scrollableResults=");
		sb.append(String.valueOf(_scrollableResults));
		sb.append("}");

		return sb.toString();
	}

	private final org.hibernate.ScrollableResults _scrollableResults;

}