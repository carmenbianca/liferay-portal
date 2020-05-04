/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.categories.internal.search;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Luan Maoski
 * @author Lucas Marques
 */
@Component(immediate = true, service = {})
public class AssetCategorySearchRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = modelSearchRegistrarHelper.register(
			AssetCategory.class, bundleContext,
			modelSearchDefinition -> {
				modelSearchDefinition.setDefaultSelectedFieldNames(
					Field.ASSET_CATEGORY_ID, Field.COMPANY_ID, Field.GROUP_ID,
					Field.UID);
				modelSearchDefinition.setModelIndexWriteContributor(
					modelIndexWriterContributor);
			});
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference(
		target = "(indexer.class.name=com.liferay.asset.kernel.model.AssetCategory)"
	)
	protected ModelIndexerWriterContributor<AssetCategory>
		modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	private ServiceRegistration<?> _serviceRegistration;

}