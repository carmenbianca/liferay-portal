/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query;

import com.liferay.portal.search.query.QueryVisitor;
import com.liferay.portal.search.query.ScriptQuery;
import com.liferay.portal.search.script.Script;

/**
 * @author Michael C. Han
 */
public class ScriptQueryImpl extends BaseQueryImpl implements ScriptQuery {

	public ScriptQueryImpl(Script script) {
		_script = script;
	}

	@Override
	public <T> T accept(QueryVisitor<T> queryVisitor) {
		return queryVisitor.visit(this);
	}

	public Script getScript() {
		return _script;
	}

	private static final long serialVersionUID = 1L;

	private final Script _script;

}