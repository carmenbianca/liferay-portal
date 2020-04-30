/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade;

import com.liferay.portal.kernel.dao.db.DBProcessContext;

/**
 * @author Brian Wing Shun Chan
 */
public class DummyUpgradeStep implements UpgradeStep {

	@Override
	public void upgrade(DBProcessContext dbProcessContext) {
	}

}