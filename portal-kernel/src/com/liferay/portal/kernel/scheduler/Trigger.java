/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scheduler;

import java.io.Serializable;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Shuyang Zhou
 */
@ProviderType
public interface Trigger extends Serializable {

	public Date getEndDate();

	public Date getFireDateAfter(Date date);

	public String getGroupName();

	public String getJobName();

	public Date getStartDate();

	public Serializable getWrappedTrigger();

}