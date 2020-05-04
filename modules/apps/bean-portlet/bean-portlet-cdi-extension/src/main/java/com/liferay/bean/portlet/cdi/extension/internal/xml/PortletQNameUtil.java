/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal.xml;

import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.QName;

import javax.portlet.annotations.PortletQName;

/**
 * @author Shuyang Zhou
 */
public class PortletQNameUtil {

	public static javax.xml.namespace.QName getQName(
		Element qNameEl, Element nameEl, String defaultNamespace) {

		QName qName =
			com.liferay.portal.kernel.portlet.PortletQNameUtil.getQName(
				qNameEl, nameEl, defaultNamespace);

		return new javax.xml.namespace.QName(
			qName.getNamespaceURI(), qName.getLocalPart(),
			qName.getNamespacePrefix());
	}

	public static javax.xml.namespace.QName toQName(PortletQName portletQName) {
		return new javax.xml.namespace.QName(
			portletQName.namespaceURI(), portletQName.localPart());
	}

}