/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.monitoring;

import java.util.Set;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public interface MonitoringControl {

	public Level getLevel(String namespace);

	public Set<String> getNamespaces();

	public void setLevel(String namespace, Level level);

}