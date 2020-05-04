/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.contributor;

import java.util.Map;

/**
 * @author Rodolfo Roza Miranda
 */
public interface ClayTagContextContributor {

	public void populate(Map<String, Object> context);

}