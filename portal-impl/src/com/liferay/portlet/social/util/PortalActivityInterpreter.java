/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.social.util;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.language.LanguageResources;
import com.liferay.social.kernel.model.BaseSocialActivityInterpreter;
import com.liferay.social.kernel.model.SocialActivity;
import com.liferay.social.kernel.model.SocialActivityFeedEntry;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalActivityInterpreter extends BaseSocialActivityInterpreter {

	@Override
	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected SocialActivityFeedEntry doInterpret(
			SocialActivity activity, ServiceContext serviceContext)
		throws Exception {

		return null;
	}

	@Override
	protected ResourceBundleLoader getResourceBundleLoader() {
		return LanguageResources.RESOURCE_BUNDLE_LOADER;
	}

	private static final String[] _CLASS_NAMES = {
		PortalActivityInterpreter.class.getName()
	};

}