/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission.comparator;

import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;

import java.io.Serializable;

import java.util.Comparator;

/**
 * @author Jorge Ferrer
 */
public class ModelResourceWeightComparator
	implements Comparator<String>, Serializable {

	@Override
	public int compare(String resource1, String resource2) {
		double weight1 = ResourceActionsUtil.getModelResourceWeight(resource1);
		double weight2 = ResourceActionsUtil.getModelResourceWeight(resource2);

		return Double.compare(weight1, weight2);
	}

}