/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import java.util.Date;

/**
 * @author Michael C. Han
 */
public interface StagedModel extends ClassedModel {

	public Object clone();

	public long getCompanyId();

	public Date getCreateDate();

	public Date getModifiedDate();

	public StagedModelType getStagedModelType();

	public String getUuid();

	public void setCompanyId(long companyId);

	public void setCreateDate(Date date);

	public void setModifiedDate(Date date);

	public void setUuid(String uuid);

}