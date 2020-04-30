/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.repository.util;

import com.liferay.portal.kernel.repository.BaseRepository;

/**
 * @author Adolfo Pérez
 * @author Mika Koivisto
 */
public interface ExternalRepositoryFactory {

	public BaseRepository getInstance() throws Exception;

}