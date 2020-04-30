/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.internal.service;

import com.liferay.fragment.contributor.FragmentCollectionContributorRegistration;
import com.liferay.layout.internal.util.DefaultLayoutDefinitionImporter;
import com.liferay.layout.util.LayoutCopyHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutSetPrototype;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutSetPrototypeLocalService;
import com.liferay.portal.kernel.service.LayoutSetPrototypeLocalServiceWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class DefaultLayoutLayoutSetPrototypeLocalServiceWrapper
	extends LayoutSetPrototypeLocalServiceWrapper {

	public DefaultLayoutLayoutSetPrototypeLocalServiceWrapper() {
		super(null);
	}

	public DefaultLayoutLayoutSetPrototypeLocalServiceWrapper(
		LayoutSetPrototypeLocalService layoutSetPrototypeLocalService) {

		super(layoutSetPrototypeLocalService);
	}

	@Override
	public LayoutSetPrototype addLayoutSetPrototype(
			long userId, long companyId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean active,
			boolean layoutsUpdateable, ServiceContext serviceContext)
		throws PortalException {

		LayoutSetPrototype layoutSetPrototype = super.addLayoutSetPrototype(
			userId, companyId, nameMap, descriptionMap, active,
			layoutsUpdateable, serviceContext);

		if (GetterUtil.getBoolean(
				serviceContext.getAttribute("addDefaultLayout"), true)) {

			Layout defaultLayout = _layoutLocalService.addLayout(
				userId, layoutSetPrototype.getGroupId(), true,
				LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, "Home", null, null,
				LayoutConstants.TYPE_CONTENT, false, "/home", serviceContext);

			Layout draftLayout = _layoutLocalService.fetchLayout(
				_portal.getClassNameId(Layout.class.getName()),
				defaultLayout.getPlid());

			String currentName = PrincipalThreadLocal.getName();

			PrincipalThreadLocal.setName(String.valueOf(userId));

			try {
				_defaultLayoutDefinitionImporter.importDefaultLayoutDefinition(
					draftLayout, serviceContext);

				defaultLayout = _layoutCopyHelper.copyLayout(
					draftLayout, defaultLayout);

				_layoutLocalService.updatePriority(
					defaultLayout.getPlid(), LayoutConstants.FIRST_PRIORITY);

				_layoutLocalService.updateStatus(
					userId, defaultLayout.getPlid(),
					WorkflowConstants.STATUS_APPROVED, serviceContext);

				_layoutLocalService.updateStatus(
					userId, draftLayout.getPlid(),
					WorkflowConstants.STATUS_APPROVED, serviceContext);
			}
			catch (Exception exception) {
				throw new PortalException(exception);
			}
			finally {
				PrincipalThreadLocal.setName(currentName);
			}
		}

		return layoutSetPrototype;
	}

	@Reference(
		target = "(fragment.collection.key=BASIC_COMPONENT)", unbind = "-"
	)
	protected void setFragmentCollectionContributorRegistration(
		FragmentCollectionContributorRegistration
			fragmentCollectionContributorRegistration) {
	}

	@Reference
	private DefaultLayoutDefinitionImporter _defaultLayoutDefinitionImporter;

	@Reference
	private LayoutCopyHelper _layoutCopyHelper;

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private Portal _portal;

}