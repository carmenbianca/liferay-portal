/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.model;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author Adolfo Pérez
 */
public interface ClassType {

	public ClassTypeField getClassTypeField(String fieldName)
		throws PortalException;

	public List<ClassTypeField> getClassTypeFields() throws PortalException;

	public List<ClassTypeField> getClassTypeFields(int start, int end)
		throws PortalException;

	public int getClassTypeFieldsCount() throws PortalException;

	public long getClassTypeId();

	public String getName();

}