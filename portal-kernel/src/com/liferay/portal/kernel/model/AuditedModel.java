/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public interface AuditedModel extends ClassedModel {

	public long getCompanyId();

	public Date getCreateDate();

	public Date getModifiedDate();

	public long getUserId();

	public String getUserName();

	public String getUserUuid();

	public void setCompanyId(long companyId);

	public void setCreateDate(Date date);

	public void setModifiedDate(Date date);

	public void setUserId(long userId);

	public void setUserName(String userName);

	public void setUserUuid(String userUuid);

}