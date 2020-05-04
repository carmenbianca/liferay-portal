/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the WeDeployAuthToken service. Represents a row in the &quot;WeDeployAuth_WeDeployAuthToken&quot; database table, with each column mapped to a property of this class.
 *
 * @author Supritha Sundaram
 * @see WeDeployAuthTokenModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.portal.security.wedeploy.auth.model.impl.WeDeployAuthTokenImpl"
)
@ProviderType
public interface WeDeployAuthToken
	extends PersistedModel, WeDeployAuthTokenModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portal.security.wedeploy.auth.model.impl.WeDeployAuthTokenImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WeDeployAuthToken, Long>
		WE_DEPLOY_AUTH_TOKEN_ID_ACCESSOR =
			new Accessor<WeDeployAuthToken, Long>() {

				@Override
				public Long get(WeDeployAuthToken weDeployAuthToken) {
					return weDeployAuthToken.getWeDeployAuthTokenId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<WeDeployAuthToken> getTypeClass() {
					return WeDeployAuthToken.class;
				}

			};

}