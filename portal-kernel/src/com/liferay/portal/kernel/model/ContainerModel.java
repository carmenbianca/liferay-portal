/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

/**
 * @author Zsolt Berentey
 */
public interface ContainerModel {

	public long getContainerModelId();

	public String getContainerModelName();

	public Class<?> getModelClass();

	public String getModelClassName();

	public long getParentContainerModelId();

	public void setContainerModelId(long containerModelId);

	public void setParentContainerModelId(long parentContainerModelId);

}