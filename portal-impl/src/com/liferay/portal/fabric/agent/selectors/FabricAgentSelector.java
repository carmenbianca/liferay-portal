/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.agent.selectors;

import com.liferay.petra.process.ProcessCallable;
import com.liferay.portal.fabric.agent.FabricAgent;

import java.util.Collection;

/**
 * @author Shuyang Zhou
 */
public interface FabricAgentSelector {

	public Collection<FabricAgent> select(
		Collection<FabricAgent> fabricAgents,
		ProcessCallable<?> processCallable);

}