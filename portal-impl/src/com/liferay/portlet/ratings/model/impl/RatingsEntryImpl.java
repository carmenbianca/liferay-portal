/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.ratings.model.impl;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.ratings.kernel.model.RatingsEntry;

/**
 * @author Brian Wing Shun Chan
 */
public class RatingsEntryImpl extends RatingsEntryBaseImpl {

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(RatingsEntry.class);
	}

}