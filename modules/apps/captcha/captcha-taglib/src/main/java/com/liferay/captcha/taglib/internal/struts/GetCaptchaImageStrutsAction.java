/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.captcha.taglib.internal.struts;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.struts.StrutsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true, property = "path=/portal/captcha/get_image",
	service = StrutsAction.class
)
public class GetCaptchaImageStrutsAction implements StrutsAction {

	@Override
	public String execute(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		CaptchaUtil.serveImage(httpServletRequest, httpServletResponse);

		return null;
	}

}