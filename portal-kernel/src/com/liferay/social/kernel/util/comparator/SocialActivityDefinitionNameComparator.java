/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.util.comparator;

import com.liferay.portal.kernel.util.CollatorUtil;
import com.liferay.social.kernel.model.SocialActivityDefinition;

import java.text.Collator;

import java.util.Comparator;
import java.util.Locale;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialActivityDefinitionNameComparator
	implements Comparator<SocialActivityDefinition> {

	public SocialActivityDefinitionNameComparator(Locale locale) {
		_locale = locale;

		_collator = CollatorUtil.getInstance(_locale);
	}

	@Override
	public int compare(
		SocialActivityDefinition activityDefinition1,
		SocialActivityDefinition activityDefinition2) {

		String name1 = activityDefinition1.getName(_locale);
		String name2 = activityDefinition2.getName(_locale);

		return _collator.compare(name1, name2);
	}

	private final Collator _collator;
	private final Locale _locale;

}