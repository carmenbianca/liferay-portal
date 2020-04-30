/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

import com.liferay.exportimport.kernel.lar.StagedModelType;

/**
 * @author Brian Wing Shun Chan
 */
public class ExportActionableDynamicQuery
	extends DefaultActionableDynamicQuery {

	public StagedModelType getStagedModelType() {
		return _stagedModelType;
	}

	public void setStagedModelType(StagedModelType stagedModelType) {
		_stagedModelType = stagedModelType;
	}

	private StagedModelType _stagedModelType;

}