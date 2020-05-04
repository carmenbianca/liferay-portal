/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.activity.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Roberto Díaz
 */
@ExtendedObjectClassDefinition(
	category = "user-activity",
	scope = ExtendedObjectClassDefinition.Scope.GROUP
)
@Meta.OCD(
	id = "com.liferay.social.activity.configuration.SocialActivityGroupServiceConfiguration",
	localization = "content/Language",
	name = "social-activity-group-service-configuration-name"
)
public interface SocialActivityGroupServiceConfiguration {

	@Meta.AD(
		deflt = "-100|-20|-10|-5|-4|-3|-2|-1|0|1|2|3|4|5|10|20|50|100",
		name = "contribution-increments", required = false
	)
	public String[] contributionIncrements();

	@Meta.AD(
		deflt = "0|1|2|3|4|5|10|20", name = "contribution-limit-values",
		required = false
	)
	public String[] contributionLimitValues();

	@Meta.AD(
		deflt = "-100|-20|-10|-5|-4|-3|-2|-1|0|1|2|3|4|5|10|20|50|100",
		name = "participation-increments", required = false
	)
	public String[] participationIncrements();

	@Meta.AD(
		deflt = "0|1|2|3|4|5|10|20", name = "participation-limit-values",
		required = false
	)
	public String[] participationLimitValues();

}