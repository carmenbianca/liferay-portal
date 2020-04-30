/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.persistence;

import java.io.IOException;

import org.apache.felix.cm.PersistenceManager;

/**
 * @author Raymond Augé
 */
public interface ReloadablePersistenceManager extends PersistenceManager {

	public void reload(String pid) throws IOException;

}