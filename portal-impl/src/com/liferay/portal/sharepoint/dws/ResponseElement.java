/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.sharepoint.dws;

import com.liferay.portal.kernel.xml.Element;

/**
 * @author Bruno Farache
 */
public interface ResponseElement {

	public void addElement(Element doc);

}