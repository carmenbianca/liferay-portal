/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.testhook.hook.events;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.testhook.util.TestHookUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class StartupAction extends SimpleAction {

	@Override
	public void run(String[] ids) throws ActionException {
		try {
			FileUtil.write(
				TestHookUtil.getStartupActionFile(), StringPool.BLANK);
		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

}