/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.bulk.selection.action;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.bulk.selection.BulkSelection;
import com.liferay.bulk.selection.BulkSelectionAction;
import com.liferay.document.library.bulk.selection.EditCategoriesBulkSelectionAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionCheckerUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	service = {
		BulkSelectionAction.class, EditCategoriesBulkSelectionAction.class,
		EditCategoriesBulkSelectionActionImpl.class
	}
)
public class EditCategoriesBulkSelectionActionImpl
	implements EditCategoriesBulkSelectionAction {

	@Override
	public void execute(
			User user, BulkSelection<AssetEntry> bulkSelection,
			Map<String, Serializable> inputMap)
		throws Exception {

		long[] toAddCategoryIds = _getLongArray(inputMap, "toAddCategoryIds");

		Set<Long> toAddCategoryIdsSet = SetUtil.fromArray(toAddCategoryIds);

		Set<Long> toRemoveCategoryIdsSet = SetUtil.fromArray(
			_getLongArray(inputMap, "toRemoveCategoryIds"));

		PermissionChecker permissionChecker =
			PermissionCheckerFactoryUtil.create(user);

		bulkSelection.forEach(
			assetEntry -> {
				try {
					if (!BaseModelPermissionCheckerUtil.
							containsBaseModelPermission(
								permissionChecker, assetEntry.getGroupId(),
								assetEntry.getClassName(),
								assetEntry.getClassPK(), ActionKeys.UPDATE)) {

						return;
					}

					long[] newCategoryIds = toAddCategoryIds;

					if (MapUtil.getBoolean(inputMap, "append")) {
						Set<Long> currentCategoryIdsSet = SetUtil.fromArray(
							assetEntry.getCategoryIds());

						currentCategoryIdsSet.removeAll(toRemoveCategoryIdsSet);

						currentCategoryIdsSet.addAll(toAddCategoryIdsSet);

						newCategoryIds = ArrayUtil.toLongArray(
							currentCategoryIdsSet);
					}

					_assetEntryLocalService.updateEntry(
						assetEntry.getUserId(), assetEntry.getGroupId(),
						assetEntry.getClassName(), assetEntry.getClassPK(),
						newCategoryIds, assetEntry.getTagNames());
				}
				catch (PortalException portalException) {
					if (_log.isWarnEnabled()) {
						_log.warn(portalException, portalException);
					}
				}
			});
	}

	private long[] _getLongArray(Map<String, Serializable> map, String key) {
		return ArrayUtil.toArray((Long[])map.getOrDefault(key, new Long[0]));
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditCategoriesBulkSelectionActionImpl.class);

	@Reference
	private AssetEntryLocalService _assetEntryLocalService;

}