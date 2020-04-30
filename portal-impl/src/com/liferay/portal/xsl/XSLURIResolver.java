/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xsl;

import java.io.Serializable;

import javax.xml.transform.URIResolver;

/**
 * @author Tina Tian
 */
public interface XSLURIResolver extends Serializable, URIResolver {

	public String getLanguageId();

}