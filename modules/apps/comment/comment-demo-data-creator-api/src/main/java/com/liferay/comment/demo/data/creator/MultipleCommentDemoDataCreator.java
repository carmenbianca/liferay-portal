/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.comment.demo.data.creator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ClassedModel;

/**
 * @author Alejandro Hernández
 */
public interface MultipleCommentDemoDataCreator {

	public void create(ClassedModel classedModel) throws PortalException;

	public void delete() throws PortalException;

}