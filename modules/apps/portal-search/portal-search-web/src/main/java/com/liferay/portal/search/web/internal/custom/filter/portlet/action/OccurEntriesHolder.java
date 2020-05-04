/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.custom.filter.portlet.action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André de Oliveira
 */
public class OccurEntriesHolder {

	public OccurEntriesHolder() {
		add("filter", "filter");
		add("must", "must");
		add("must_not", "must_not");
		add("should", "should");
	}

	public List<OccurEntry> getOccurEntries() {
		return _occurEntries;
	}

	protected void add(String occur, String name) {
		_occurEntries.add(
			new OccurEntry() {
				{
					setName(name);
					setOccur(occur);
				}
			});
	}

	private final List<OccurEntry> _occurEntries = new ArrayList<>();

}