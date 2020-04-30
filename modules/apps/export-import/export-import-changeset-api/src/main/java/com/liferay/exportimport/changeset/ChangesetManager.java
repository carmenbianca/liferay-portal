/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.changeset;

import java.util.Optional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Máté Thurzó
 */
@ProviderType
public interface ChangesetManager {

	public void addChangeset(Changeset changeset);

	public void clearChangesets();

	public boolean hasChangeset(String changesetUuid);

	public Optional<Changeset> peekChangeset(String changesetUuid);

	public Optional<Changeset> popChangeset(String changesetUuid);

	public long publishChangeset(
		Changeset changeset, ChangesetEnvironment changesetEnvironment);

}