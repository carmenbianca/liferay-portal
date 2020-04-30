/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.contributor;

import aQute.bnd.annotation.ProviderType;

import com.liferay.fragment.model.FragmentEntry;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Jürgen Kappler
 */
@ProviderType
public interface FragmentCollectionContributor {

	public String getFragmentCollectionKey();

	public List<FragmentEntry> getFragmentEntries();

	public List<FragmentEntry> getFragmentEntries(int type);

	public default List<FragmentEntry> getFragmentEntries(
		int type, Locale locale) {

		return getFragmentEntries(type);
	}

	public default List<FragmentEntry> getFragmentEntries(Locale locale) {
		return getFragmentEntries();
	}

	public String getName();

	public default String getName(Locale locale) {
		return getName();
	}

	public Map<Locale, String> getNames();

	public default ResourceBundleLoader getResourceBundleLoader() {
		return ResourceBundleLoaderUtil.getPortalResourceBundleLoader();
	}

}