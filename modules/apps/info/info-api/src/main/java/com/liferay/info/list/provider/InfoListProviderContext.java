/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.list.provider;

import com.liferay.info.display.contributor.InfoDisplayObjectProvider;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;

import java.util.Optional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jorge Ferrer
 */
@ProviderType
public interface InfoListProviderContext {

	public Company getCompany();

	public Optional<Group> getGroupOptional();

	public Optional<InfoDisplayObjectProvider>
		getInfoDisplayObjectProviderOptional();

	public Optional<Layout> getLayoutOptional();

	public User getUser();

}