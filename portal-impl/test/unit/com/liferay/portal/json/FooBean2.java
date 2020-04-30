/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json;

import com.liferay.portal.kernel.json.JSON;

/**
 * @author Igor Spasic
 */
@JSON(strict = true)
public class FooBean2 extends FooBean {

	@JSON
	@Override
	public int getValue() {
		return super.getValue();
	}

}