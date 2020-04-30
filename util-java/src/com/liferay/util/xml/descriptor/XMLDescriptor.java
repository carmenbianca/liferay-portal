/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.xml.descriptor;

import org.dom4j.Document;
import org.dom4j.Element;

/**
 * @author Jorge Ferrer
 */
public interface XMLDescriptor {

	public boolean areEqual(Element el1, Element el2);

	public boolean canHandleType(String doctype, Document root);

	public boolean canJoinChildren(Element element);

	public String[] getChildrenOrder(Element parentElement);

	public String[] getRootChildrenOrder();

}