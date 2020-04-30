/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

import java.util.Set;

/**
 * @author Michael C. Han
 */
public interface ActionAware {

	public Set<Action> getActions();

	public void setActions(Set<Action> actions);

}