/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.internal.dynamic.data.mapping.util;

import com.liferay.dynamic.data.mapping.util.DDMIndexer;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = {})
public class DDMIndexerUtil {

	public static String encodeName(
		long ddmStructureId, String name, Locale locale) {

		return _ddmIndexer.encodeName(ddmStructureId, name, locale);
	}

	@Reference(unbind = "-")
	protected void se(DDMIndexer ddmIndexer) {
		_ddmIndexer = ddmIndexer;
	}

	private static DDMIndexer _ddmIndexer;

}