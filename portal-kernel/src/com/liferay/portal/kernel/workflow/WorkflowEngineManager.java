/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import com.liferay.portal.kernel.messaging.proxy.MessagingProxy;
import com.liferay.portal.kernel.messaging.proxy.ProxyMode;

import java.util.Map;

/**
 * @author Micha Kiener
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
@MessagingProxy(mode = ProxyMode.SYNC)
public interface WorkflowEngineManager {

	public String getKey();

	public String getName();

	public Map<String, Object> getOptionalAttributes();

	public String getVersion();

	public boolean isDeployed();

}