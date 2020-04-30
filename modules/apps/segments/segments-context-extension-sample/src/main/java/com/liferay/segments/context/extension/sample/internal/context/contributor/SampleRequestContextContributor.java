/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.context.extension.sample.internal.context.contributor;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.segments.context.Context;
import com.liferay.segments.context.contributor.RequestContextContributor;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eduardo García
 */
@Component(
	immediate = true,
	property = {
		"request.context.contributor.key=" + SampleRequestContextContributor.KEY,
		"request.context.contributor.type=boolean"
	},
	service = RequestContextContributor.class
)
public class SampleRequestContextContributor
	implements RequestContextContributor {

	public static final String KEY = "sample";

	@Override
	public void contribute(
		Context context, HttpServletRequest httpServletRequest) {

		context.put(
			KEY,
			GetterUtil.getBoolean(
				httpServletRequest.getAttribute("sample.attribute")));
	}

}