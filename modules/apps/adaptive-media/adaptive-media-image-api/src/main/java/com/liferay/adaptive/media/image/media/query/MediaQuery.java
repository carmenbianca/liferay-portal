/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.media.query;

import java.util.List;

/**
 * @author Alejandro Tardín
 */
public class MediaQuery {

	public MediaQuery(List<Condition> conditions, String src) {
		_conditions = conditions;
		_src = src;
	}

	public List<Condition> getConditions() {
		return _conditions;
	}

	public String getSrc() {
		return _src;
	}

	private final List<Condition> _conditions;
	private final String _src;

}