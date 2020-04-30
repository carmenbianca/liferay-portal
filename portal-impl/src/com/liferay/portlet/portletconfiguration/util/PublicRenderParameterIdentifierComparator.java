/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.portletconfiguration.util;

import com.liferay.portal.kernel.model.PublicRenderParameter;

import java.util.Comparator;

/**
 * @author Alberto Montero
 */
public class PublicRenderParameterIdentifierComparator
	implements Comparator<PublicRenderParameter> {

	@Override
	public int compare(
		PublicRenderParameter publicRenderParameter1,
		PublicRenderParameter publicRenderParameter2) {

		String identifier1 = publicRenderParameter1.getIdentifier();
		String identifier2 = publicRenderParameter2.getIdentifier();

		return identifier1.compareTo(identifier2);
	}

}