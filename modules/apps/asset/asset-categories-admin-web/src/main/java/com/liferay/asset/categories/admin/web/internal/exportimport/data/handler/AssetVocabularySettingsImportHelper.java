/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.categories.admin.web.internal.exportimport.data.handler;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetCategoryConstants;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.ClassType;
import com.liferay.asset.kernel.model.ClassTypeReader;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portlet.asset.util.AssetVocabularySettingsHelper;

import java.util.List;
import java.util.Locale;

/**
 * @author Rafael Praxedes
 */
public class AssetVocabularySettingsImportHelper
	extends AssetVocabularySettingsHelper {

	public AssetVocabularySettingsImportHelper(
		String settings, ClassNameLocalService classNameLocalService,
		long[] groupIds, Locale locale, JSONObject settingsMetadataJSONObject) {

		super(settings);

		_classNameLocalService = classNameLocalService;
		_groupIds = groupIds;
		_locale = locale;
		_settingsMetadataJSONObject = settingsMetadataJSONObject;

		updateSettings();
	}

	public String getSettings() {
		return super.toString();
	}

	public void updateSettings() {
		fillClassNameIdsAndClassTypePKs(
			getClassNameIdsAndClassTypePKs(), false);

		fillClassNameIdsAndClassTypePKs(
			getRequiredClassNameIdsAndClassTypePKs(), true);

		setClassNameIdsAndClassTypePKs(
			_classNameIds, _classTypePKs, _requireds);
	}

	protected boolean existClassName(long classNameId) {
		if (classNameId == AssetCategoryConstants.ALL_CLASS_NAME_ID) {
			return false;
		}

		JSONObject metadataJSONObject = getMetadataJSONObject(classNameId);

		String className = metadataJSONObject.getString("className");

		if (_classNameLocalService.fetchClassName(className) != null) {
			return true;
		}

		if (_log.isWarnEnabled()) {
			_log.warn("No class name found for " + className);
		}

		return false;
	}

	protected void fillClassNameIdsAndClassTypePKs(
		String[] classNameIdsAndClassTypePKs, boolean required) {

		for (String classNameIdAndClassTypePK : classNameIdsAndClassTypePKs) {
			long oldClassNameId = getClassNameId(classNameIdAndClassTypePK);

			if (!existClassName(oldClassNameId)) {
				continue;
			}

			long newClassNameId = getNewClassNameId(oldClassNameId);

			_classNameIds = ArrayUtil.append(_classNameIds, newClassNameId);

			long oldClassTypePK = getClassTypePK(classNameIdAndClassTypePK);

			long newClassTypePK = getNewClassTypePK(
				oldClassNameId, newClassNameId, oldClassTypePK);

			_classTypePKs = ArrayUtil.append(_classTypePKs, newClassTypePK);

			_requireds = ArrayUtil.append(_requireds, required);
		}
	}

	protected JSONObject getMetadataJSONObject(long classNameId) {
		return _settingsMetadataJSONObject.getJSONObject(
			String.valueOf(classNameId));
	}

	protected long getNewClassNameId(long classNameId) {
		if (classNameId == AssetCategoryConstants.ALL_CLASS_NAME_ID) {
			return AssetCategoryConstants.ALL_CLASS_NAME_ID;
		}

		JSONObject metadataJSONObject = getMetadataJSONObject(classNameId);

		String className = metadataJSONObject.getString("className");

		return _classNameLocalService.getClassNameId(className);
	}

	protected long getNewClassTypePK(
		long oldClassNameId, long newClassNameId, long oldClassTypePK) {

		if (oldClassTypePK == AssetCategoryConstants.ALL_CLASS_TYPE_PK) {
			return AssetCategoryConstants.ALL_CLASS_TYPE_PK;
		}

		AssetRendererFactory<?> assetRendererFactory =
			AssetRendererFactoryRegistryUtil.
				getAssetRendererFactoryByClassNameId(newClassNameId);

		ClassTypeReader classTypeReader =
			assetRendererFactory.getClassTypeReader();

		List<ClassType> availableClassTypes =
			classTypeReader.getAvailableClassTypes(_groupIds, _locale);

		JSONObject metadataJSONObject = getMetadataJSONObject(oldClassNameId);

		JSONObject classTypesJSONObject = metadataJSONObject.getJSONObject(
			"classTypes");

		String classTypeName = classTypesJSONObject.getString(
			String.valueOf(oldClassTypePK));

		for (ClassType classType : availableClassTypes) {
			String curClassTypeName = classType.getName();

			if (curClassTypeName.equals(classTypeName)) {
				return classType.getClassTypeId();
			}
		}

		if (_log.isWarnEnabled()) {
			_log.warn("No class type found for " + classTypeName);
		}

		return AssetCategoryConstants.ALL_CLASS_TYPE_PK;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AssetVocabularySettingsImportHelper.class);

	private long[] _classNameIds = new long[0];
	private final ClassNameLocalService _classNameLocalService;
	private long[] _classTypePKs = new long[0];
	private final long[] _groupIds;
	private final Locale _locale;
	private boolean[] _requireds = new boolean[0];
	private final JSONObject _settingsMetadataJSONObject;

}