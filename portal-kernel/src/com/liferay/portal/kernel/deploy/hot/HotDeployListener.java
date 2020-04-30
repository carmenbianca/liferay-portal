/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.deploy.hot;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public interface HotDeployListener {

	public void invokeDeploy(HotDeployEvent event) throws HotDeployException;

	public void invokeUndeploy(HotDeployEvent event) throws HotDeployException;

}