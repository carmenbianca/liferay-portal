/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.uad.exporter;

import com.liferay.user.associated.data.exporter.UADExporter;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = UADExporter.class)
public class UADPartialEntryUADExporter extends BaseUADPartialEntryUADExporter {
}