/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xml.xpath;

import org.jaxen.XPathFunctionContext;

/**
 * @author Raymond Augé
 */
public class LiferayFunctionContext extends XPathFunctionContext {

	public LiferayFunctionContext() {
		super(true);

		registerFunction(null, "matches", new MatchesFunction());
	}

}