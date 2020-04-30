/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.internal.change.tracking.listener;

import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetTagLocalService;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;
import com.liferay.change.tracking.listener.CTEventListener;
import com.liferay.change.tracking.model.CTCollection;
import com.liferay.petra.lang.SafeClosable;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.change.tracking.CTCollectionThreadLocal;
import com.liferay.portal.kernel.dao.orm.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(service = CTEventListener.class)
public class AssetTagCTEventListener implements CTEventListener {

	@Override
	public void onAfterCopy(
		CTCollection sourceCTCollection, CTCollection targetCTCollection) {

		try (SafeClosable safeClosable =
				CTCollectionThreadLocal.setCTCollectionId(
					targetCTCollection.getCtCollectionId())) {

			_recalculateAssetCount(targetCTCollection.getCtCollectionId());
		}
	}

	@Override
	public void onBeforePublish(long ctCollectionId) {
		_recalculateAssetCount(ctCollectionId);
	}

	private void _recalculateAssetCount(long ctCollectionId) {
		_assetTagLocalService.updateWithUnsafeFunction(
			assetTagCTPersistence -> {
				AssetTagPersistence assetTagPersistence =
					(AssetTagPersistence)assetTagCTPersistence;

				Session session = assetTagCTPersistence.getCurrentSession();

				session.apply(
					connection -> {
						String sql = StringBundler.concat(
							"select distinct tagId from ",
							"AssetEntries_AssetTags where ctCollectionId = ",
							ctCollectionId);

						try (PreparedStatement preparedStatement =
								connection.prepareStatement(sql);
							ResultSet resultSet =
								preparedStatement.executeQuery()) {

							while (resultSet.next()) {
								long tagId = resultSet.getLong(1);

								AssetTag assetTag =
									assetTagPersistence.fetchByPrimaryKey(
										tagId);

								if (assetTag == null) {
									continue;
								}

								int assetCount =
									assetTagPersistence.getAssetEntriesSize(
										tagId);

								if (assetTag.getAssetCount() != assetCount) {
									assetTag.setAssetCount(assetCount);

									assetTagPersistence.update(assetTag);
								}
							}
						}
					});

				session.flush();

				session.clear();

				return null;
			});
	}

	@Reference
	private AssetTagLocalService _assetTagLocalService;

}