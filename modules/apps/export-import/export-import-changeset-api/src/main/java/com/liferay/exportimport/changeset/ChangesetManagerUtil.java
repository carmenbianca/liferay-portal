/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.changeset;

/**
 * @author Máté Thurzó
 */
public class ChangesetManagerUtil {

	public static ChangesetManager getChangesetManager() {
		if (_changesetManager != null) {
			return _changesetManager;
		}

		throw new NullPointerException("Changeset manager is null");
	}

	public static void setChangesetManager(ChangesetManager changesetManager) {
		if (_changesetManager != null) {
			changesetManager = _changesetManager;

			return;
		}

		_changesetManager = changesetManager;
	}

	private static ChangesetManager _changesetManager;

}