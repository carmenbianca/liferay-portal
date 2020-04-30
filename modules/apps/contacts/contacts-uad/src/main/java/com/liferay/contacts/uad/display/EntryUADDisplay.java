/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.uad.display;

import com.liferay.user.associated.data.display.UADDisplay;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = UADDisplay.class)
public class EntryUADDisplay extends BaseEntryUADDisplay {

	@Override
	public boolean isSiteScoped() {
		return false;
	}

}