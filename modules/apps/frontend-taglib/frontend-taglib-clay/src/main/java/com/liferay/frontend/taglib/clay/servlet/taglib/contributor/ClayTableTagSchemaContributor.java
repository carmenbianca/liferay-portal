/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.contributor;

import com.liferay.frontend.taglib.clay.servlet.taglib.model.table.Schema;

/**
 * @author Iván Zaera Avellón
 */
public interface ClayTableTagSchemaContributor {

	public void populate(Schema schema);

}