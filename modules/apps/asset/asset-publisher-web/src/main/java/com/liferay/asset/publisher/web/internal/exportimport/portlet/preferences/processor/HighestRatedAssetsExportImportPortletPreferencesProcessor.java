/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.exportimport.portlet.preferences.processor;

import com.liferay.asset.publisher.constants.AssetPublisherPortletKeys;
import com.liferay.exportimport.portlet.preferences.processor.ExportImportPortletPreferencesProcessor;

import org.osgi.service.component.annotations.Component;

/**
 * Provides the implementation of
 * <code>ExportImportPortletPreferencesProcessor</code> (in the
 * <code>com.liferay.exportimport.api</code> module) for the Highest Rated
 * Assets portlet. This implementation provides specific export and import
 * capabilities and routines for processing portlet preferences while exporting
 * or importing Highest Rated Assets instances.
 *
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + AssetPublisherPortletKeys.HIGHEST_RATED_ASSETS,
	service = ExportImportPortletPreferencesProcessor.class
)
public class HighestRatedAssetsExportImportPortletPreferencesProcessor
	extends AssetPublisherExportImportPortletPreferencesProcessor {
}