/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DDMTemplateLink service. Represents a row in the &quot;DDMTemplateLink&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DDMTemplateLinkModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.dynamic.data.mapping.model.impl.DDMTemplateLinkImpl"
)
@ProviderType
public interface DDMTemplateLink extends DDMTemplateLinkModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.dynamic.data.mapping.model.impl.DDMTemplateLinkImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DDMTemplateLink, Long>
		TEMPLATE_LINK_ID_ACCESSOR = new Accessor<DDMTemplateLink, Long>() {

			@Override
			public Long get(DDMTemplateLink ddmTemplateLink) {
				return ddmTemplateLink.getTemplateLinkId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DDMTemplateLink> getTypeClass() {
				return DDMTemplateLink.class;
			}

		};

	public DDMTemplate getTemplate()
		throws com.liferay.portal.kernel.exception.PortalException;

}