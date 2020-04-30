/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.util;

import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author     Brian Wing Shun Chan
 * @deprecated As of Mueller (7.2.x)
 */
@Deprecated
public class BodyTopTag extends OutputTag {

	public BodyTopTag() {
		super(WebKeys.PAGE_BODY_TOP);
	}

}