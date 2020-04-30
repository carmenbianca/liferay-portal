/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.configuration.web.internal.util.comparator;

import com.liferay.portal.kernel.settings.ArchivedSettings;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Eudaldo Alonso
 */
public class ArchivedSettingsNameComparator
	extends OrderByComparator<ArchivedSettings> {

	public ArchivedSettingsNameComparator() {
		this(false);
	}

	public ArchivedSettingsNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		ArchivedSettings archivedSettings1,
		ArchivedSettings archivedSettings2) {

		String name1 = archivedSettings1.getName();
		String name2 = archivedSettings2.getName();

		int value = name1.compareTo(name2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	private final boolean _ascending;

}