/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.demo.data.creator;

import com.liferay.message.boards.model.MBMessage;
import com.liferay.portal.kernel.exception.PortalException;

import java.io.IOException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Sergio González
 */
@ProviderType
public interface MBMessageDemoDataCreator {

	public MBMessage create(long userId, long categoryId)
		throws IOException, PortalException;

	public MBMessage create(long userId, long categoryId, long parentMessageId)
		throws IOException, PortalException;

	public void delete() throws PortalException;

}