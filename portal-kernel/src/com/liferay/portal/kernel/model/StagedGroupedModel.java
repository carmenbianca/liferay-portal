/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import java.util.Date;

/**
 * @author Michael C. Han
 */
public interface StagedGroupedModel extends GroupedModel, StagedModel {

	public Date getLastPublishDate();

	public void setLastPublishDate(Date date);

}