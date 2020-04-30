/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.model.impl;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author Ryan Park
 * @author Joan Kim
 */
public class ModuleImpl extends ModuleBaseImpl {

	@Override
	public boolean isBundle() {
		if (Validator.isNull(getBundleSymbolicName()) &&
			Validator.isNull(getBundleVersion())) {

			return false;
		}

		return true;
	}

}