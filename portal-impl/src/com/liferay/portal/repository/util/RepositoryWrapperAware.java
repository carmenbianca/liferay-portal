/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.repository.util;

import com.liferay.portal.kernel.repository.LocalRepository;
import com.liferay.portal.kernel.repository.Repository;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryWrapperAware {

	public LocalRepository wrapLocalRepository(LocalRepository localRepository);

	public Repository wrapRepository(Repository repository);

}