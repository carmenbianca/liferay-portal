/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.display.request.attributes.contributor;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public interface InfoDisplayRequestAttributesContributor {

	public void addAttributes(HttpServletRequest httpServletRequest);

}