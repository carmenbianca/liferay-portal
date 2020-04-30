/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.model;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Iván Zaera
 */
public class BaseRepositoryModelOperation implements RepositoryModelOperation {

	/**
	 * @throws PortalException
	 */
	@Override
	public void execute(FileEntry fileEntry) throws PortalException {
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public void execute(FileShortcut fileShortcut) throws PortalException {
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public void execute(FileVersion fileVersion) throws PortalException {
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public void execute(Folder folder) throws PortalException {
	}

}