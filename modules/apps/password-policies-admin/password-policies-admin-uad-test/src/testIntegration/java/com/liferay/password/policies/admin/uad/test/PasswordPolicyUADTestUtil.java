/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.password.policies.admin.uad.test;

import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portlet.passwordpoliciesadmin.util.test.PasswordPolicyTestUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class PasswordPolicyUADTestUtil {

	public static PasswordPolicy addPasswordPolicy(long userId)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getGroupId(), userId);

		return PasswordPolicyTestUtil.addPasswordPolicy(serviceContext);
	}

}