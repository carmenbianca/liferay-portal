/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.xml;

import java.util.Comparator;

import org.dom4j.Attribute;

/**
 * @author Brian Wing Shun Chan
 */
public class AttributeComparator implements Comparator<Attribute> {

	@Override
	public int compare(Attribute attr1, Attribute attr2) {
		String attr1Value = attr1.getValue();
		String attr2Value = attr2.getValue();

		return attr1Value.compareTo(attr2Value);
	}

}