/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.xml.descriptor;

import com.liferay.util.xml.ElementIdentifier;

import org.dom4j.Document;
import org.dom4j.Element;

/**
 * @author Jorge Ferrer
 */
public class PortletAppDescriptor extends SimpleXMLDescriptor {

	@Override
	public boolean canHandleType(String doctype, Document root) {
		Element element = root.getRootElement();

		String name = element.getName();

		return name.equals("portlet-app");
	}

	@Override
	public ElementIdentifier[] getElementsIdentifiedByChild() {
		return _ELEMENTS_IDENTIFIED_BY_CHILD;
	}

	private static final ElementIdentifier[] _ELEMENTS_IDENTIFIED_BY_CHILD = {
		new ElementIdentifier("portlet", "portlet-name")
	};

}